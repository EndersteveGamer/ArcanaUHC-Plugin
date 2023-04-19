package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;

public class Mat {
    private static final ArrayList<Material> SWORDS = new ArrayList<>(Arrays.asList(
            Material.WOOD_SWORD,
            Material.STONE_SWORD,
            Material.GOLD_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD
    ));

    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.MAT)) return;
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.SPEED, 1, 0, false, false
        ));
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.MAT)) return;
        if (!SWORDS.contains(player.getItemInHand().getType())) return;
        event.setDamage(event.getDamage() * 1.2);
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player player = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(player).equals(Arcane.MAT)) return;
        event.setDamage(event.getDamage() * 0.8);
    }
}
