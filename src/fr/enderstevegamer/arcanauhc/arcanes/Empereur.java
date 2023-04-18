package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Empereur {
    public static void onKill(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;
        if (!GameState.getPlayerArcane(event.getEntity().getKiller()).equals(Arcane.EMPEREUR)) return;
        event.getEntity().getKiller().addPotionEffect(new PotionEffect(
                PotionEffectType.SPEED,
                20 * 60 * 5,
                1,
                false,
                false
        ));
    }

    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(damager).equals(Arcane.EMPEREUR)) return;
        if (Math.random() >= 0.75) return;
        if (GameState.isPvpDisabled()) return;
        event.getEntity().setFireTicks(80);
    }
}
