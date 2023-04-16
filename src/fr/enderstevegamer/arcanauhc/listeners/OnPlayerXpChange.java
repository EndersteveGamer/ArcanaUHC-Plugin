package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class OnPlayerXpChange implements Listener {
    @EventHandler
    public static void onPlayerXpChange(PlayerExpChangeEvent event) {
        event.setAmount(event.getAmount() * (GameSettings.getIntegerSetting(GameSettings.XP_RATE) / 100));
    }
}
