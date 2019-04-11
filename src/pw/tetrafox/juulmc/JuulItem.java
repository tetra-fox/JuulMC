package pw.tetrafox.juulmc;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JuulItem extends ItemStack {
	public ItemStack juul;
	
	JuulItem() {
		juul = new ItemStack(Material.MILK_BUCKET, 1);

		ItemMeta meta = juul.getItemMeta();

		meta.setDisplayName(ChatColor.RESET + "JUUL");
		meta.setLore(Arrays.asList(ChatColor.RESET + "" + ChatColor.DARK_PURPLE + "that's 50 nic"));

		juul.setItemMeta(meta);
	}
}
