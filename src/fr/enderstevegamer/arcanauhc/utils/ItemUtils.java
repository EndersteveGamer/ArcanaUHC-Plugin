package fr.enderstevegamer.arcanauhc.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {
    public static boolean isDiamondArmor(ItemStack item) {
        Material material = item.getData().getItemType();
        return (material.equals(Material.DIAMOND_HELMET) || material.equals(Material.DIAMOND_CHESTPLATE)
                || material.equals(Material.DIAMOND_LEGGINGS) || material.equals(Material.DIAMOND_BOOTS));
    }

    public static void enchantItem(ItemStack item, Enchantment enchant, int level, boolean bypassEnchantLimit) {
        final ItemMeta META = item.getItemMeta();
        META.addEnchant(enchant, level, bypassEnchantLimit);
        item.setItemMeta(META);
    }
}
