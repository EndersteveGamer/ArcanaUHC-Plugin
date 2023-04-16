package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StuffConfig {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Configuration du stuff");

        GeneralMenu.setGlassPanes(inventory);

        final ItemStack DMND_HELMET = GeneralMenu.buildItem(Material.DIAMOND_HELMET,
                ((GameSettings.getBooleanSetting(GameSettings.DIAMOND_HELMET)) ? ChatColor.GREEN : ChatColor.RED) + "Casque en diamant");
        final ItemMeta HELMET_META = DMND_HELMET.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.DIAMOND_HELMET)) HELMET_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        DMND_HELMET.setItemMeta(HELMET_META);

        final ItemStack DMND_CHESTPLATE = GeneralMenu.buildItem(Material.DIAMOND_CHESTPLATE,
                ((GameSettings.getBooleanSetting(GameSettings.DIAMOND_CHESTPLATE)) ? ChatColor.GREEN : ChatColor.RED) + "Plastron en diamant");
        final ItemMeta CHESTPLATE_META = DMND_CHESTPLATE.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.DIAMOND_CHESTPLATE)) CHESTPLATE_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        DMND_CHESTPLATE.setItemMeta(CHESTPLATE_META);

        final ItemStack DMND_LEGGINGS = GeneralMenu.buildItem(Material.DIAMOND_LEGGINGS,
                ((GameSettings.getBooleanSetting(GameSettings.DIAMOND_LEGGINGS)) ? ChatColor.GREEN : ChatColor.RED) + "Jambières en diamant");
        final ItemMeta LEGGINGS_META = DMND_LEGGINGS.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.DIAMOND_LEGGINGS)) LEGGINGS_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        DMND_LEGGINGS.setItemMeta(LEGGINGS_META);

        final ItemStack DMND_BOOTS = GeneralMenu.buildItem(Material.DIAMOND_BOOTS,
                ((GameSettings.getBooleanSetting(GameSettings.DIAMOND_BOOTS)) ? ChatColor.GREEN : ChatColor.RED) + "Bottes en diamant");
        final ItemMeta BOOTS_META = DMND_BOOTS.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.DIAMOND_BOOTS)) BOOTS_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        DMND_BOOTS.setItemMeta(BOOTS_META);

        final ItemStack DMND_SWORD = GeneralMenu.buildItem(Material.DIAMOND_SWORD,
                ((GameSettings.getBooleanSetting(GameSettings.DIAMOND_SWORDS)) ? ChatColor.GREEN : ChatColor.RED) + "Épée en diamant");
        final ItemMeta SWORD_META = DMND_SWORD.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.DIAMOND_SWORDS)) SWORD_META.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        DMND_SWORD.setItemMeta(SWORD_META);

        final ItemStack ENCHANTMENT_TABLE = GeneralMenu.buildItem(Material.ENCHANTMENT_TABLE,
                ((GameSettings.getBooleanSetting(GameSettings.ENCHANTMENT_TABLES)) ? ChatColor.GREEN : ChatColor.RED) + "Tables d'enchantement");
        final ItemMeta TABLE_META = ENCHANTMENT_TABLE.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.ENCHANTMENT_TABLES)) TABLE_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ENCHANTMENT_TABLE.setItemMeta(TABLE_META);

        final ItemStack LAVA_BUCKET = GeneralMenu.buildItem(Material.LAVA_BUCKET,
                ((GameSettings.getBooleanSetting(GameSettings.LAVA_BUCKETS)) ? ChatColor.GREEN : ChatColor.RED) + "Seaux de lave");
        final ItemMeta LAVA_META = LAVA_BUCKET.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.LAVA_BUCKETS)) LAVA_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        LAVA_BUCKET.setItemMeta(LAVA_META);

        final ItemStack ENDER_PEARL = GeneralMenu.buildItem(Material.ENDER_PEARL,
                ((GameSettings.getBooleanSetting(GameSettings.ENDER_PEARLS)) ? ChatColor.GREEN : ChatColor.RED) + "Perles de l'ender");
        final ItemMeta PEARL_META = ENDER_PEARL.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.ENDER_PEARLS)) PEARL_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ENDER_PEARL.setItemMeta(PEARL_META);

        final ItemStack BOW = GeneralMenu.buildItem(Material.BOW,
                ((GameSettings.getBooleanSetting(GameSettings.BOWS)) ? ChatColor.GREEN : ChatColor.RED) + "Arcs");
        final ItemMeta BOW_META = BOW.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.BOWS)) BOW_META.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        BOW.setItemMeta(BOW_META);

        final ItemStack BOOKSHELF = GeneralMenu.buildItem(Material.BOOKSHELF,
                ((GameSettings.getBooleanSetting(GameSettings.BOOKSHELVES)) ? ChatColor.GREEN : ChatColor.RED) + "Bibliothèques");
        final ItemMeta BOOKSHELF_META = BOOKSHELF.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.BOOKSHELVES)) BOOKSHELF_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        BOOKSHELF.setItemMeta(BOOKSHELF_META);

        final ItemStack FLINT_AND_STEEL = GeneralMenu.buildItem(Material.FLINT_AND_STEEL,
                ((GameSettings.getBooleanSetting(GameSettings.FLINT_AND_STEEL)) ? ChatColor.GREEN : ChatColor.RED) + "Briquets");
        final ItemMeta FLINT_META = FLINT_AND_STEEL.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.FLINT_AND_STEEL)) FLINT_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        FLINT_AND_STEEL.setItemMeta(FLINT_META);

        final ItemStack FISHING_ROD = GeneralMenu.buildItem(Material.FISHING_ROD,
                ((GameSettings.getBooleanSetting(GameSettings.FISHING_ROD)) ? ChatColor.GREEN : ChatColor.RED) + "Cannes à pêche");
        final ItemMeta ROD_META = FISHING_ROD.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.FISHING_ROD)) ROD_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        FISHING_ROD.setItemMeta(ROD_META);

        final ItemStack GAPPLE = GeneralMenu.buildItem(Material.GOLDEN_APPLE,
                ((GameSettings.getBooleanSetting(GameSettings.GOLDEN_APPLE_ON_KILL)) ? ChatColor.GREEN : ChatColor.RED) + "Pommes dorée au kill");
        final ItemMeta GAPPLE_META = GAPPLE.getItemMeta();
        if (GameSettings.getBooleanSetting(GameSettings.GOLDEN_APPLE_ON_KILL)) GAPPLE_META.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        GAPPLE.setItemMeta(GAPPLE_META);


        inventory.setItem(45, GeneralMenu.buildItem(Material.ARROW, "Retour"));
        inventory.setItem(10, DMND_HELMET);
        inventory.setItem(19, DMND_CHESTPLATE);
        inventory.setItem(28, DMND_LEGGINGS);
        inventory.setItem(37, DMND_BOOTS);
        inventory.setItem(13, DMND_SWORD);
        inventory.setItem(14, ENCHANTMENT_TABLE);
        inventory.setItem(15, LAVA_BUCKET);
        inventory.setItem(16, ENDER_PEARL);
        inventory.setItem(22, BOW);
        inventory.setItem(23, BOOKSHELF);
        inventory.setItem(24, FLINT_AND_STEEL);
        inventory.setItem(25, FISHING_ROD);
        inventory.setItem(39, GeneralMenu.buildItem(Material.DIAMOND_CHESTPLATE,
                GameSettings.redIfZero(GameSettings.DIAMOND_ARMORS_LIMIT)
                        + "Limite de pièces d'armure: "
                        + GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT), true));
        inventory.setItem(40, GeneralMenu.buildItem(Material.DIAMOND,
                (GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT) == -1) ? ChatColor.RED + "Limite de diamants: Désactivé" :
                        "Limite de diamants: "
                        + GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT), true));
        inventory.setItem(41, GAPPLE);
        inventory.setItem(42, GeneralMenu.buildItem(Material.CHEST, "Modifier le kit de départ"));
        inventory.setItem(43, GeneralMenu.buildItem(Material.ENCHANTED_BOOK,
                "Modifier les limites d'enchantements"));

        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getData().getItemType().equals(Material.ARROW)) {player.openInventory(MainSettingsMenu.getMenu()); return;}
        if (event.getCurrentItem().getData().getItemType().equals(Material.DIAMOND_HELMET)) GameSettings.setBooleanSetting(
                GameSettings.DIAMOND_HELMET, !GameSettings.getBooleanSetting(GameSettings.DIAMOND_HELMET)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.DIAMOND_CHESTPLATE) && event.getSlot() == 19) GameSettings.setBooleanSetting(
                GameSettings.DIAMOND_CHESTPLATE, !GameSettings.getBooleanSetting(GameSettings.DIAMOND_CHESTPLATE)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.DIAMOND_LEGGINGS)) GameSettings.setBooleanSetting(
                GameSettings.DIAMOND_LEGGINGS, !GameSettings.getBooleanSetting(GameSettings.DIAMOND_LEGGINGS)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.DIAMOND_BOOTS)) GameSettings.setBooleanSetting(
                GameSettings.DIAMOND_BOOTS, !GameSettings.getBooleanSetting(GameSettings.DIAMOND_BOOTS)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.DIAMOND_SWORD)) GameSettings.setBooleanSetting(
                GameSettings.DIAMOND_SWORDS, !GameSettings.getBooleanSetting(GameSettings.DIAMOND_SWORDS)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.ENCHANTMENT_TABLE)) GameSettings.setBooleanSetting(
                GameSettings.ENCHANTMENT_TABLES, !GameSettings.getBooleanSetting(GameSettings.ENCHANTMENT_TABLES)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.LAVA_BUCKET)) GameSettings.setBooleanSetting(
                GameSettings.LAVA_BUCKETS, !GameSettings.getBooleanSetting(GameSettings.LAVA_BUCKETS)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.ENDER_PEARL)) GameSettings.setBooleanSetting(
                GameSettings.ENDER_PEARLS, !GameSettings.getBooleanSetting(GameSettings.ENDER_PEARLS)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.BOW)) GameSettings.setBooleanSetting(
                GameSettings.BOWS, !GameSettings.getBooleanSetting(GameSettings.BOWS)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.BOOKSHELF)) GameSettings.setBooleanSetting(
                GameSettings.BOOKSHELVES, !GameSettings.getBooleanSetting(GameSettings.BOOKSHELVES)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.FLINT_AND_STEEL)) GameSettings.setBooleanSetting(
                GameSettings.FLINT_AND_STEEL, !GameSettings.getBooleanSetting(GameSettings.FLINT_AND_STEEL)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.FISHING_ROD)) GameSettings.setBooleanSetting(
                GameSettings.FISHING_ROD, !GameSettings.getBooleanSetting(GameSettings.FISHING_ROD)
        );
        if (event.getSlot() == 39) {
            if (event.getClick().equals(ClickType.LEFT) && GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT) > 0) {
                GameSettings.setIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT,
                        GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT) - 1);
            }
            else if (event.getClick().equals(ClickType.RIGHT) && GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT) < 4) {
                GameSettings.setIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT,
                        GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT) + 1);
            }
        }
        if (event.getCurrentItem().getData().getItemType().equals(Material.DIAMOND)) {
            if (event.getClick().equals(ClickType.LEFT) && GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT) > -1) {
                GameSettings.setIntegerSetting(GameSettings.DIAMOND_LIMIT,
                        GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT) - 1);
            }
            else if (event.getClick().equals(ClickType.RIGHT) && GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT) < 30) {
                GameSettings.setIntegerSetting(GameSettings.DIAMOND_LIMIT,
                        GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT) + 1);
            }
        }
        if (event.getCurrentItem().getData().getItemType().equals(Material.GOLDEN_APPLE)) GameSettings.setBooleanSetting(
                GameSettings.GOLDEN_APPLE_ON_KILL, !GameSettings.getBooleanSetting(GameSettings.GOLDEN_APPLE_ON_KILL)
        );
        if (event.getCurrentItem().getData().getItemType().equals(Material.CHEST)) {player.openInventory(StartingStuffConfig.getMenu()); return;}
        if (event.getCurrentItem().getData().getItemType().equals(Material.ENCHANTED_BOOK)) {player.openInventory(EnchantsLimit.getMenu()); return;}

        player.openInventory(StuffConfig.getMenu());
    }
}
