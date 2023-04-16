package fr.enderstevegamer.arcanauhc.scenarios;

import fr.enderstevegamer.arcanauhc.utils.PlayerInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class SafeMiners {
    public static void onEntityDamageEvent(EntityDamageEvent event) {
        Player player  = (Player) event.getEntity();
        if (!(player.getLocation().getY() <= 40)) return;
        if (event.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) event.setCancelled(true);
        if (event.getCause().equals(EntityDamageEvent.DamageCause.FIRE) && PlayerInfo.isInLava(player)) {
            event.setCancelled(true);
        }
        if (event.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) && PlayerInfo.isInLava(player)) {
            event.setCancelled(true);
        }
    }
}
