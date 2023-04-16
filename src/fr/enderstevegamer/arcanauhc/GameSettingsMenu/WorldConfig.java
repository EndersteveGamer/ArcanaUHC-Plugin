package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.utils.DisplayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;

public class WorldConfig {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Configuration du monde");

        GeneralMenu.setGlassPanes(inventory);

        inventory.setItem(45, GeneralMenu.buildItem(Material.ARROW, "Retour"));

        inventory.setItem(20, GeneralMenu.buildItem(Material.LAPIS_BLOCK,
                "Taille de départ de la bordure: " +
                        GameSettings.getIntegerSetting(GameSettings.DEFAULT_BORDER_SIZE), true));

        inventory.setItem(21, GeneralMenu.buildItem(Material.REDSTONE_BLOCK,
                "Taille finale de la bordure: " +
                        GameSettings.getIntegerSetting(GameSettings.FINAL_BORDER_SIZE), true));
        inventory.setItem(23, GeneralMenu.buildItem(Material.EYE_OF_ENDER,
                "Temps de réduction de la bordure: " + DisplayUtils.minutesToTimeString(
                        GameSettings.getIntegerSetting(GameSettings.BORDER_REDUCTION_TIME)
                ), true));
        ItemStack item = GeneralMenu.buildItem(Material.WATCH,
                "Temps d'attente avant la réduction", true);
        GeneralMenu.setItemLore(item, Arrays.asList(ChatColor.WHITE +
                ChatColor.ITALIC.toString() + "de la bordure: " + DisplayUtils.minutesToTimeString(
        GameSettings.getIntegerSetting(GameSettings.BORDER_WAIT_TIME)
                ),
                ChatColor.GRAY + "Click gauche pour diminuer",
                ChatColor.GRAY + "Click droit pour augmenter"));
        inventory.setItem(24, item);

        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        int slot = event.getSlot();

        if (slot == 45) {event.getWhoClicked().openInventory(MainSettingsMenu.getMenu()); return;}

        editIntegerSetting(event, 20, GameSettings.DEFAULT_BORDER_SIZE, 50, 2000, 50);
        editIntegerSetting(event, 21, GameSettings.FINAL_BORDER_SIZE, 50, 2000, 50);
        editIntegerSetting(event, 23, GameSettings.BORDER_REDUCTION_TIME, 0, 60, 1);
        editIntegerSetting(event, 24, GameSettings.BORDER_WAIT_TIME, 0, 180, 5);

        event.getWhoClicked().openInventory(WorldConfig.getMenu());
    }

    public static void editIntegerSetting(InventoryClickEvent event, int slot, String setting, int min_value, int max_value, int increment) {
        if (event.getSlot() != slot) return;
        if (event.getClick().equals(ClickType.LEFT) && GameSettings.getIntegerSetting(setting) - increment >= min_value) {
            GameSettings.addIntegerSetting(setting, -increment);
        }
        if (event.getClick().equals(ClickType.RIGHT) && GameSettings.getIntegerSetting(setting) + increment <= max_value) {
            GameSettings.addIntegerSetting(setting, increment);
        }
    }
}
