package fr.enderstevegamer.arcanauhc.utils;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.logging.Level;

public class PlayerUtils {
    public static void removeOneItem(Player player, Material material) {
        ItemStack[] itemStacks = player.getInventory().getContents();
        for (ItemStack itemStack : itemStacks) {
            if (itemStack == null) continue;
            if (itemStack.getType().equals(material)) {
                itemStack.setAmount(
                        itemStack.getAmount() - 1
                );
                break;
            }
        }
        player.getInventory().setContents(itemStacks);
    }

    public static void equipStartingStuff(Player player) {
        player.getInventory().setArmorContents(ArraysUtils.invertArray(GameSettings.getStartingArmor()));
        Bukkit.getLogger().log(Level.INFO, "Starting");
        for (int i = 9; i <= 35; i++) {
            player.getInventory().setItem(i, GameSettings.getStartingInventory()[i - 9]);
        }
        for (int i = 0; i < 9; i++) {
            player.getInventory().setItem(i, GameSettings.getStartingInventory()[27 + i]);
        }
    }

    public static Block getBlockUnder(Player player) {
        return player.getWorld().getBlockAt(player.getLocation().add(new Vector(0, -1, 0)));
    }
}
