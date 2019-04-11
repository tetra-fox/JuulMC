package pw.tetrafox.juulmc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class JuulRecipe {
	public static void importJuulRecipe() {
		ItemStack juul = new JuulItem().juul;

		NamespacedKey key = new NamespacedKey(Main.instance, "juul");
		ShapedRecipe juulRecipe = new ShapedRecipe(key, juul);

		juulRecipe.shape(" R ", " S ", " I ");

		juulRecipe.setIngredient('R', Material.REDSTONE);
		juulRecipe.setIngredient('S', Material.STICK);
		juulRecipe.setIngredient('I', Material.IRON_INGOT);

		Bukkit.addRecipe(juulRecipe);
	}
}
