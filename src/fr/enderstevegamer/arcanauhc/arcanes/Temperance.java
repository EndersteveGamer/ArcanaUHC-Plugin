package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.PlayerInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Temperance {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.TEMPERANCE)) return;
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.DAMAGE_RESISTANCE, 1, 0, false, false
        ));
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.SLOW, 1, 0, false, false
        ));
    }

    public static void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.TEMPERANCE)) return;
        if (event.getCause().equals(DamageCause.LAVA)
                || ((event.getCause().equals(DamageCause.FIRE_TICK)
                || event.getCause().equals(DamageCause.FIRE))
                                && PlayerInfo.isInLava(player))
        ) {
            event.setCancelled(true);
        }
    }

    public static void accelerateInWater(PlayerMoveEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.TEMPERANCE)) return;
        if (!PlayerInfo.isInWater(event.getPlayer())) return;
        Vector velocity = event.getPlayer().getLocation().getDirection();
        velocity.multiply(0.4);
        velocity.setY(event.getPlayer().getLocation().getDirection().multiply(0.2).getY());
        event.getPlayer().setVelocity(velocity);
    }
}
