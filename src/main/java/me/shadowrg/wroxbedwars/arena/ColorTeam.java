package me.shadowrg.wroxbedwars.arena;

import org.bukkit.Material;

public enum ColorTeam {
    RED("red", Material.RED_BED),
    GREEN("green", Material.GREEN_BED),
    BLUE("blue", Material.BLUE_BED),
    YELLOW("yellow", Material.YELLOW_BED),
    CYAN("cyan", Material.CYAN_BED),
    ORANGE("orange", Material.ORANGE_BED),
    PINK("pink", Material.PINK_BED),
    PURPLE("purple", Material.PURPLE_BED),
    BROWN("brown", Material.BROWN_BED),
    BLACK("black", Material.BLACK_BED),
    WHITE("white", Material.WHITE_BED),
    GRAY("gray", Material.GRAY_BED);

    private final String colorName;
    private final Material material;

    ColorTeam(String colorName, Material material){
        this.colorName = colorName;
        this.material = material;
    }

    public String getColorName() {
        return colorName;
    }

    public Material getMaterial() {
        return material;
    }
}
