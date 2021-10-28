package me.shadowrg.wroxbedwars.loader;

import me.shadowrg.wroxbedwars.PluginCore;
import me.shadowrg.wroxbedwars.WroxBedwars;
import me.shadowrg.wroxbedwars.api.Loader;
import me.shadowrg.wroxbedwars.listener.PlayerBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;


public class ListenersLoader implements Loader {

    private final PluginCore pluginCore;

    public ListenersLoader(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public void load() {
        registerListeners(
                new PlayerBreakListener(pluginCore));
    }

    public void registerListeners(Listener... listeners){
        PluginManager pluginManager = Bukkit.getPluginManager();
        WroxBedwars wroxBedwars = pluginCore.getPlugin();

        for (Listener listener : listeners){
            pluginManager.registerEvents(listener, wroxBedwars);
        }
    }
}
