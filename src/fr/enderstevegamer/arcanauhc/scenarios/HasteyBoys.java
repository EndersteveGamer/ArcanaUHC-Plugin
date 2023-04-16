package fr.enderstevegamer.arcanauhc.scenarios;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class HasteyBoys {
    public static void onClick(InventoryClickEvent event) {
        if (!GameSettings.getBooleanSetting(GameSettings.Scenarios.HASTEY_BOYS)) return;
        if (event.getSlot() != 0) return;
        Material type = event.getCurrentItem().getType();
        if (!(
                type.equals(Material.WOOD_PICKAXE) || type.equals(Material.WOOD_AXE)
                || type.equals(Material.STONE_PICKAXE) || type.equals(Material.STONE_AXE)
                || type.equals(Material.IRON_PICKAXE) || type.equals(Material.IRON_AXE)
                || type.equals(Material.GOLD_PICKAXE) || type.equals(Material.GOLD_AXE)
                || type.equals(Material.DIAMOND_PICKAXE) || type.equals(Material.DIAMOND_AXE)
        )) return;
        ItemMeta meta = event.getCurrentItem().getItemMeta();
        meta.addEnchant(Enchantment.DIG_SPEED, 4, false);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        event.getCurrentItem().setItemMeta(meta);
    }
}
