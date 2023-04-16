package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.utils.DisplayUtils;
import fr.enderstevegamer.arcanauhc.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;

public class ServerSettings {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Configuration du serveur");

        GeneralMenu.setGlassPanes(inventory);

        inventory.setItem(45, GeneralMenu.buildItem(Material.ARROW, "Retour"));

        ItemStack item = GeneralMenu.buildItem(Material.WRITTEN_BOOK, "Nom de la partie: " + GameSettings.gameName);
        GeneralMenu.setItemLore(item, Collections.singletonList(ChatColor.GRAY + "Cliquez pour plus d'infos"));
        inventory.setItem(19, item);

        inventory.setItem(2, integerSettingItem(Material.IRON_DOOR, GameSettings.SERVER_SLOTS, "Slots de serveur"));

        inventory.setItem(28, booleanSettingItem(Material.SEA_LANTERN, GameSettings.SPECTATORS_CAN_JOIN, "Des spectateurs peuvent rejoindre"));

        inventory.setItem(37, booleanSettingItem(Material.PAPER, GameSettings.HEALTH_IN_TAB, "Vie dans le tab"));

        if (GameSettings.getIntegerSetting(GameSettings.FINAL_HEAL) == 0) {
            item = buildPotionItem(Material.POTION, ChatColor.RED + "Final heal désactivé");

        }
        else {
            item = buildPotionItem(Material.POTION, "Final heal à " +
                    DisplayUtils.minutesToTimeString(GameSettings.getIntegerSetting(GameSettings.FINAL_HEAL)));
        }
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setMainEffect(PotionEffectType.HEAL);
        item.setItemMeta(meta);
        inventory.setItem(22, item);

        inventory.setItem(23, GeneralMenu.buildItem(Material.GOLD_SWORD,
                "Temps avant activation du PVP: " + DisplayUtils.minutesToTimeString(
                        GameSettings.getIntegerSetting(GameSettings.TIME_BEFORE_PVP)
                ), true));

        inventory.setItem(24, booleanSettingItem(Material.IRON_HELMET, GameSettings.LIFE_UNDER_NAME, "Vie sous le pseudo"));
        inventory.setItem(31, GeneralMenu.buildItem(Material.EXP_BOTTLE, "Taux d'expérience: " +
                GameSettings.getIntegerSetting(GameSettings.XP_RATE) + "%", true));
        inventory.setItem(32, GeneralMenu.buildItem(Material.FLINT,
                GameSettings.redIfZero(GameSettings.FLINT_DROP) + "Taux de drop des silex: " +
                GameSettings.getIntegerSetting(GameSettings.FLINT_DROP) + "%", true));
        inventory.setItem(33, GeneralMenu.buildItem(Material.APPLE,
                GameSettings.redIfZero(GameSettings.APPLES_DROP) + "Taux de drop des pommes: " +
                GameSettings.getIntegerSetting(GameSettings.APPLES_DROP) + "%", true));

        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        int slot = event.getSlot();

        if (slot == 45) {event.getWhoClicked().openInventory(MainSettingsMenu.getMenu()); return;}

        if (slot == 2) GameSettings.clickIntSetting(event, GameSettings.SERVER_SLOTS, 1, 200);

        if (slot == 19) {event.getWhoClicked().sendMessage("Utilisez la commande /setgamename pour changer le nom de la partie!");}

        if (slot == 28) GameSettings.toggleBooleanSetting(GameSettings.SPECTATORS_CAN_JOIN);
        if (slot == 37) GameSettings.toggleBooleanSetting(GameSettings.HEALTH_IN_TAB);
        if (slot == 22) GameSettings.clickIntSetting(event, GameSettings.FINAL_HEAL, 0, 180, 5);
        if (slot == 23) GameSettings.clickIntSetting(event, GameSettings.TIME_BEFORE_PVP, 5, 90, 5);
        if (slot == 24) GameSettings.toggleBooleanSetting(GameSettings.LIFE_UNDER_NAME);
        if (slot == 31) GameSettings.clickIntSetting(event, GameSettings.XP_RATE, 0, 300, 5);
        if (slot == 32) GameSettings.clickIntSetting(event, GameSettings.FLINT_DROP, 0, 100);
        if (slot == 33) GameSettings.clickIntSetting(event, GameSettings.APPLES_DROP, 0, 100);

        event.getWhoClicked().openInventory(ServerSettings.getMenu());
    }

    public static ItemStack booleanSettingItem(Material material, String setting, String name) {
        ItemStack item = GeneralMenu.buildItem(material,
                ((GameSettings.getBooleanSetting(setting)) ? ChatColor.GREEN : ChatColor.RED) +
                        name
        );
        if (GameSettings.getBooleanSetting(setting)) ItemUtils.enchantItem(item, Enchantment.PROTECTION_ENVIRONMENTAL,
                1, true);
        return item;
    }

    public static ItemStack integerSettingItem(Material material, String setting, String name) {
        return GeneralMenu.buildItem(material, GameSettings.redIfZero(setting) + name + ": " +
                GameSettings.getIntegerSetting(setting), true);
    }

    public static ItemStack buildPotionItem(Material material, String displayName) {
        final ItemStack ITEM = new ItemStack(material, 1, (short) 8197);
        final ItemMeta ITEM_META = ITEM.getItemMeta();
        ITEM_META.setDisplayName(displayName);
        for (ItemFlag flag : GeneralMenu.getFlags()) ITEM_META.addItemFlags(flag);
        ITEM.setItemMeta(ITEM_META);
        GeneralMenu.addSettingLore(ITEM);
        return ITEM;
    }
}
