package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class OnProjectileLaunch implements Listener {
    @EventHandler
    public static void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity().getShooter() instanceof Player)) return;
        Player player = (Player) event.getEntity().getShooter();
        if (event.getEntity() instanceof EnderPearl
                && !GameSettings.getBooleanSetting(GameSettings.ENDER_PEARLS)) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Les Ender pearls sont désactivées");
            if (player.getInventory().getItemInHand().getType().equals(Material.ENDER_PEARL)) {
                player.getInventory().getItemInHand().setAmount(
                        player.getInventory().getItemInHand().getAmount() + 1
                );
            }
            else {
                player.getInventory().setItemInHand(new ItemStack(Material.ENDER_PEARL, 1));
            }
        }
    }
}
