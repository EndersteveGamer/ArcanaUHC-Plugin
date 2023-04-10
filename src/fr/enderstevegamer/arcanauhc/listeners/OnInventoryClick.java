package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettingsMenu.EnchantsLimit;
import fr.enderstevegamer.arcanauhc.GameSettingsMenu.MainSettingsMenu;
import fr.enderstevegamer.arcanauhc.GameSettingsMenu.StuffConfig;
import fr.enderstevegamer.arcanauhc.settingsLimitations.AnvilLimitations;
import fr.enderstevegamer.arcanauhc.settingsLimitations.ArmorLimitations;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class OnInventoryClick implements Listener {
    @EventHandler()
    public static void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration")) MainSettingsMenu.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration du stuff")) StuffConfig.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Limites d'enchantements")) EnchantsLimit.onClick(event);
        if (event.getClickedInventory().getType().equals(InventoryType.ANVIL)) AnvilLimitations.onClick(event);
        if (event.getClickedInventory().getType().equals(InventoryType.PLAYER)) ArmorLimitations.onClick(event);
    }
}
