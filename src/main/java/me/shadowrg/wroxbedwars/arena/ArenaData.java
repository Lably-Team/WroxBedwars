package me.shadowrg.wroxbedwars.arena;

import java.util.HashMap;
import java.util.Map;

public class ArenaData {

    private final Map<ColorTeam, ArenaTeamData> arenaTeams = new HashMap<>();

    private final String arenaName;
    private final int teamSize;

    private final GameData gameData;

    public ArenaData(String arenaName, int teamSize){
        this.arenaName = arenaName;
        this.teamSize = teamSize;
        this.gameData = new GameData();
    }

    public void addTeam(ColorTeam colorTeam){
        arenaTeams.put(colorTeam, new ArenaTeamData(colorTeam));
    }

    public ArenaTeamData getTeam(ColorTeam colorTeam){
        return arenaTeams.get(colorTeam);
    }

    public int getTeamSize(){
        return teamSize;
    }

    public GameData getGameData() {
        return gameData;
    }
}
