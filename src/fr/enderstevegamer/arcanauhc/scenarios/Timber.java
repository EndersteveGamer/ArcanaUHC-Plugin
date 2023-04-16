package fr.enderstevegamer.arcanauhc.scenarios;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class Timber {
    public static void timberBlock(Block block, boolean breakBlock) {
        if (!(block.getType().equals(Material.LOG) || block.getType().equals(Material.LOG_2))) return;
        if (breakBlock) block.breakNaturally();
        Location location = block.getLocation();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = 0; y <= 1; y++) {
                    if (x == 0 && z == 0 && y == 0) continue;
                    Location loc2 = location.clone().add(new Vector(x, y, z));
                    timberBlock(block.getWorld().getBlockAt(loc2), true);
                }
            }
        }
    }
}
