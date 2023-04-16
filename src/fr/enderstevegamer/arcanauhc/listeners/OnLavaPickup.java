package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class OnLavaPickup implements Listener {
    @EventHandler
    public static void onLavaPickup(PlayerBucketFillEvent event) {
        if (event.getBlockClicked().getType().equals(Material.STATIONARY_LAVA)
                && !GameSettings.getBooleanSetting(GameSettings.LAVA_BUCKETS)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "Les seaux de lave sont désactivés!");
        }
    }
}
