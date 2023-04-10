package fr.enderstevegamer.arcanauhc.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
}
