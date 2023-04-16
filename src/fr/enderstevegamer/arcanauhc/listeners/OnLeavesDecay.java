package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.Main;
import fr.enderstevegamer.arcanauhc.scenarios.FastLeavesDecay;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class OnLeavesDecay implements Listener {
    static Main instance;
    @EventHandler
    public static void onLeavesDecay(LeavesDecayEvent event) {
        if (GameSettings.getBooleanSetting(GameSettings.Scenarios.FAST_LEAVES_DECAY)) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    for (int y = -1; y <= 1; y++) {
                        if (x == 0 && y == 0 && z == 0) continue;
                        if (event.getBlock().getRelative(x, y, z).getType().equals(Material.LEAVES)
                                || event.getBlock().getRelative(x, y, z).getType().equals(Material.LEAVES_2)) {
                            FastLeavesDecay.accelerateLeafDecay(event.getBlock().getRelative(x, y, z), 5);
                        }
                    }
                }
            }
        }
    }

    public OnLeavesDecay(Main instance) {
        OnLeavesDecay.instance = instance;
    }
}
