package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.ActionbarUtils;
import fr.enderstevegamer.arcanauhc.utils.AmoureuxLink;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class Amoureux {
    private static final ArrayList<Material> SWORDS = new ArrayList<>(Arrays.asList(
            Material.WOOD_SWORD,
            Material.STONE_SWORD,
            Material.GOLD_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD
    ));

    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!GameState.getPlayerArcane(player).equals(Arcane.AMOUREUX)) return;
        if (event.getDamager() instanceof Player) return;
        if (event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player) return;
        event.setCancelled(true);
    }

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(damager).equals(Arcane.AMOUREUX)) return;
        if (damager.getItemInHand() == null) return;
        if (!SWORDS.contains(damager.getItemInHand().getType())) return;
        event.setDamage(event.getDamage() * 0.9);
    }

    public static void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (!event.getItem().getType().equals(Material.DIAMOND_HOE)) return;
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.AMOUREUX)) return;
        if (!GameState.amoureuxCooldownFinished(event.getPlayer())) {
            ActionbarUtils.sendActionBarMessage(event.getPlayer(),
                    ChatColor.RED +
                            "Vous pourrez utiliser votre capacité de nouveau dans " + ChatColor.GOLD +
                            GameState.getAmoureuxCooldown(event.getPlayer()) + ChatColor.RED + " secondes");
        }
        else {
            shoot(event);
            GameState.resetAmoureuxCooldown(event.getPlayer());
        }
    }

    public static void shoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Snowball snowball = player.launchProjectile(Snowball.class);
        GameState.addAmoureuxSnowball(snowball, player);
    }

    public static void onArrowHit(EntityDamageByEntityEvent event) {
        if (!event.getCause().equals(DamageCause.PROJECTILE)) return;
        if (!(event.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Entity)) return;
        Entity entity = (Entity) arrow.getShooter();
        if (GameState.amoureuxLinkExists(event.getEntity().getUniqueId(), entity.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    public static void onSnowballHit(EntityDamageByEntityEvent event) {
        if (!event.getCause().equals(DamageCause.PROJECTILE)) return;
        if (!(event.getDamager() instanceof Snowball)) return;
        Snowball snowball = (Snowball) event.getDamager();
        if (!(snowball.getShooter() instanceof Player)) return;
        Player shooter = (Player) snowball.getShooter();
        if (!GameState.getPlayerArcane(shooter).equals(Arcane.AMOUREUX)) return;
        AmoureuxLink link = GameState.createAmoureuxLink(shooter.getUniqueId(), event.getEntity().getUniqueId(),
                (event.getEntity() instanceof Player));
        if (!(event.getEntity() instanceof Player)) {
            shooter.sendMessage(ChatColor.GOLD + "Vous êtes maintenant lié à " + event.getEntity().getType().toString());
        }
        else {
            link.announceLink();
        }
    }

    public static void preventLinkedHitting(EntityDamageByEntityEvent event) {
        if (GameState.amoureuxLinkExists(event.getDamager().getUniqueId(), event.getEntity().getUniqueId())) event.setCancelled(true);
    }
}
