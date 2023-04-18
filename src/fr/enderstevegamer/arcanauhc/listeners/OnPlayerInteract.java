package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.arcanes.Amoureux;
import fr.enderstevegamer.arcanauhc.arcanes.Imperatrice;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnPlayerInteract implements Listener {
    @EventHandler
    public static void onItemInteract(PlayerInteractEvent event) {
        Imperatrice.onItemInteract(event);
        Amoureux.onInteract(event);
    }
}
