package fr.enderstevegamer.arcanauhc.scenarios;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Leaves;
import org.bukkit.material.Tree;
import org.bukkit.util.Vector;

public class FastLeavesDecay {

    public static void accelerateLeafDecay(Block block, int recursion) {
        if (recursion <= 0) return;
        if (block.getType() == Material.LEAVES || block.getType() == Material.LEAVES_2) {
            if (block.getType().equals(Material.LEAVES)) {
                Tree tree = (Tree) block.getState().getData();
                if (tree.getSpecies().equals(TreeSpecies.GENERIC) || tree.getSpecies().equals(TreeSpecies.DARK_OAK)) {
                    block.setType(Material.AIR);
                    if (Math.random() >= 1 - 0.05) {
                        block.getWorld().dropItem(
                                block.getLocation().add(new Vector(0.5, 0.5, 0.5)),
                                (tree.getSpecies().equals(TreeSpecies.GENERIC)) ? new ItemStack(Material.SAPLING, 1, (short) 0) :
                                        new ItemStack(Material.SAPLING, 1, (short) 5)
                        );
                    }
                    if (Math.random() >= 1 - (GameSettings.getIntegerSetting(GameSettings.APPLES_DROP) / 100f)) {
                        block.getWorld().dropItem(
                                block.getLocation().add(new Vector(0.5, 0.5, 0.5)),
                                new ItemStack(Material.APPLE)
                        );
                    }
                }
                else block.breakNaturally();
            }
            else block.breakNaturally();
        }
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = -1; y <= 1; y++) {
                    if (x == 0 && y == 0 && z == 0) continue;
                    if (block.getRelative(x, y, z).getType().equals(Material.LEAVES)
                            || block.getRelative(x, y, z).getType().equals(Material.LEAVES_2)) {
                        accelerateLeafDecay(block.getRelative(x, y, z), recursion - 1);
                    }
                }
            }
        }
    }
}
