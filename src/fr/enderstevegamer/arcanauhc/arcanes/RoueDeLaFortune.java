package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RoueDeLaFortune {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.ROUE_DE_LA_FORTUNE)) return;
        Integer[] effects = GameState.getRoueDeLaFortuneEffects(player);
        if (effectsContains(effects, 0)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SPEED, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 1)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.FAST_DIGGING, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 2)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.DAMAGE_RESISTANCE, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 4)) {
            player.setFoodLevel(20);
            player.setSaturation(20);
        }
        if (effectsContains(effects, 5)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.FIRE_RESISTANCE, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 6)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.WATER_BREATHING, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 7)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SLOW, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 8)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.WEAKNESS, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 9)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.HUNGER, 1, 0, false, false
            ));
        }
        if (effectsContains(effects, 10)) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SLOW_DIGGING, 1, 0, false, false
            ));
        }
    }

    public static boolean effectsContains(Integer[] effects, int num) {
        for (int num1 : effects) {
            if (num1 == num) return true;
        }
        return false;
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(damager).equals(Arcane.ROUE_DE_LA_FORTUNE)) return;
        if (!RoueDeLaFortune.effectsContains(GameState.getRoueDeLaFortuneEffects(damager), 3)) return;
        event.setDamage(event.getDamage() * 1.4);
    }
}
