package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;

public class Chariot {
    private static final ArrayList<Material> SWORDS = new ArrayList<>(Arrays.asList(
            Material.WOOD_SWORD,
            Material.STONE_SWORD,
            Material.GOLD_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD
    ));
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.CHARIOT)) return;
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.SPEED, 1, 1, false, false
        ));
    }

    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(damager).equals(Arcane.CHARIOT)) return;
        if (!SWORDS.contains(damager.getItemInHand().getType())) return;
        event.setDamage(event.getDamage() * 1.15);
    }

    public static void onDamageTaken(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.CHARIOT)) return;
        event.setDamage(event.getDamage() * 1.1);
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player shooter = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(shooter).equals(Arcane.CHARIOT)) return;
        event.setDamage(event.getDamage() * 0.75);
    }
}
