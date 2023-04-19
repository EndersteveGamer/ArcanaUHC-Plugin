package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Jugement {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.JUGEMENT)) return;
        player.setFoodLevel(20);
        player.setSaturation(20);

        boolean hasSlowness = false;
        for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 10, 10, 10)) {
            if (!(entity instanceof Player)) continue;
            if (entity.equals(player)) continue;
            hasSlowness = true;
            Player player1 = (Player) entity;
            player1.addPotionEffect(new PotionEffect(
                    PotionEffectType.WEAKNESS, 1, 0, false, false
            ));
        }
        if (hasSlowness) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SLOW, 1, 0, false, false
            ));
        }
    }
    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.JUGEMENT)) return;
        if (event.getDamager() instanceof Player) return;
        if (event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player) return;
        event.setCancelled(true);
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.JUGEMENT)) return;
        event.setDamage(event.getDamage() * (1 + 0.01 * GameState.getJugementStrengthBonus()));
    }
}
