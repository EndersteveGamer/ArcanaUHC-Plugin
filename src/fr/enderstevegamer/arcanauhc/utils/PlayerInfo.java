package fr.enderstevegamer.arcanauhc.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PlayerInfo {
    public static int diamondArmorCount(Player player) {
        int count = 0;
        ItemStack[] armors = player.getInventory().getArmorContents();
        for (ItemStack item : armors) {
            if (ItemUtils.isDiamondArmor(item)) count++;
        }
        return count;
    }

    public static int getItemNumber(Player player, Material material) {
        int i = 0;
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack == null) continue;
            if (itemStack.getType().equals(material)) {
                i += itemStack.getAmount();
            }
        }
        return i;
    }

    public static boolean isInLava(Player player) {
        Location location = player.getLocation().getBlock().getLocation();
        Location location1 = location.clone().add(new Vector(0, 1, 0));
        Material mat = player.getWorld().getBlockAt(location).getType();
        Material mat1 = player.getWorld().getBlockAt(location1).getType();
        return (BlockUtils.isLavaBlock(mat) || BlockUtils.isLavaBlock(mat1));
    }
}
