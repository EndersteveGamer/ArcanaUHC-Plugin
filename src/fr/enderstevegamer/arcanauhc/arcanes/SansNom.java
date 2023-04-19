package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SansNom {
    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (event.getDamager() instanceof Player) return;
        if (event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player) return;
        if (!GameState.getPlayerArcane(player).equals(Arcane.SANS_NOM)) return;
        event.setCancelled(true);
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.SANS_NOM)) return;
        if (Math.random() >= 0.1) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;
        LivingEntity entity = (LivingEntity) event.getEntity();
        entity.addPotionEffect(new PotionEffect(
                PotionEffectType.WITHER, 5 * 20, 0, false, false
        ));
    }

    public static void onBlockBreak(BlockBreakEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.SANS_NOM)) return;
        if (!event.getBlock().getType().equals(Material.GOLD_ORE)
                && !event.getBlock().getType().equals(Material.DIAMOND_ORE)) return;
        if (Math.random() >= 0.1) return;
        event.setCancelled(true);
        event.getBlock().setType(Material.AIR);
    }
}
