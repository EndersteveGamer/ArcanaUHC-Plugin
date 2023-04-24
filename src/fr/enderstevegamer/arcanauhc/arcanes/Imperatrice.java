package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.ActionbarUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Imperatrice {
    private static final ArrayList<Material> SWORDS = new ArrayList<>(Arrays.asList(
            Material.WOOD_SWORD,
            Material.STONE_SWORD,
            Material.GOLD_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD
    ));

    private static final int SHOCKWAVE_FORCE = 10;

    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.IMPERATRICE)) return;
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1, 0, false, false));
    }

    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.IMPERATRICE)) return;
        if (player.getItemInHand() == null) return;
        Material mat = ((Player) event.getDamager()).getItemInHand().getType();
        if (!SWORDS.contains(mat)) return;
        event.setDamage(event.getDamage() * 1.15);
    }

    public static void onItemInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.IMPERATRICE)) return;
        if (!event.getItem().getType().equals(Material.STICK)) return;
        if (!GameState.imperatriceCooldownFinished(event.getPlayer())) {
            ActionbarUtils.sendActionBarMessage(event.getPlayer(), ChatColor.RED +
                    "Vous pourrez utiliser votre capacité de nouveau dans " + ChatColor.GOLD +
                    GameState.getImperatriceCooldown(event.getPlayer()) + ChatColor.RED + " secondes");
        }
        else {
            imperatriceShockwave(event.getPlayer());
            GameState.resetImperatriceCooldown(event.getPlayer());
        }
    }

    public static void imperatriceShockwave(Player player) {
        Collection<Entity> entities = player.getWorld().getNearbyEntities(player.getLocation(), 15, 15, 15);
        entities.remove(player);
        for (Entity entity : entities) {
            if (!(entity instanceof Player) || !((Player) entity).getGameMode().equals(GameMode.SPECTATOR)) {
                entity.setVelocity(
                        getVectorFromLocations(player.getLocation(), entity.getLocation()).normalize().multiply(SHOCKWAVE_FORCE)
                );
            }
        }
        player.getWorld().createExplosion(
                player.getLocation().getX(),
                player.getLocation().getY(),
                player.getLocation().getZ(),
                0,
                false,
                false
        );
    }

    private static Vector getVectorFromLocations(Location loc1, Location loc2) {
        return new Vector(
                loc2.getX() - loc1.getX(),
                loc2.getY() - loc1.getY(),
                loc2.getZ() - loc1.getZ()
        );
    }
}
