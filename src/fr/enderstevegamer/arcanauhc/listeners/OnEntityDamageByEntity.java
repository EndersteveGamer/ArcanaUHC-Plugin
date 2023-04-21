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
        SansNom.onDamage(event);
        SansNom.onAttack(event);
        MaisonDieu.onArrowHit(event);
        MaisonDieu.onAttack(event);
        Etoile.onAttack(event);
        Etoile.onArrowHit(event);
        Lune.onAttack(event);
        Lune.onArrowHit(event);
        Soleil.onAttack(event);
        Soleil.onArrowHit(event);
        Jugement.onDamage(event);
        Jugement.onAttack(event);
        Mat.onAttack(event);
        Mat.onArrowHit(event);
        Diable.onAttack(event);
    }
}
