package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.Main;
import fr.enderstevegamer.arcanauhc.utils.WorldUtils;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Etoile {
    public static void onGoldenApple(PlayerItemConsumeEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.ETOILE)) return;
        if (!event.getItem().getType().equals(Material.GOLDEN_APPLE)) return;
        new BukkitRunnable() {
            final Player player = event.getPlayer();
            @Override
            public void run() {
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.addPotionEffect(new PotionEffect(
                        PotionEffectType.REGENERATION, 20 * 6, 1, false, false
                ));
            }
        }.runTaskLater(Main.getInstance(), 1);
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.ETOILE)) return;
        if (WorldUtils.isDay(player.getWorld())) {
            event.setDamage(event.getDamage() * 1.2);
        }
        else {
            event.setDamage(event.getDamage() * 0.8);
        }
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player shooter = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(shooter).equals(Arcane.ETOILE)) return;
        if (WorldUtils.isDay(event.getEntity().getWorld())) {
            event.setDamage(event.getDamage() * 1.2);
        }
        else {
            event.setDamage(event.getDamage() * 0.8);
        }
    }

    public static void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.ETOILE)) return;
        if (WorldUtils.isDay(player.getWorld())) {
            event.setDamage(event.getDamage() * 1.2);
        }
        else {
            event.setDamage(event.getDamage() * 0.8);
        }
    }
}
