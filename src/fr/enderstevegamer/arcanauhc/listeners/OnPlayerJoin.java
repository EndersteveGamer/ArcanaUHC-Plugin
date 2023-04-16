package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        if (Bukkit.getOnlinePlayers().size() >= GameSettings.getIntegerSetting(GameSettings.SERVER_SLOTS)) {
            event.getPlayer().kickPlayer("Le nombre maximum de joueurs a été atteint");
        }
        if (GameState.gameStarted() && !GameSettings.getBooleanSetting(GameSettings.SPECTATORS_CAN_JOIN)) {
            event.getPlayer().kickPlayer("Vous ne pouvez pas regarder une partie qui a déjà commencé!");
        }
        if (GameState.gameStarted()) {
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
    }
}
