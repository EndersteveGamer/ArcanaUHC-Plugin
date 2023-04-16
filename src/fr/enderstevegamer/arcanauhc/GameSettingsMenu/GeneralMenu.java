package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GeneralMenu {
    public static Set<ItemFlag> getFlags() {
        final ItemStack item = new ItemStack(Material.GRASS);
        final ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ATTRIBUTES);
        return meta.getItemFlags();
    }

    public static void setGlassPanes(Inventory inventory) {
        inventory.setItem(0, getGlassPane());
        inventory.setItem(1, getGlassPane());
        for (int i = 9; i <= 36; i += 9) {
            inventory.setItem(i, getGlassPane());
            inventory.setItem(i + 8, getGlassPane());
        }
        inventory.setItem(52, getGlassPane());
        inventory.setItem(53, getGlassPane());
    }

    public static ItemStack getGlassPane() {
        final ItemStack GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.LIGHT_BLUE.getData());
        final ItemMeta GLASS_META = GLASS_PANE.getItemMeta();
        GLASS_META.setDisplayName(" ");
        for (ItemFlag flag : getFlags()) GLASS_META.addItemFlags(flag);
        GLASS_PANE.setItemMeta(GLASS_META);
        return GLASS_PANE;
    }

    public static ItemStack buildItem(Material material, String displayName) {
        final ItemStack ITEM = new ItemStack(material);
        final ItemMeta ITEM_META = ITEM.getItemMeta();
        ITEM_META.setDisplayName(displayName);
        for (ItemFlag flag : getFlags()) ITEM_META.addItemFlags(flag);
        ITEM.setItemMeta(ITEM_META);
        return ITEM;
    }

    public static ItemStack buildItem(Material material, String displayName, boolean settingModifier) {
        if (!settingModifier) return buildItem(material, displayName);
        ItemStack item = buildItem(material, displayName);
        addSettingLore(item);
        return item;
    }

    public static void addSettingLore(ItemStack item) {
        final ItemMeta META = item.getItemMeta();
        META.setLore(Arrays.asList(ChatColor.GRAY + "Clic gauche pour diminuer", ChatColor.GRAY + "Clic droit pour augmenter"));
        item.setItemMeta(META);
    }

    public static void setItemLore(ItemStack item, List<String> lore) {
        final ItemMeta META = item.getItemMeta();
        META.setLore(lore);
        item.setItemMeta(META);
    }
}
