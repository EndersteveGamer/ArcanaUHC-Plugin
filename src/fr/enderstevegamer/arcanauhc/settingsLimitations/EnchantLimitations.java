package fr.enderstevegamer.arcanauhc.settingsLimitations;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class EnchantLimitations {
    public static void onClick(InventoryClickEvent event) {
        if (event.getSlot() != 0) return;
        ItemStack item = event.getCurrentItem();
        Map<Enchantment, Integer> enchantsMap = item.getEnchantments();
        HashMap<Enchantment, Integer> enchants = new HashMap<>();
        for (Enchantment enchantment : enchantsMap.keySet()) {
            enchants.put(enchantment, enchantsMap.get(enchantment));
        }
        limitEnchant(event, enchants, Enchantment.DAMAGE_ALL, GameSettings.EnchantsLimits.SHARPNESS, "Sharpness");
        limitEnchant(event, enchants, Enchantment.FIRE_ASPECT, GameSettings.EnchantsLimits.FIRE_ASPECT, "Fire aspect");
        limitEnchant(event, enchants, Enchantment.KNOCKBACK, GameSettings.EnchantsLimits.KNOCKBACK, "Knockback");
        limitEnchant(event, enchants, Enchantment.THORNS, GameSettings.EnchantsLimits.THORNS, "Thorns");
        limitEnchant(event, enchants, Enchantment.PROTECTION_FALL, GameSettings.EnchantsLimits.FEATHER_FALLING, "Feather falling");
        limitEnchant(event, enchants, Enchantment.DEPTH_STRIDER, GameSettings.EnchantsLimits.DEPTH_STRIDER, "Depth strider");
        limitEnchant(event, enchants, Enchantment.ARROW_INFINITE, GameSettings.EnchantsLimits.INFINITY, "Infinity");
        limitEnchant(event, enchants, Enchantment.ARROW_FIRE, GameSettings.EnchantsLimits.FLAME, "Flame");
        limitEnchant(event, enchants, Enchantment.ARROW_KNOCKBACK, GameSettings.EnchantsLimits.PUNCH, "Punch");
        for (Enchantment enchant : enchantsMap.keySet()) {
            item.removeEnchantment(enchant);
        }
        for (Enchantment enchant : enchants.keySet()) {
            if (enchants.get(enchant) != 0) item.addEnchantment(enchant, enchants.get(enchant));
        }
    }

    public static void limitEnchant(InventoryClickEvent event, Map<Enchantment, Integer> enchants, Enchantment enchant,
                                    String setting, String enchantName) {
        if (!enchants.containsKey(enchant)) return;
        if (enchants.get(enchant) > GameSettings.getIntegerSetting(setting)) {
            enchants.put(enchant, GameSettings.getIntegerSetting(setting));
            event.getWhoClicked().sendMessage(ChatColor.RED + "Cet objet dépassait la limite d'enchantement pour " +
                    ChatColor.GOLD + enchantName + ChatColor.RED + ", et son niveau d'enchantement a été réduit");
        }
    }
}
