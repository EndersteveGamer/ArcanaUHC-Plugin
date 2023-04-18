package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.PlayerUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;

public class Bateleur {
    static final ArrayList<Material> BATELEUR_BLOCKS = new ArrayList<>(Arrays.asList(
            Material.COBBLESTONE,
            Material.STONE
    ));

    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.BATELEUR)) return;
        Material material = PlayerUtils.getBlockUnder(player).getType();
        if (!BATELEUR_BLOCKS.contains(material)) return;
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1, 1, false, false));
    }

    public static void onDamage(EntityDamageEvent event) {
        if (!event.getEntityType().equals(EntityType.PLAYER)) return;
        Player player = (Player) event.getEntity();
        if (GameState.getPlayerArcane(player).equals(Arcane.BATELEUR) && event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            event.setDamage(event.getDamage() * 2);
        }
    }

    public static void onBlockBreak(BlockBreakEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.BATELEUR)) return;
        if (!event.getBlock().getType().equals(Material.COAL_ORE)) return;
        if (event.getPlayer().getItemInHand() == null) return;
        event.setCancelled(true);
        int fortuneLevel = 0;
        if (event.getPlayer().getItemInHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
            fortuneLevel = event.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }
        event.getBlock().setType(Material.AIR);
        event.getBlock().getWorld().dropItem(
                event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                new ItemStack(Material.GOLD_INGOT, 1 + (int) (Math.random() * (fortuneLevel + 1)))
        );
        Pape.spawnXpOrb(event);
    }
}
