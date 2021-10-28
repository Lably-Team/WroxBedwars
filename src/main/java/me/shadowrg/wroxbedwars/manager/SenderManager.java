package me.shadowrg.wroxbedwars.manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class SenderManager {


    public void sendMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void sendMessage(Player player, String... messages){
        for (String message : messages){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }
}
