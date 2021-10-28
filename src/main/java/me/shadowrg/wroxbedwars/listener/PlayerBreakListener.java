package me.shadowrg.wroxbedwars.listener;

import me.shadowrg.wroxbedwars.PluginCore;
import org.bukkit.block.data.type.Bed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakListener implements Listener {

    private PluginCore pluginCore;

    public PlayerBreakListener(PluginCore pluginCore){
        this.pluginCore = pluginCore;
    }
    // Event model
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if (!event.getPlayer().hasMetadata("arena_joined")){
            return;
        }

        if (!(event.getBlock().getBlockData() instanceof Bed)){
            return;
        }
    }
}
