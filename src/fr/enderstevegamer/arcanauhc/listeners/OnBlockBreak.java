package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.arcanes.*;
import fr.enderstevegamer.arcanauhc.scenarios.Timber;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Tree;
import org.bukkit.util.Vector;

public class OnBlockBreak implements Listener {
    @EventHandler
    public static void onBlockBreak(BlockBreakEvent event) {
        Bateleur.onBlockBreak(event);
        Papesse.onBlockBreak(event);
        Pape.onBlockBreak(event);
        SansNom.onBlockBreak(event);
        Diable.onBlockBreak(event);
        if (event.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_AXE)
                && (event.getBlock().getType().equals(Material.LOG) || event.getBlock().getType().equals(Material.LOG_2))
                && GameSettings.getBooleanSetting(GameSettings.Scenarios.TIMBER)) Timber.timberBlock(event.getBlock(), false);
        if (event.getBlock().getType().equals(Material.GRAVEL)
                && !event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getBlock().getWorld().dropItem(
                    event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                    new ItemStack(
                            (Math.random() >= 1 - (GameSettings.getIntegerSetting(GameSettings.FLINT_DROP) / 100f)
                                    && GameSettings.getIntegerSetting(GameSettings.FLINT_DROP) != 0) ?
                                    Material.FLINT :
                                    Material.GRAVEL
                    )
            );
        }
        if (event.getBlock().getType().equals(Material.LEAVES)
                && !event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            Tree tree = (Tree) event.getBlock().getState().getData();
            if (tree.getSpecies().equals(TreeSpecies.GENERIC) || tree.getSpecies().equals(TreeSpecies.DARK_OAK)) {
                event.setCancelled(true);
                event.getBlock().setType(Material.AIR);
                if (event.getPlayer().getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {
                    event.getBlock().getWorld().dropItem(
                            event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                            new ItemStack(Material.LEAVES, 1, (tree.getSpecies().equals(TreeSpecies.GENERIC)) ? (short) 0 : (short) 5)
                    );
                }
                else {
                    if (Math.random() >= 1 - 0.05) {
                        event.getBlock().getWorld().dropItem(
                                event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                                (tree.getSpecies().equals(TreeSpecies.GENERIC)) ? new ItemStack(Material.SAPLING, 1, (short) 0) :
                                        new ItemStack(Material.SAPLING, 1, (short) 5)
                        );
                    }
                    if (Math.random() >= 1 - (GameSettings.getIntegerSetting(GameSettings.APPLES_DROP) / 100f)) {
                        event.getBlock().getWorld().dropItem(
                                event.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
                                new ItemStack(Material.APPLE)
                        );
                    }
                }
            }
        }
    }
}
