package fr.enderstevegamer.arcanauhc.settingsLimitations;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CraftingLimitations {
    public static void onClick(InventoryClickEvent event) {
        if (!event.getClick().isLeftClick()) return;
        if (event.getSlot() != 0) return;
        preventItemCraft(event, Material.DIAMOND_HELMET,
                GameSettings.DIAMOND_HELMET, "Casques en diamant");
        preventItemCraft(event, Material.DIAMOND_CHESTPLATE,
                GameSettings.DIAMOND_CHESTPLATE, "Plastrons en diamant");
        preventItemCraft(event, Material.DIAMOND_LEGGINGS,
                GameSettings.DIAMOND_LEGGINGS, "Jambières en diamant");
        preventItemCraft(event, Material.DIAMOND_BOOTS,
                GameSettings.DIAMOND_BOOTS, "Bottes en diamant");
        preventItemCraft(event, Material.DIAMOND_SWORD,
                GameSettings.DIAMOND_SWORDS, "Épées en diamant");
        preventItemCraft(event, Material.ENCHANTMENT_TABLE,
                GameSettings.ENCHANTMENT_TABLES, "Tables d'enchantement");
        preventItemCraft(event, Material.BOW,
                GameSettings.BOWS, "Arcs");
        preventItemCraft(event, Material.BOOKSHELF,
                GameSettings.BOOKSHELVES, "Bibliothèques");
        preventItemCraft(event, Material.FLINT_AND_STEEL,
                GameSettings.FLINT_AND_STEEL, "Briquets");
        preventItemCraft(event, Material.FISHING_ROD,
                GameSettings.FISHING_ROD, "Cannes à pêche");
    }

    public static void preventItemCraft(InventoryClickEvent event, Material material,
                                 String setting, String itemDisplayName) {
        if (event.getCurrentItem().getType().equals(material)
                && !GameSettings.getBooleanSetting(setting)) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage(
                    ChatColor.RED + "Le craft des " + ChatColor.GOLD + itemDisplayName
                            + ChatColor.RED + " est désactivé"
            );
        }
    }
}
