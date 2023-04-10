package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class EnchantsLimit {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54,
                ChatColor.GOLD + "Limites d'enchantements");

        GeneralMenu.setGlassPanes(inventory);

        inventory.setItem(45, GeneralMenu.buildItem(Material.ARROW, "Retour"));
        inventory.setItem(11, GeneralMenu.buildItem(Material.DIAMOND_SWORD, "Enchantements d'épée"));
        inventory.setItem(13, GeneralMenu.buildItem(Material.DIAMOND_CHESTPLATE,
                "Enchantements d'armure"));
        inventory.setItem(15, GeneralMenu.buildItem(Material.BOW, "Enchantements d'arc"));
        inventory.setItem(20, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.SHARPNESS) + "Sharpness: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.SHARPNESS), true));
        inventory.setItem(29, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.FIRE_ASPECT) + "Fire aspect: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FIRE_ASPECT), true));
        inventory.setItem(38, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.KNOCKBACK) + "Knockback: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.KNOCKBACK), true));
        inventory.setItem(22, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.THORNS) + "Thorns: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.THORNS), true));
        inventory.setItem(31, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.FEATHER_FALLING) + "Feather falling: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FEATHER_FALLING), true));
        inventory.setItem(40, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.DEPTH_STRIDER) + "Depth strider: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.DEPTH_STRIDER), true));
        inventory.setItem(24, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.INFINITY) + "Infinity: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.INFINITY), true));
        inventory.setItem(33, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.FLAME) + "Flame: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FLAME), true));
        inventory.setItem(42, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                GameSettings.redIfZero(GameSettings.EnchantsLimits.PUNCH) + "Punch: "
                        + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.PUNCH), true));

        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        Material itemClicked = event.getCurrentItem().getData().getItemType();
        if (itemClicked.equals(Material.ARROW)) {player.openInventory(StuffConfig.getMenu()); return;}
        if (event.getSlot() == 20) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.SHARPNESS,5);
        if (event.getSlot() == 29) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.FIRE_ASPECT,2);
        if (event.getSlot() == 38) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.KNOCKBACK, 2);
        if (event.getSlot() == 22) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.THORNS, 3);
        if (event.getSlot() == 31) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.FEATHER_FALLING, 4);
        if (event.getSlot() == 40) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.DEPTH_STRIDER, 3);
        if (event.getSlot() == 24) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.INFINITY, 1);
        if (event.getSlot() == 33) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.FLAME, 1);
        if (event.getSlot() == 42) GameSettings.clickIntSetting(event, GameSettings.EnchantsLimits.PUNCH, 2);

        player.openInventory(EnchantsLimit.getMenu());
    }
}
