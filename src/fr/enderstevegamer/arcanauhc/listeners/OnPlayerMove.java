package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.arcanes.Pendu;
import fr.enderstevegamer.arcanauhc.arcanes.Temperance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnPlayerMove implements Listener {
    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent event) {
        Pendu.onMove(event);
        Temperance.accelerateInWater(event);
    }
}
