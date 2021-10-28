package me.shadowrg.wroxbedwars;

import me.shadowrg.wroxbedwars.api.Core;
import me.shadowrg.wroxbedwars.api.Loader;
import me.shadowrg.wroxbedwars.loader.CommandsLoader;
import me.shadowrg.wroxbedwars.loader.file.FilesLoader;
import me.shadowrg.wroxbedwars.loader.ListenersLoader;
import me.shadowrg.wroxbedwars.loader.ManagerLoader;

public class PluginCore implements Core{

    private final WroxBedwars plugin;

    private FilesLoader filesLoader;
    private ManagerLoader managerLoader;

    public PluginCore(WroxBedwars plugin){
        this.plugin = plugin;
    }

    @Override
    public void init() {
        filesLoader = new FilesLoader(plugin);
        filesLoader.load();

        managerLoader = new ManagerLoader(this);
        managerLoader.load();

        initLoaders(
                new CommandsLoader(this),
                new ListenersLoader(this));
    }


    private void initLoaders(Loader... loaders){
        for (Loader loader : loaders){
            loader.load();
        }
    }


    public FilesLoader getFilesLoader() {
        return filesLoader;
    }

    public WroxBedwars getPlugin(){
        return plugin;
    }

    public ManagerLoader getManagers(){
        return managerLoader;
    }
}
