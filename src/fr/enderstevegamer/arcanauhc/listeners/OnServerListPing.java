package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class OnServerListPing implements Listener {
    @EventHandler
    public static void onServerListPing(ServerListPingEvent event) {
        event.setMaxPlayers(GameSettings.getIntegerSetting(GameSettings.SERVER_SLOTS));
    }
}
