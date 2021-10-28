package me.shadowrg.wroxbedwars.loader;

import me.shadowrg.wroxbedwars.PluginCore;
import me.shadowrg.wroxbedwars.api.Loader;
import me.shadowrg.wroxbedwars.command.BedWarsCommand;
import me.shadowrg.wroxbedwars.command.builder.ExecutorBuilder;
import org.bukkit.Bukkit;

public class CommandsLoader implements Loader {

    private final PluginCore pluginCore;

    public CommandsLoader(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }

    @Override
    public void load() {
        registerCommands(
                new ExecutorBuilder("bedwars", new BedWarsCommand(pluginCore)));
    }

    public void registerCommands(ExecutorBuilder... executorBuilders){

        for (ExecutorBuilder executorBuilder : executorBuilders){
            Bukkit.getPluginCommand(executorBuilder.getCommandName()).setExecutor(executorBuilder.getCommandExecutor());
        }
    }
}
