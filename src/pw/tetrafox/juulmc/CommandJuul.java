package pw.tetrafox.juulmc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandJuul implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player && sender.hasPermission("juulmc.command.use")) {
			Player p = (Player) sender;
			ItemStack juul = new JuulItem().juul;

			// shut up it works so i don't care
			try {
				juul.setAmount(Integer.parseInt(args[0]));
			} catch (Exception e) {
				juul.setAmount(1);
			}
			
			p.getInventory().addItem(juul);
		} else if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
		}
		
		return true;
	}
}