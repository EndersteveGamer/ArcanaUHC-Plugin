package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        final ItemStack GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.LIGHT_BLUE.getData());
        final ItemMeta GLASS_META = GLASS_PANE.getItemMeta();
        GLASS_META.setDisplayName(" ");
        for (ItemFlag flag : getFlags()) GLASS_META.addItemFlags(flag);
        GLASS_PANE.setItemMeta(GLASS_META);

        inventory.setItem(0,GLASS_PANE);
        inventory.setItem(1, GLASS_PANE);
        for (int i = 9; i <= 36; i += 9) {
            inventory.setItem(i, GLASS_PANE);
            inventory.setItem(i + 8, GLASS_PANE);
        }
        inventory.setItem(52, GLASS_PANE);
        inventory.setItem(53, GLASS_PANE);
    }

    public static ItemStack buildItem(Material material, String displayName) {
        final ItemStack ITEM = new ItemStack(material);
        final ItemMeta ITEM_META = ITEM.getItemMeta();
        ITEM_META.setDisplayName(displayName);
        for (ItemFlag flag : getFlags()) ITEM_META.addItemFlags(flag);
        ITEM.setItemMeta(ITEM_META);
        return ITEM;
    }
}