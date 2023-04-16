package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class TeamsConfig {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Configuration des équipes");

        GeneralMenu.setGlassPanes(inventory);

        inventory.setItem(45, GeneralMenu.buildItem(Material.ARROW, "Retour"));

        inventory.setItem(4, GeneralMenu.buildItem(Material.BOOK, "Arcanes au total: " + GameSettings.getTotalArcaneNumber()));

        inventory.setItem(10, getItemArcane(Arcane.BATELEUR));
        inventory.setItem(11, getItemArcane(Arcane.PAPESSE));
        inventory.setItem(12, getItemArcane(Arcane.IMPERATRICE));
        inventory.setItem(13, getItemArcane(Arcane.EMPEREUR));
        inventory.setItem(14, getItemArcane(Arcane.PAPE));
        inventory.setItem(15, getItemArcane(Arcane.AMOUREUX));
        inventory.setItem(16, getItemArcane(Arcane.CHARIOT));
        inventory.setItem(19, getItemArcane(Arcane.JUSTICE));
        inventory.setItem(20, getItemArcane(Arcane.HERMITE));
        inventory.setItem(21, getItemArcane(Arcane.ROUE_DE_LA_FORTUNE));
        inventory.setItem(22, getItemArcane(Arcane.FORCE));
        inventory.setItem(23, getItemArcane(Arcane.PENDU));
        inventory.setItem(24, getItemArcane(Arcane.SANS_NOM));
        inventory.setItem(25, getItemArcane(Arcane.TEMPERANCE));
        inventory.setItem(28, getItemArcane(Arcane.DIABLE));
        inventory.setItem(29, getItemArcane(Arcane.MAISON_DIEU));
        inventory.setItem(30, getItemArcane(Arcane.ETOILE));
        inventory.setItem(31, getItemArcane(Arcane.LUNE));
        inventory.setItem(32, getItemArcane(Arcane.SOLEIL));
        inventory.setItem(33, getItemArcane(Arcane.JUGEMENT));
        inventory.setItem(34, getItemArcane(Arcane.MONDE));
        inventory.setItem(39, getItemArcane(Arcane.MAT));
        inventory.setItem(41, getItemArcane(Arcane.SANS_ARCANE));

        final ItemStack ITEM = GeneralMenu.buildItem(Material.BOOK, "Compléter les arcanes manquantes");
        final ItemMeta ITEM_META = ITEM.getItemMeta();
        ITEM_META.setLore(Arrays.asList(ChatColor.WHITE +
                ((GameSettings.getBooleanSetting(GameSettings.COMPLETE_RANDOM_ARCANE)) ? "avec des arcanes aléatoires" :
                "avec des sans-arcane"), ChatColor.GRAY + "Cliquez pour modifier"));
        ITEM.setItemMeta(ITEM_META);
        inventory.setItem(47, ITEM);
        inventory.setItem(49, GeneralMenu.buildItem(Material.BARRIER, ChatColor.RED + ChatColor.BOLD.toString() + "Rénitialiser"));
        inventory.setItem(51, GeneralMenu.buildItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "+1 pour tous"));
        inventory.setItem(52, GeneralMenu.buildItem(Material.REDSTONE_BLOCK, ChatColor.RED + "-1 pour tous"));

        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        int slot = event.getSlot();

        if (slot == 45) {event.getWhoClicked().openInventory(MainSettingsMenu.getMenu()); return;}
        GameSettings.clickTeamSetting(event, 10, Arcane.BATELEUR);
        GameSettings.clickTeamSetting(event, 11, Arcane.PAPESSE);
        GameSettings.clickTeamSetting(event, 12, Arcane.IMPERATRICE);
        GameSettings.clickTeamSetting(event, 13, Arcane.EMPEREUR);
        GameSettings.clickTeamSetting(event, 14, Arcane.PAPE);
        GameSettings.clickTeamSetting(event, 15, Arcane.AMOUREUX);
        GameSettings.clickTeamSetting(event, 16, Arcane.CHARIOT);
        GameSettings.clickTeamSetting(event, 19, Arcane.JUSTICE);
        GameSettings.clickTeamSetting(event, 20, Arcane.HERMITE);
        GameSettings.clickTeamSetting(event, 21, Arcane.ROUE_DE_LA_FORTUNE);
        GameSettings.clickTeamSetting(event, 22, Arcane.FORCE);
        GameSettings.clickTeamSetting(event, 23, Arcane.PENDU);
        GameSettings.clickTeamSetting(event, 24, Arcane.SANS_NOM);
        GameSettings.clickTeamSetting(event, 25, Arcane.TEMPERANCE);
        GameSettings.clickTeamSetting(event, 28, Arcane.DIABLE);
        GameSettings.clickTeamSetting(event, 29, Arcane.MAISON_DIEU);
        GameSettings.clickTeamSetting(event, 30, Arcane.ETOILE);
        GameSettings.clickTeamSetting(event, 31, Arcane.LUNE);
        GameSettings.clickTeamSetting(event, 32, Arcane.SOLEIL);
        GameSettings.clickTeamSetting(event, 33, Arcane.JUGEMENT);
        GameSettings.clickTeamSetting(event, 34, Arcane.MONDE);
        GameSettings.clickTeamSetting(event, 39, Arcane.MAT);
        GameSettings.clickTeamSetting(event, 41, Arcane.SANS_ARCANE);
        if (event.getSlot() == 47) GameSettings.setBooleanSetting(GameSettings.COMPLETE_RANDOM_ARCANE,
                !GameSettings.getBooleanSetting(GameSettings.COMPLETE_RANDOM_ARCANE));
        if (event.getSlot() == 49) GameSettings.resetArcanes();
        if (event.getSlot() == 51) GameSettings.addToAllArcanes(1);
        if (event.getSlot() == 52) GameSettings.addToAllArcanes(-1);
        event.getWhoClicked().openInventory(TeamsConfig.getMenu());
    }

    public static ItemStack getItemArcane(Arcane arcane) {
        final ItemStack ITEM = GeneralMenu.buildItem(Material.PAPER,
                ((GameSettings.getArcane(arcane) == 0) ? ChatColor.RED : "") +
                        arcane.toString() + ": " + GameSettings.getArcane(arcane), true);
        final ItemMeta ITEM_META = ITEM.getItemMeta();
        if (GameSettings.getArcane(arcane) > 0) {
            ITEM_META.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        }
        ITEM.setItemMeta(ITEM_META);
        return ITEM;
    }
}
