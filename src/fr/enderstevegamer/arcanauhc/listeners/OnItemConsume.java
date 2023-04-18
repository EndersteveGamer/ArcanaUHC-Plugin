package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.arcanes.Pape;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class OnItemConsume implements Listener {
    @EventHandler
    public static void onItemConsume(PlayerItemConsumeEvent event) {
        Pape.onEat(event);
    }
}
