package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.arcanes.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class OnEntityDamageByEntity implements Listener {
    @EventHandler
    public static void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player && GameState.isPvpDisabled()) event.setCancelled(true);
        Imperatrice.onDamage(event);
        Empereur.onDamage(event);
        Amoureux.onDamage(event);
        Amoureux.onAttack(event);
        Amoureux.onSnowballHit(event);
        Amoureux.preventLinkedHitting(event);
        Amoureux.onArrowHit(event);
        Chariot.onDamage(event);
        Chariot.onArrowHit(event);
        Justice.onDamage(event);
        Justice.onAttack(event);
        RoueDeLaFortune.onAttack(event);
        Force.onAttack(event);
        Force.onArrowHit(event);
        Force.onArrowDamage(event);
        Pendu.onArrowHit(event);
    }
}
