package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.listeners.OnPlayerMove;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Pendu {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.PENDU)) return;
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.WEAKNESS, 1, 3, false, false
        ));
    }

    public static void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.PENDU)) return;
        event.setDamage(event.getDamage() * 0.85);
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        if (!(event.getEntity() instanceof Player)) return;
        Player damaged = (Player) event.getEntity();
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player shooter = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(shooter).equals(Arcane.PENDU)) return;
        if (Math.random() >= 0.1) return;
        GameState.penduImmobilize(damaged);
        damaged.sendMessage(ChatColor.RED + "Vous avez été immobilisé par un arcane " + ChatColor.GOLD + Arcane.PENDU);
        shooter.sendMessage(ChatColor.GREEN + "Vous avez immobilisé " + ChatColor.GOLD + damaged.getName());
    }

    public static void onMove(PlayerMoveEvent event) {
        if (GameState.isPenduImmobilized(event.getPlayer())) {
            event.setCancelled(true);
            event.getPlayer().setFallDistance(0);
        }
    }
}
