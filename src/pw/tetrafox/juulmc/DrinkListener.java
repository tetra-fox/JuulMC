package pw.tetrafox.juulmc;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrinkListener implements Listener {
	@EventHandler
	public void onPlayerConsume(PlayerItemConsumeEvent e) {
		ItemStack item = e.getItem();
		String itemDisplayName = item.getItemMeta().getDisplayName();
		List<String> itemLore = item.getItemMeta().getLore();

		// comparison juul
		ItemStack comp = new JuulItem().juul;
		String compDisplayName = comp.getItemMeta().getDisplayName();
		List<String> compLore = comp.getItemMeta().getLore();

		if (item.getType().equals(comp.getType()) && itemDisplayName.equalsIgnoreCase(compDisplayName)
				&& itemLore.get(0).equalsIgnoreCase(compLore.get(0))) {
			e.setCancelled(true);

			Player p = e.getPlayer();

			int particleCount = Main.config.getInt("particleCount");

			Location loc = p.getEyeLocation();
			loc = loc.add(loc.getDirection().multiply(0.75));

			p.getWorld().spawnParticle(Particle.SPIT, loc.getX(), loc.getY(), loc.getZ(), particleCount, 0, 0, 0, 0.1);
			p.getWorld().playSound(loc, Sound.ENTITY_HORSE_BREATHE, 1, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 1));

			// did you know that nicotine is an appetite suppressant
			boolean appetiteSuppress = Main.config.getBoolean("appetiteSuppress");
			if (appetiteSuppress) {
				p.setFoodLevel(p.getFoodLevel() + 1);
			}

			ItemStack currentItem = p.getInventory().getItemInMainHand();

			currentItem.setAmount(currentItem.getAmount() - 1);
		}
	}
}