package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Hermite {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.HERMITE)) return;
        if (GameState.isHermiteOnSpeed()) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SPEED, 1, 1, false, false
            ), true);
        }
        else player.addPotionEffect(new PotionEffect(
                PotionEffectType.SLOW, 1, 0, true, true
        ), true);
    }
}
