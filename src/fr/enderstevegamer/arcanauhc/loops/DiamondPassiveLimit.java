package fr.enderstevegamer.arcanauhc.loops;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.utils.PlayerInfo;
import fr.enderstevegamer.arcanauhc.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class DiamondPassiveLimit extends BukkitRunnable {
    @Override
    public void run() {
        if (GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT) == -1) return;
        for (Player player : Bukkit.getOnlinePlayers()) {
            boolean b = false;
            while (PlayerInfo.getItemNumber(player, Material.DIAMOND) >
                    GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT)) {
                player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.DIAMOND));
                PlayerUtils.removeOneItem(player, Material.DIAMOND);
                b = true;
            }
            if (b) player.sendMessage(ChatColor.RED + "Vous avez démassé la limite de diamants, qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT));
        }
    }
}
