package pw.tetrafox.juulmc;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import pw.tetrafox.juulmc.DrinkListener;
import pw.tetrafox.juulmc.JuulRecipe;

public class Main extends JavaPlugin {
	public static FileConfiguration config;
	public static Main instance;
	
    @Override
    public void onEnable() {
        Main.instance = this;

    	config = getConfig();
    	saveDefaultConfig();
    	
    	getServer().getPluginManager().registerEvents(new DrinkListener(), this);
    	
    	JuulRecipe.importJuulRecipe();
    }

   @Override
   public void onDisable(){
	   Main.instance = null;
   }
}