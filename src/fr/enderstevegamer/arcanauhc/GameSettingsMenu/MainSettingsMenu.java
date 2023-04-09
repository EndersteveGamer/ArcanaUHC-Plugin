package fr.enderstevegamer.arcanauhc.GameSettingsMenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainSettingsMenu {
    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Configuration");

        GeneralMenu.setGlassPanes(inventory);

        final ItemStack PAPER = GeneralMenu.buildItem(Material.PAPER, "Templates");
        final ItemMeta PAPER_META = PAPER.getItemMeta();
        PAPER_META.addEnchant(Enchantment.DURABILITY, 1, true);
        PAPER.setItemMeta(PAPER_META);

        final ItemStack WOOL = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
        final ItemMeta WOOL_META = WOOL.getItemMeta();
        WOOL_META.setDisplayName("Commencer la partie");
        for (ItemFlag flag : GeneralMenu.getFlags()) WOOL_META.addItemFlags(flag);
        WOOL.setItemMeta(WOOL_META);

        inventory.setItem(11, GeneralMenu.buildItem(Material.DIAMOND_SWORD, "Configuration du stuff"));
        inventory.setItem(13, GeneralMenu.buildItem(Material.DIAMOND_CHESTPLATE, "Configuration des équipes"));
        inventory.setItem(15, GeneralMenu.buildItem(Material.GRASS, "Configuration du monde"));
        inventory.setItem(21, GeneralMenu.buildItem(Material.ENCHANTED_BOOK, "Scénarios"));
        inventory.setItem(23, GeneralMenu.buildItem(Material.COMMAND, "Configuration du serveur"));
        inventory.setItem(45, PAPER);
        inventory.setItem(47, GeneralMenu.buildItem(Material.GLOWSTONE_DUST, "Prégénérer le monde"));
        inventory.setItem(49, WOOL);

        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getData().getItemType().equals(Material.DIAMOND_SWORD)) {player.openInventory(StuffConfig.getMenu()); return;}
        player.openInventory(MainSettingsMenu.getMenu());
    }
}
