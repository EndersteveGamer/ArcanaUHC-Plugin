package fr.enderstevegamer.arcanauhc.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemUtils {
    public static boolean isDiamondArmor(ItemStack item) {
        Material material = item.getData().getItemType();
        return (material.equals(Material.DIAMOND_HELMET) || material.equals(Material.DIAMOND_CHESTPLATE)
                || material.equals(Material.DIAMOND_LEGGINGS) || material.equals(Material.DIAMOND_BOOTS));
    }
}
