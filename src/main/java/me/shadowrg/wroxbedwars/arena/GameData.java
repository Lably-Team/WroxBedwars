package me.shadowrg.wroxbedwars.arena;

import java.util.HashMap;
import java.util.Map;

public class GameData {

    private final Map<String, Integer> teamPlayersSize = new HashMap<>();

    public int getSize(String team){
        return teamPlayersSize.get(team);
    }
}
