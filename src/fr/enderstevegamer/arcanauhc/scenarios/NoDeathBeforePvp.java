package fr.enderstevegamer.arcanauhc.scenarios;

import org.bukkit.event.entity.EntityDamageEvent;

public class NoDeathBeforePvp {
    public static void onEntityDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }
}
