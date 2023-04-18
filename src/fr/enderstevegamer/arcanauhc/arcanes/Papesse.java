package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Papesse {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.PAPESSE)) return;
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1, 0, false, false), true);
        if (noBlockUpwards(player)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 60, 0, false, false), true);
        }
        else {
            boolean removeEffect = true;
            for (PotionEffect effect : player.getActivePotionEffects()) {
                if (effect.getType().equals(PotionEffectType.INVISIBILITY) && effect.getDuration() > 60) removeEffect = false;
            }
            if (removeEffect) player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
    }

    public static boolean noBlockUpwards(Player player) {
        for (int yPos = player.getLocation().getBlockY() + 2; yPos < 255; yPos++) {
            if (!player.getWorld().getBlockAt(new Location(
                    player.getWorld(),
                    player.getLocation().getBlockX(),
                    yPos,
                    player.getLocation().getBlockZ()
            )).getType().equals(Material.AIR)) {
                return false;
            }
        }
        return true;
    }

    public static void onBlockBreak(BlockBreakEvent event) {
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.PAPESSE)) return;
        if (event.getPlayer().getItemInHand() == null) return;
        if (!event.getBlock().getType().equals(Material.LAPIS_ORE)) return;
        if (Math.random() >= 0.95) return;
        event.setCancelled(true);
        event.getBlock().setType(Material.AIR);
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        meta.addStoredEnchant(getRandomEnchant(), 1, true);
        book.setItemMeta(meta);
        event.getBlock().getWorld().dropItem(
                event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                book
        );
    }

    public static Enchantment getRandomEnchant() {
        int enchNum = (int)(Math.random() * 15);
        switch (enchNum) {
            case 0: return Enchantment.DAMAGE_ALL;
            case 1: return Enchantment.FIRE_ASPECT;
            case 2: return Enchantment.KNOCKBACK;
            case 3: return Enchantment.THORNS;
            case 4: return Enchantment.PROTECTION_FALL;
            case 5: return Enchantment.DEPTH_STRIDER;
            case 6: return Enchantment.ARROW_INFINITE;
            case 7: return Enchantment.ARROW_FIRE;
            case 8: return Enchantment.ARROW_KNOCKBACK;
            case 9: return Enchantment.PROTECTION_ENVIRONMENTAL;
            case 10: return Enchantment.LOOT_BONUS_BLOCKS;
            case 11: return Enchantment.DIG_SPEED;
            case 12: return Enchantment.OXYGEN;
            case 13: return Enchantment.DURABILITY;
            default: return Enchantment.WATER_WORKER;
        }
    }
}
