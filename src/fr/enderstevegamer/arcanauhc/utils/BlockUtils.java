package fr.enderstevegamer.arcanauhc.utils;

import org.bukkit.Material;

public class BlockUtils {
    public static boolean isLavaBlock(Material material) {
        return (material.equals(Material.STATIONARY_LAVA) || material.equals(Material.LAVA));
    }

    public static boolean isWaterBlock(Material material) {
        return (material.equals(Material.STATIONARY_WATER) || material.equals(Material.WATER));
    }
}
