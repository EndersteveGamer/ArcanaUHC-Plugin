package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettingsMenu.MainSettingsMenu;
import fr.enderstevegamer.arcanauhc.GameSettingsMenu.StuffConfig;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnInventoryClick implements Listener {
    @EventHandler
    public static void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration")) MainSettingsMenu.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration du stuff")) StuffConfig.onClick(event);
    }
}
