package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
        for (Player player1 : Bukkit.getOnlinePlayers()) {
            if (player1.getGameMode().equals(GameMode.SPECTATOR)) continue;
            if (LocationUtils.distanceToLocation(player.getLocation(), player1.getLocation()) > 10) continue;
            if (player == player1) continue;
            hasSlowness = true;
            player1.addPotionEffect(new PotionEffect(
                    PotionEffectType.WEAKNESS, 1, 3, false, false
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
