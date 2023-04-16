package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ScenariosConfig {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Scénarios");

        GeneralMenu.setGlassPanes(inventory);

        inventory.setItem(45, GeneralMenu.buildItem(Material.ARROW, "Retour"));

        inventory.setItem(11,
                booleanSettingItem(Material.FEATHER, GameSettings.Scenarios.BETA_ZOMBIE, "Beta zombies")
        );
        inventory.setItem(13,
                booleanSettingItem(Material.DIAMOND_PICKAXE, GameSettings.Scenarios.HASTEY_BOYS, "Hastey boys")
        );
        inventory.setItem(15,
                booleanSettingItem(Material.DIAMOND_AXE, GameSettings.Scenarios.TIMBER, "Timber")
        );
        inventory.setItem(21,
                booleanSettingItem(Material.LEAVES, GameSettings.Scenarios.FAST_LEAVES_DECAY, "Fast leaves decay")
        );
        inventory.setItem(23,
                booleanSettingItem(Material.BONE, GameSettings.Scenarios.NO_DEATH_BEFORE_PVP, "No death before PVP")
        );
        inventory.setItem(31,
                booleanSettingItem(Material.LAVA_BUCKET, GameSettings.Scenarios.SAFE_MINERS, "Safe miners")
        );

        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        int slot = event.getSlot();

        if (slot == 45) {event.getWhoClicked().openInventory(MainSettingsMenu.getMenu()); return;}
        if (slot == 11) GameSettings.toggleBooleanSetting(GameSettings.Scenarios.BETA_ZOMBIE);
        if (slot == 13) GameSettings.toggleBooleanSetting(GameSettings.Scenarios.HASTEY_BOYS);
        if (slot == 15) GameSettings.toggleBooleanSetting(GameSettings.Scenarios.TIMBER);
        if (slot == 21) GameSettings.toggleBooleanSetting(GameSettings.Scenarios.FAST_LEAVES_DECAY);
        if (slot == 23) GameSettings.toggleBooleanSetting(GameSettings.Scenarios.NO_DEATH_BEFORE_PVP);
        if (slot == 31) GameSettings.toggleBooleanSetting(GameSettings.Scenarios.SAFE_MINERS);

        event.getWhoClicked().openInventory(ScenariosConfig.getMenu());
    }

    public static ItemStack booleanSettingItem(Material material, String setting, String name) {
        ItemStack item = GeneralMenu.buildItem(material,
                ((GameSettings.getBooleanSetting(setting)) ? ChatColor.GREEN : ChatColor.RED) + name
        );
        if (GameSettings.getBooleanSetting(setting)) ItemUtils.enchantItem(item, Enchantment.PROTECTION_ENVIRONMENTAL,
                1, true);
        return item;
    }
}
