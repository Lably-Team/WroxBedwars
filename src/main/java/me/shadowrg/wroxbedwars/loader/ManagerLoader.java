package me.shadowrg.wroxbedwars.loader;

import me.shadowrg.wroxbedwars.PluginCore;
import me.shadowrg.wroxbedwars.api.Loader;
import me.shadowrg.wroxbedwars.manager.ArenaManager;
import me.shadowrg.wroxbedwars.manager.SenderManager;

public class ManagerLoader implements Loader {

    private final PluginCore pluginCore;

    private SenderManager senderManager;
    private ArenaManager arenaManager;

    public ManagerLoader(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public void load() {
        this.senderManager = new SenderManager();
        this.arenaManager = new ArenaManager(pluginCore);
    }

    public SenderManager getSender(){
        return senderManager;
    }

    public ArenaManager getArenaManager(){
        return arenaManager;
    }
}
