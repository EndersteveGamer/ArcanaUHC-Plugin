package fr.enderstevegamer.arcanauhc.settingsLimitations;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.utils.PlayerInfo;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class DiamondLimitations {
    public static void onItemPickup(PlayerPickupItemEvent event) {
        Item itemEntity = event.getItem();
        ItemStack item = itemEntity.getItemStack();
        if (item == null) return;
        if (!item.getType().equals(Material.DIAMOND)) return;
        event.setCancelled(true);
        int count = item.getAmount();
        for (int i = 0; i < count; i++) {
            if (PlayerInfo.getItemNumber(event.getPlayer(), Material.DIAMOND) >=
                    GameSettings.getIntegerSetting(GameSettings.DIAMOND_LIMIT)) return;
            event.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND));
            item.setAmount(item.getAmount() - 1);
            if (item.getAmount() == 0) itemEntity.remove();
            else itemEntity.setItemStack(item);
        }
    }
}
