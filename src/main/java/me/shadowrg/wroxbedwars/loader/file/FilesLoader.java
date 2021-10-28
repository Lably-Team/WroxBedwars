package me.shadowrg.wroxbedwars.loader.file;

import me.shadowrg.wroxbedwars.WroxBedwars;
import me.shadowrg.wroxbedwars.api.Loader;

public class FilesLoader implements Loader {

    private final WroxBedwars plugin;
    private FileManager configFile;

    public FilesLoader(WroxBedwars plugin){
        this.plugin = plugin;
    }
    @Override
    public void load() {
        // config.yml file
        configFile = new FileManager(plugin, "config.yml");

    }


    public FileManager getConfigFile() {
        return configFile;
    }
}
