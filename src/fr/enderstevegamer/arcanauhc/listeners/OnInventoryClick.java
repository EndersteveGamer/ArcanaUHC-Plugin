package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettingsMenu.*;
import fr.enderstevegamer.arcanauhc.scenarios.HasteyBoys;
import fr.enderstevegamer.arcanauhc.settingsLimitations.AnvilLimitations;
import fr.enderstevegamer.arcanauhc.settingsLimitations.ArmorLimitations;
import fr.enderstevegamer.arcanauhc.settingsLimitations.CraftingLimitations;
import fr.enderstevegamer.arcanauhc.settingsLimitations.EnchantLimitations;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class OnInventoryClick implements Listener {
    @EventHandler
    public static void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration")) MainSettingsMenu.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration du stuff")) StuffConfig.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Limites d'enchantements")) EnchantsLimit.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration du stuff de départ")) StartingStuffConfig.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration des équipes")) TeamsConfig.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration du monde")) WorldConfig.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Scénarios")) ScenariosConfig.onClick(event);
        if (event.getClickedInventory().getName().equals(ChatColor.GOLD + "Configuration du serveur")) ServerSettings.onClick(event);
        if (event.getClickedInventory().getType().equals(InventoryType.ANVIL)) AnvilLimitations.onClick(event);
        if (event.getClickedInventory().getType().equals(InventoryType.PLAYER)) ArmorLimitations.onClick(event);
        if (event.getClickedInventory().getType().equals(InventoryType.WORKBENCH)) CraftingLimitations.onClick(event);
        if (event.getClickedInventory().getType().equals(InventoryType.WORKBENCH)) HasteyBoys.onClick(event);
        if (event.getClickedInventory().getType().equals(InventoryType.ENCHANTING)) EnchantLimitations.onClick(event);
    }
}
