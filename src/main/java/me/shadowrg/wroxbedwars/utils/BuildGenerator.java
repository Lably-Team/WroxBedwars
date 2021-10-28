package me.shadowrg.wroxbedwars.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.graalvm.compiler.nodes.cfg.Block;

public class BuildGenerator {

    public static void createCage(Location location){

        for (int z = -2; z < 3; z++){
            for (int x = -2; x < 3; x++){
                location.add(x, 0, z).getBlock().setType(Material.GLASS);
                    if ((x > 1 || x < -1)){
                        location.add(x, 0, z).getBlock().setType(Material.GLASS);
                    }else{
                        if (z > 1 || z < -1){
                            location.add(x, 0, z).getBlock().setType(Material.GLASS);
                        }
                    }

                location.add(x, 3, z).getBlock().setType(Material.GLASS);
            }
        }
    }

    public static void deleteCage(Location location){

        for (int z = -2; z < 3; z++){
            for (int x = -2; x < 3; x++){
                location.add(x, 0, z).getBlock().setType(Material.AIR);
                if ((x > 1 || x < -1)){
                    location.add(x, 0, z).getBlock().setType(Material.AIR);
                }else{
                    if (z > 1 || z < -1){
                        location.add(x, 0, z).getBlock().setType(Material.AIR);
                    }
                }

                location.add(x, 3, z).getBlock().setType(Material.AIR);
            }
        }
    }
}
