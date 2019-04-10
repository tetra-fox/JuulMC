package pw.tetrafox.juulmc;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Particle;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrinkListener implements Listener {
	@EventHandler
	public void onPlayerConsume(PlayerItemConsumeEvent e) {
		Material item = e.getItem().getType();
		String itemDisplayName = e.getItem().getItemMeta().getDisplayName();
		if (item.equals(Material.MILK_BUCKET) && itemDisplayName.toLowerCase().equals("juul")) {
			e.setCancelled(true);

			Player p = e.getPlayer();

			int particleCount = Main.config.getInt("particleCount");

			Location loc = p.getEyeLocation();
			loc = loc.add(loc.getDirection().multiply(0.75));

			p.getWorld().spawnParticle(Particle.SPIT, loc.getX(), loc.getY(), loc.getZ(), particleCount, 0, 0, 0, 0.1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 1));
			p.getInventory().removeItem(p.getInventory().getItemInMainHand());
		}
	}
}