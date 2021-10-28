package me.shadowrg.wroxbedwars;

import org.bukkit.plugin.java.JavaPlugin;

public final class WroxBedwars extends JavaPlugin {

    @Override
    public void onEnable() {
       getLogger().info("Plugin in testing..");
       getLogger().info("Version: " + getDescription().getVersion());
       PluginCore pluginCore = new PluginCore(this);
       pluginCore.init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
