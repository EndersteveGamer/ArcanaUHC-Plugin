package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.scenarios.BetaZombies;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class OnEntityDeath implements Listener {
    @EventHandler
    public static void onEntityDeath(EntityDeathEvent event) {
        if (!GameSettings.getBooleanSetting(GameSettings.Scenarios.BETA_ZOMBIE)) return;
        EntityType type = event.getEntityType();
        if (type.equals(EntityType.ZOMBIE) || type.equals(EntityType.PIG_ZOMBIE)) BetaZombies.onEntityDeath(event);
    }
}
