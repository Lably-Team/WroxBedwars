package me.shadowrg.wroxbedwars.arena;

import org.bukkit.Location;

public class ArenaTeamData {

    private ColorTeam teamColor;

    private Location lobbyLocation;
    private Location bedLocation;

    public ArenaTeamData(ColorTeam teamColor){
        this.teamColor = teamColor;
    }

    public void setTeamColor(ColorTeam teamColor){
        this.teamColor = teamColor;
    }

    public void setLobbyLocation(Location location){
        this.lobbyLocation = location;
    }

    public void setBedLocation(Location location){
        this.bedLocation = location;
    }

    public Location getBedLocation(){
        return bedLocation;
    }

    public Location getLobbyLocation(){
        return lobbyLocation;
    }
}
