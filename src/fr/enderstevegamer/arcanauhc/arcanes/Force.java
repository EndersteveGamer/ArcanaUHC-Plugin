package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.ActionbarUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class Force {
    private static final ArrayList<Material> SWORDS = new ArrayList<>(Arrays.asList(
            Material.WOOD_SWORD,
            Material.STONE_SWORD,
            Material.GOLD_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD
    ));

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.FORCE)) return;
        if (!SWORDS.contains(player.getItemInHand().getType())) return;
        event.setDamage(event.getDamage() * 1.4);
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player player = (Player) arrow.getShooter();
        if (!GameState.getPlayerArcane(player).equals(Arcane.FORCE)) return;
        event.setDamage(event.getDamage() * 0.6);
    }

    public static void onArrowDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) return;
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.FORCE)) return;
        event.setDamage(event.getDamage() * 1.2);
    }

    public static void preventLavaPlacing(PlayerBucketEmptyEvent event) {
        if (!event.getBucket().equals(Material.LAVA_BUCKET)) return;
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.FORCE)) return;
        event.setCancelled(true);
        ActionbarUtils.sendActionBarMessage(
                event.getPlayer(),
                ChatColor.RED + "Votre arcane de " + ChatColor.GOLD + Arcane.FORCE +
                        ChatColor.RED + " vous empêche de placer ce seau de lave!"
        );
    }

    public static void preventLavaTaking(PlayerBucketFillEvent event) {
        if (!event.getBlockClicked().getType().equals(Material.LAVA)
                && !event.getBlockClicked().getType().equals(Material.STATIONARY_LAVA)) return;
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.FORCE)) return;
        event.setCancelled(true);
        ActionbarUtils.sendActionBarMessage(
                event.getPlayer(),
                ChatColor.RED + "Votre arcane de " + ChatColor.GOLD + Arcane.FORCE +
                        ChatColor.RED + " vous empêche de récupérer ce seau de lave!"
        );
    }
}
