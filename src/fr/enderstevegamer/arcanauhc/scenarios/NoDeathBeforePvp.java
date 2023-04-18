package fr.enderstevegamer.arcanauhc.scenarios;

import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoDeathBeforePvp {
    public static void onEntityDamage(EntityDamageEvent event) {
        if (GameState.isPvpDisabled()) event.setCancelled(true);
    }
}
