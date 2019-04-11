package pw.tetrafox.juulmc;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// i apologize for my code in advance, i have never written java before
// and went into this without reading anything prior
// also no comments because i'm too lazy

public class Main extends JavaPlugin {
	public static FileConfiguration config;
	public static Main instance;

	@Override
	public void onEnable() {
		Main.instance = this;

		config = getConfig();
		saveDefaultConfig();

		getServer().getPluginManager().registerEvents(new DrinkListener(), this);
		getServer().getPluginManager().registerEvents(new CraftListener(), this);

		JuulRecipe.importJuulRecipe();

		this.getCommand("juul").setExecutor(new CommandJuul());
	}

	@Override
	public void onDisable() {
		Main.instance = null;
	}
}