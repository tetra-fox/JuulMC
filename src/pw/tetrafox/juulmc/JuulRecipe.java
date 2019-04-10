package pw.tetrafox.juulmc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class JuulRecipe {
	public static void importJuulRecipe() {
		ItemStack item = new ItemStack(Material.MILK_BUCKET);

		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName("JUUL");
		meta.setLore(Arrays.asList("that's 50 nic"));

		item.setItemMeta(meta);

		NamespacedKey key = new NamespacedKey(Main.instance, "juul");
		ShapedRecipe juulRecipe = new ShapedRecipe(key, item);

		juulRecipe.shape(" R ", " S ", " I ");

		juulRecipe.setIngredient('R', Material.REDSTONE);
		juulRecipe.setIngredient('S', Material.STICK);
		juulRecipe.setIngredient('I', Material.IRON_INGOT);

		Bukkit.addRecipe(juulRecipe);
	}
}
