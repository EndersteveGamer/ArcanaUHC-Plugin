package fr.enderstevegamer.arcanauhc.settingsLimitations;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.utils.ItemUtils;
import fr.enderstevegamer.arcanauhc.utils.PlayerInfo;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ArmorLimitations {
    public static void onClick(InventoryClickEvent event) {
        if (!event.getSlotType().equals(InventoryType.SlotType.ARMOR)) return;
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (player.getInventory().getItem(event.getSlot()) != null && ItemUtils.isDiamondArmor(player.getInventory().getItem(event.getSlot()))) return;
        if (!ItemUtils.isDiamondArmor(event.getCursor())) return;
        if (PlayerInfo.diamondArmorCount(player) >= GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT)) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Vous avez dépassé la limite de pièces d'armure en diamant, qui est de "
                    + GameSettings.getIntegerSetting(GameSettings.DIAMOND_ARMORS_LIMIT));
            player.setItemOnCursor(event.getCursor());
        }
    }
}
