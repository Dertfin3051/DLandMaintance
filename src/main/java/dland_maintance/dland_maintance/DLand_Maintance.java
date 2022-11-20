package dland_maintance.dland_maintance;

import org.bukkit.plugin.java.JavaPlugin;

public final class DLand_Maintance extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("maintance").setExecutor(new Maintance());
        getCommand("maintance").setTabCompleter(new MaintanceCompleter());
        getServer().getPluginManager().registerEvents(new MaintanceEvent(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
