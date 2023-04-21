package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Pape {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.PAPE)) return;
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1, 2, false, false));
        player.removePotionEffect(PotionEffectType.ABSORPTION);
    }

    public static void onBlockBreak(BlockBreakEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.PAPE)) return;
        if (!event.getBlock().getType().equals(Material.GOLD_ORE)
                && !event.getBlock().getType().equals(Material.DIAMOND_ORE)) return;
        if (event.getPlayer().getItemInHand() == null) return;
        if (event.getBlock().getType().equals(Material.GOLD_ORE)) doubleGold(event);
        if (event.getBlock().getType().equals(Material.DIAMOND_ORE)) doubleDiamond(event);
        event.setCancelled(true);
        event.getBlock().setType(Material.AIR);
    }

    public static void doubleGold(BlockBreakEvent event) {
        int fortuneLevel = 0;
        for (Enchantment enchant : event.getPlayer().getItemInHand().getEnchantments().keySet()) {
            if (enchant.equals(Enchantment.LOOT_BONUS_BLOCKS)) {
                fortuneLevel = event.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            }
        }
        event.getBlock().getWorld().dropItem(
                event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                new ItemStack(Material.GOLD_INGOT, 2)
        );
    }

    public static void doubleDiamond(BlockBreakEvent event) {
        int fortuneLevel = 0;
        for (Enchantment enchant : event.getPlayer().getItemInHand().getEnchantments().keySet()) {
            if (enchant.equals(Enchantment.LOOT_BONUS_BLOCKS)) {
                fortuneLevel = event.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            }
        }
        event.getBlock().getWorld().dropItem(
                event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                new ItemStack(Material.DIAMOND, getDiamondsNum(fortuneLevel) * 2)
        );
        spawnXpOrb(event);
    }

    static void spawnXpOrb(BlockBreakEvent event) {
        Entity entity = event.getBlock().getWorld().spawnEntity(
                event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                EntityType.EXPERIENCE_ORB
        );
        ExperienceOrb xp = (ExperienceOrb) entity;
        xp.setExperience((int)(Math.random() * 3));
        if (xp.getExperience() == 0) xp.remove();
    }

    public static int getDiamondsNum(int fortuneLevel) {
        int result = 0;
        switch (fortuneLevel) {
            case 0: return 1;
            case 1:
                if (Math.random() >= 2 / 3F) return 2;
                else return 1;
            case 2:
                if (Math.random() >= 0.5) return 2 + (int)(Math.random() * 2);
                else return 1;
            default:
                if (Math.random() >= 0.8) return 1;
                else return 2 + (int)(Math.random() * 3);
        }
    }

    public static void onEat(PlayerItemConsumeEvent event) {
        if (!event.getItem().getType().equals(Material.GOLDEN_APPLE)) return;
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.PAPE)) return;
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 60 * 2,
                0, false, false), true);
    }
}
