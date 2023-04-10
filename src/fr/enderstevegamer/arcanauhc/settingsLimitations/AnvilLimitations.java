package fr.enderstevegamer.arcanauhc.settingsLimitations;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class AnvilLimitations {
    public static void onClick(InventoryClickEvent event) {
        if (event.getSlot() != 2) return;
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        Map<Enchantment, Integer> enchants = item.getEnchantments();
        if (enchants.containsKey(Enchantment.DAMAGE_ALL)
                && enchants.get(Enchantment.DAMAGE_ALL) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.SHARPNESS)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Sharpness" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.SHARPNESS));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.FIRE_ASPECT)
                && enchants.get(Enchantment.FIRE_ASPECT) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FIRE_ASPECT)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Fire aspect" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FIRE_ASPECT));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.KNOCKBACK)
                && enchants.get(Enchantment.KNOCKBACK) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.KNOCKBACK)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Knockback" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.KNOCKBACK));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.THORNS)
                && enchants.get(Enchantment.THORNS) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.THORNS)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Thorns" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.THORNS));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.PROTECTION_FALL)
                && enchants.get(Enchantment.PROTECTION_FALL) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FEATHER_FALLING)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Feather falling" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FEATHER_FALLING));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.DEPTH_STRIDER)
                && enchants.get(Enchantment.DEPTH_STRIDER) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.DEPTH_STRIDER)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Depth Strider" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.DEPTH_STRIDER));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.ARROW_INFINITE)
                && enchants.get(Enchantment.ARROW_INFINITE) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.INFINITY)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Infinity" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.INFINITY));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.ARROW_FIRE)
                && enchants.get(Enchantment.ARROW_FIRE) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FLAME)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Flame" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FLAME));
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.ARROW_KNOCKBACK)
                && enchants.get(Enchantment.ARROW_KNOCKBACK) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.PUNCH)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Punch" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.PUNCH));
            event.setCancelled(true);
        }
    }
}
