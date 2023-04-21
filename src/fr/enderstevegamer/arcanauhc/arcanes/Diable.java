package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Diable {
    private static final int GAPPLE_HEAL = 4;
    public static void onGoldenApple(PlayerItemConsumeEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.DIABLE)) return;
        if (!event.getItem().getType().equals(Material.GOLDEN_APPLE)) return;
        event.getPlayer().setHealth(Math.min(event.getPlayer().getHealth() + GAPPLE_HEAL, event.getPlayer().getMaxHealth()));
        new BukkitRunnable() {
            final Player player = event.getPlayer();
            @Override
            public void run() {
                player.removePotionEffect(PotionEffectType.REGENERATION);
            }
        }.runTaskLater(Main.getInstance(), 1);
    }

    public static void onBlockBreak(BlockBreakEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.DIABLE)) return;
        if (!event.getBlock().getType().equals(Material.GOLD_ORE)
                && !event.getBlock().getType().equals(Material.DIAMOND_ORE)) return;
        if (Math.random() >= 0.15) return;
        event.setCancelled(true);
        event.getBlock().setType(Material.AIR);
    }

    public static void onKill(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;
        Player killer = event.getEntity().getKiller();
        if (!GameState.getPlayerArcane(killer).equals(Arcane.DIABLE)) return;
        GameState.buffDiablePlayer(killer);
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(damager).equals(Arcane.DIABLE)) return;
        GameState.DiableStengthBuff buff = GameState.getPlayerDiableBuff(damager);
        if (buff == null) return;
        event.setDamage(event.getDamage() * 1 + (0.4 * (buff.getLevel() + 1)));
    }
}
