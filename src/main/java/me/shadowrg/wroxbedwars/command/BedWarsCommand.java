package me.shadowrg.wroxbedwars.command;

import me.shadowrg.wroxbedwars.PluginCore;
import me.shadowrg.wroxbedwars.manager.ArenaManager;
import me.shadowrg.wroxbedwars.manager.SenderManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedWarsCommand implements CommandExecutor{

    private final ArenaManager arenaManager;
    private final SenderManager senderManager;

    public BedWarsCommand(PluginCore pluginCore){
        this.arenaManager = pluginCore.getManagers().getArenaManager();
        this.senderManager = pluginCore.getManagers().getSender();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        switch (args[0]){
            case "start":
            case "create":
                if (args.length < 2){
                    senderManager.sendMessage(player, "Uso incorrecto: /bedwars create [<arena>]");
                    return false;
                }

                String arenaName = args[1];

                if (arenaManager.arenaExists(arenaName)){
                    senderManager.sendMessage(player, "Error: La arena " + arenaName + " ya existe.");
                    return false;
                }

                arenaManager.createArena(player, arenaName);
                senderManager.sendMessage(player, "Arena creada: " + arenaName);
                return false;
            case "delete":
                if (args.length < 2){
                    senderManager.sendMessage(player, "Uso incorrecto: /bedwars delete [<arena>]");
                    return false;
                }

                String beforeDeletedArenaName = args[1];

                if (!arenaManager.arenaExists(beforeDeletedArenaName)){
                    senderManager.sendMessage(player, "Error: La arena " + beforeDeletedArenaName + " no existe.");
                    return false;
                }

                arenaManager.deleteArena(player, beforeDeletedArenaName);
                senderManager.sendMessage(player, "Arena eliminada: " + beforeDeletedArenaName);
                return false;
            case "arena":
                if (args.length < 2){
                    senderManager.sendMessage(player, "Uso incorrecto: /bedwars arena [arena]");
                    return false;
                }

                String selectedArenaName = args[1];

                if (!arenaManager.arenaExists(selectedArenaName)){
                    senderManager.sendMessage(player, "La arena no existe. " + selectedArenaName);
                    return false;
                }

                return false;
            case "join":
                if (args.length < 2){
                    senderManager.sendMessage(player, "Uso incorrecto: /bedwars join [<arena>] [<color>]");
                    return false;
                }

                String arenaNameToJoin = args[1];

                if (!arenaManager.arenaExists(arenaNameToJoin)){
                    senderManager.sendMessage(player, "Error: La arena " + arenaNameToJoin + " no existe.");
                    return false;
                }

                if (args.length < 3){
                    senderManager.sendMessage(player, "Uso incorrecto: /bedwars join [<arena>] [<color>]");
                    return false;
                }

                String bedColorName = args[2];

                arenaManager.joinPlayer(player, arenaNameToJoin, bedColorName);
                return false;
            case "quit":
                arenaManager.quitPlayer(player);
            case "reload":
                senderManager.sendMessage(player, "Plugin recargado.",
                                                        "Argumento en mantenimiento");
                return false;

        }
        return false;
    }
}
