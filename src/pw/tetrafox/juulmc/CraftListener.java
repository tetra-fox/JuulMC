package pw.tetrafox.juulmc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class CraftListener implements Listener {
	@EventHandler
	public void onPrepareCraft(PrepareItemCraftEvent e) {
		Recipe recipe = e.getRecipe();

		if (recipe == null) {
			return;
		}
		
		ItemStack result = recipe.getResult();
		InventoryHolder holder = e.getInventory().getHolder();

		if (holder instanceof Player) {
			Player player = (Player) holder;
			if (result.equals(new JuulItem().juul) && !player.hasPermission("juulmc.craft")) {
				e.getInventory().setResult(null);
			}
		}
	}
}
