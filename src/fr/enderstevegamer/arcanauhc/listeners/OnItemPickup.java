package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.settingsLimitations.DiamondLimitations;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class OnItemPickup implements Listener {
    @EventHandler
    public static void onItemPickup(PlayerPickupItemEvent event) {
        DiamondLimitations.onItemPickup(event);
    }
}
