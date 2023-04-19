package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.WorldUtils;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Lune {
    public static void onFoodChange(FoodLevelChangeEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.LUNE)) return;
        if (player.getFoodLevel() <= 20) return;
        int levelChange = player.getFoodLevel() - event.getFoodLevel();
        event.setFoodLevel(levelChange * 2);
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.LUNE)) return;
        if (WorldUtils.isDay(event.getEntity().getWorld())) {
            event.setDamage(event.getDamage() * 0.85);
        }
        else {
            event.setDamage(event.getDamage() * 1.15);
        }
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player player = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(player).equals(Arcane.LUNE)) return;
        if (WorldUtils.isDay(event.getEntity().getWorld())) {
            event.setDamage(event.getDamage() * 0.85);
        }
        else {
            event.setDamage(event.getDamage() * 1.15);
        }
    }

    public static void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.LUNE)) return;
        if (WorldUtils.isDay(player.getWorld())) {
            event.setDamage(event.getDamage() * 1.15);
        }
        else {
            event.setDamage(event.getDamage() * 0.85);
        }
    }
}
