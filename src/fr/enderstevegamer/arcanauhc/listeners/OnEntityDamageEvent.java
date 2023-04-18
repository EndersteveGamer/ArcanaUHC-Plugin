package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.arcanes.Bateleur;
import fr.enderstevegamer.arcanauhc.arcanes.Chariot;
import fr.enderstevegamer.arcanauhc.scenarios.NoDeathBeforePvp;
import fr.enderstevegamer.arcanauhc.scenarios.SafeMiners;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnEntityDamageEvent implements Listener {
    @EventHandler
    public static void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.getEntityType().equals(EntityType.PLAYER)
                && GameSettings.getBooleanSetting(GameSettings.Scenarios.SAFE_MINERS)) SafeMiners.onEntityDamageEvent(event);
        if (event.getEntityType().equals(EntityType.PLAYER)
                && GameSettings.getBooleanSetting(GameSettings.Scenarios.NO_DEATH_BEFORE_PVP)) NoDeathBeforePvp.onEntityDamage(event);
        Bateleur.onDamage(event);
        Chariot.onDamageTaken(event);
    }
}
