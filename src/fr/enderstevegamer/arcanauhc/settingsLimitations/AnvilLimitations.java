package fr.enderstevegamer.arcanauhc.settingsLimitations;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class AnvilLimitations {
    private static int limitBonus(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return 0;
        Player player = (Player) event.getWhoClicked();
        if (!GameState.getPlayerArcane(player).equals(Arcane.PAPESSE)) return 0;
        else return 1;
    }

    private static String limitBonusString(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return "";
        Player player = (Player) event.getWhoClicked();
        if (!GameState.getPlayerArcane(player).equals(Arcane.PAPESSE)) return "";
        else return " (+1 car vous possédez l'arcane Papesse)";
    }
    public static void onClick(InventoryClickEvent event) {
        if (event.getSlot() != 2) return;
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        Map<Enchantment, Integer> enchants = item.getEnchantments();
        if (enchants.containsKey(Enchantment.DAMAGE_ALL)
                && enchants.get(Enchantment.DAMAGE_ALL) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.SHARPNESS) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Sharpness" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.SHARPNESS) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.FIRE_ASPECT)
                && enchants.get(Enchantment.FIRE_ASPECT) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FIRE_ASPECT) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Fire aspect" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FIRE_ASPECT) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.KNOCKBACK)
                && enchants.get(Enchantment.KNOCKBACK) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.KNOCKBACK) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Knockback" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.KNOCKBACK) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.THORNS)
                && enchants.get(Enchantment.THORNS) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.THORNS) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Thorns" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.THORNS) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.PROTECTION_FALL)
                && enchants.get(Enchantment.PROTECTION_FALL) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FEATHER_FALLING) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Feather falling" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FEATHER_FALLING) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.DEPTH_STRIDER)
                && enchants.get(Enchantment.DEPTH_STRIDER) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.DEPTH_STRIDER) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Depth Strider" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.DEPTH_STRIDER) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.ARROW_INFINITE)
                && enchants.get(Enchantment.ARROW_INFINITE) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.INFINITY) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Infinity" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.INFINITY) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.ARROW_FIRE)
                && enchants.get(Enchantment.ARROW_FIRE) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FLAME) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Flame" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.FLAME) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.ARROW_KNOCKBACK)
                && enchants.get(Enchantment.ARROW_KNOCKBACK) >
                GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.PUNCH) + limitBonus(event)) {
            player.sendMessage(ChatColor.RED + "Cet objet dépasse la limite pour l'enchantement "
                    + ChatColor.GOLD + "Punch" + ChatColor.RED + ", qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.EnchantsLimits.PUNCH) + limitBonusString(event)
            );
            event.setCancelled(true);
        }
        if (enchants.containsKey(Enchantment.SILK_TOUCH)) {
            player.sendMessage(ChatColor.RED + "L'enchantement "
                    + ChatColor.GOLD + "Silk touch" + ChatColor.RED + " est interdit");
            event.setCancelled(true);
        }
    }
}
