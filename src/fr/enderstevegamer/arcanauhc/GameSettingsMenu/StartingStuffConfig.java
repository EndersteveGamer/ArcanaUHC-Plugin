package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class StartingStuffConfig {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Configuration du stuff de départ");

        for (int i = 0; i < GameSettings.getStartingArmor().length; i++) {
            if (GameSettings.getStartingArmor()[i] != null) {
                inventory.setItem(i, GameSettings.getStartingArmor()[i]);
            }
        }

        for (int i = 0; i < GameSettings.getStartingInventory().length; i++) {
            if (GameSettings.getStartingInventory()[i] != null) {
                inventory.setItem(i + 9, GameSettings.getStartingInventory()[i]);
            }
        }

        for (int i = 4; i < 8; i++) {
            inventory.setItem(i, GeneralMenu.getGlassPane());
        }

        final ItemStack BOOK = GeneralMenu.buildItem(Material.WRITTEN_BOOK, ChatColor.RESET + "Première ligne: armure");
        final ItemMeta BOOK_META = BOOK.getItemMeta();
        BOOK_META.setLore(Arrays.asList(
                ChatColor.WHITE + String.valueOf(ChatColor.ITALIC) + "L'armure se met du casque aux bottes de",
                ChatColor.WHITE + String.valueOf(ChatColor.ITALIC) + "gauche à droite",
                ChatColor.WHITE + "Deuxième à quatrième ligne: inventaire",
                ChatColor.WHITE + "Cinquième ligne: hotbar"));
        BOOK.setItemMeta(BOOK_META);
        inventory.setItem(8, BOOK);

        inventory.setItem(45, GeneralMenu.buildItem(Material.ARROW, "Retour"));
        inventory.setItem(49, GeneralMenu.buildItem(Material.EMERALD_BLOCK, "Sauvegarder"));
        inventory.setItem(53, GeneralMenu.buildItem(Material.BARRIER, "Rénitialiser"));

        return inventory;
    }

    public static void saveStartingStuff(Inventory inventory) {
        for (int i = 0; i < 4; i++) {
            GameSettings.getStartingArmor()[i] = inventory.getItem(i);
        }
        for (int i = 9; i <= 44; i++) {
            GameSettings.getStartingInventory()[i - 9] = inventory.getItem(i);
        }
    }

    public static void onClick(InventoryClickEvent event) {
        int slot = event.getSlot();
        if ((slot > 3 && slot < 9) || slot >= 45) event.setCancelled(true);
        if (slot == 45) {event.getWhoClicked().openInventory(StuffConfig.getMenu()); return;}
        if (slot == 49) {
            saveStartingStuff(event.getInventory());
            event.getWhoClicked().openInventory(StartingStuffConfig.getMenu());
            return;
        }
        if (slot == 53) {
            GameSettings.resetStartingStuff();
            event.getWhoClicked().openInventory(StartingStuffConfig.getMenu());
        }
    }
}
