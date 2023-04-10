package fr.enderstevegamer.arcanauhc.loops;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.utils.ItemUtils;
import fr.enderstevegamer.arcanauhc.utils.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ArmorPassiveLimit extends BukkitRunnable {
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (PlayerInfo.diamondArmorCount(player) >
                    GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT)) {
                String slot = null;
                for (int i = 3; i >= 0; i--) {
                    if (player.getInventory().getArmorContents()[i] != null
                            && ItemUtils.isDiamondArmor(player.getInventory().getArmorContents()[i])) {
                        if (i == 0) slot = "boots";
                        else if (i == 1) slot = "leggings";
                        else if (i == 2) slot = "chestplate";
                        else slot = "helmet";
                        break;
                    }
                }
                if (slot != null) {
                    ItemStack item;
                    switch (slot) {
                        case "boots":
                            item = player.getInventory().getBoots().clone();
                            player.getInventory().setBoots(new ItemStack(Material.AIR));
                            break;
                        case "leggings":
                            item = player.getInventory().getLeggings().clone();
                            player.getInventory().setLeggings(new ItemStack(Material.AIR));
                            break;
                        case "chestplate":
                            item = player.getInventory().getChestplate().clone();
                            player.getInventory().setChestplate(new ItemStack(Material.AIR));
                            break;
                        default:
                            item = player.getInventory().getHelmet().clone();
                            player.getInventory().setHelmet(new ItemStack(Material.AIR));
                            break;
                    }
                    Item itemDropped = player.getWorld().dropItemNaturally(player.getLocation(), item);
                    itemDropped.setPickupDelay(20);
                    player.sendMessage(ChatColor.RED + "Vous avez dépassé la limite de pièces d'armure en diamant, qui est de "
                            + GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT));
                }
            }
        }
    }
}
