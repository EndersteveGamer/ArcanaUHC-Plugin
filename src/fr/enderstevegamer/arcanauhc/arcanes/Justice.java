package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Justice {
    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        if (GameState.isInnocent(damager)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.JUSTICE)) return;
        event.setDamage(event.getDamage() * 0.9);
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(damager).equals(Arcane.JUSTICE)) return;
        Player player = (Player) event.getEntity();
        if (GameState.isInnocent(player)) return;
        event.setDamage(event.getDamage() * 1.25);
    }

    public static void onKill(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;
        Player killer = event.getEntity().getKiller();
        if (!GameState.getPlayerArcane(killer).equals(Arcane.JUSTICE)) return;
        Player killed = event.getEntity();
        if (!GameState.isInnocent(killed)) return;
        killer.addPotionEffect(new PotionEffect(
                PotionEffectType.CONFUSION, 20 * 60, 0, false, false
        ));
    }
}
