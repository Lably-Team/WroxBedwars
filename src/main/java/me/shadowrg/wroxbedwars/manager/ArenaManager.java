package me.shadowrg.wroxbedwars.manager;

import me.shadowrg.wroxbedwars.PluginCore;
import me.shadowrg.wroxbedwars.WroxBedwars;
import me.shadowrg.wroxbedwars.arena.ArenaData;
import me.shadowrg.wroxbedwars.arena.ColorTeam;
import me.shadowrg.wroxbedwars.utils.BuildGenerator;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.HashMap;
import java.util.Map;

public class ArenaManager {

    private final Map<String, ArenaData> arenaDatas = new HashMap<>();

    private final WroxBedwars wroxBedwars;
    private final SenderManager senderManager;

    public ArenaManager(PluginCore pluginCore){
        this.senderManager = pluginCore.getManagers().getSender();
        this.wroxBedwars = pluginCore.getPlugin();
    }
    public void createArena(Player player, String arenaName){
        arenaDatas.put(arenaName, new ArenaData(arenaName, 2));
        senderManager.sendMessage(player, "Arena creada. " + arenaName);
    }
    public void deleteArena(Player player, String arenaName){
        arenaDatas.remove(arenaName);
        senderManager.sendMessage(player, "Arena eliminada. " + arenaName);
    }

    public boolean arenaExists(String arenaName){
        return arenaDatas.containsKey(arenaName);
    }

    public Map<String, ArenaData> getArenas(){
        return arenaDatas;
    }

    public ArenaData getArena(String arenaName){
        return arenaDatas.get(arenaName);
    }

    public void joinPlayer(Player player, String arenaName, String teamColor){
        ArenaData arenaData = arenaDatas.get(arenaName);

        ColorTeam colorTeam = ColorTeam.valueOf(teamColor.toUpperCase());

        if (arenaData.getTeam(colorTeam) == null){
            senderManager.sendMessage(player, "El color no existe: " + teamColor);
            return;
        }



        int teamSize = arenaData.getGameData().getSize(teamColor);
        Location location = arenaData.getTeam(colorTeam).getLobbyLocation();


        if (teamSize == 0) {
            BuildGenerator.createCage(location);
        }

        player.setMetadata("arena_joined", new FixedMetadataValue(wroxBedwars, arenaName));
        player.setMetadata("last_location", new FixedMetadataValue(wroxBedwars, player.getLocation()));
        player.setMetadata("bed_color", new FixedMetadataValue(wroxBedwars, teamColor));
        player.teleport(location);
        senderManager.sendMessage(player, "Te uniste a la arena: " + arenaName);
    }

    public void quitPlayer(Player player) {

        if (!player.hasMetadata("arena_joined")){
            senderManager.sendMessage(player, "Error: No estas en ninguna arena.");
        }

        ArenaData arenaData = arenaDatas.get(player.getMetadata("arena_joined"));

        String playerColor = player.getMetadata("bed_color").get(0).asString();
        int teamSize = arenaData.getGameData().getSize(playerColor);

        Location location = arenaData.getTeam(ColorTeam.valueOf(player.getMetadata("bed_color").get(0).asString().toUpperCase())).getLobbyLocation();

        if (teamSize == 0) {
            BuildGenerator.deleteCage(location);
        }

        player.teleport((Location) player.getMetadata("last_location").get(0).value());
        player.removeMetadata("arena_joined", wroxBedwars);
        player.removeMetadata("last_location", wroxBedwars);
        player.removeMetadata("bed_color", wroxBedwars);
        senderManager.sendMessage(player, "Te saliste la arena.");
    }

    public void startGame(String arenaName){

    }
}
