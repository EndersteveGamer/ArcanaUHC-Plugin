package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;

public class MaisonDieu {
    private static final ArrayList<Material> SWORDS = new ArrayList<>(Arrays.asList(
            Material.WOOD_SWORD,
            Material.STONE_SWORD,
            Material.GOLD_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD
    ));
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.MAISON_DIEU)) return;
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.SPEED, 1, 0, false, false
        ));
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.JUMP, 1, 1, false, false
        ));
    }

    public static void cancelFallDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.MAISON_DIEU)) return;
        if (!event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) return;
        event.setCancelled(true);
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player shooter = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(shooter).equals(Arcane.MAISON_DIEU)) return;
        event.setDamage(event.getDamage() * 1.15);
        if (Math.random() >= 0.2) return;
        event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
    }

    public static void onArrowLand(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getEntity();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player player = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(player).equals(Arcane.MAISON_DIEU)) return;
        if (Math.random() >= 0.2) return;
        arrow.getWorld().strikeLightning(arrow.getLocation());
        arrow.remove();
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.MAISON_DIEU)) return;
        if (!SWORDS.contains(player.getItemInHand().getType())) return;
        event.setDamage(event.getDamage() * 0.85);
    }
}
