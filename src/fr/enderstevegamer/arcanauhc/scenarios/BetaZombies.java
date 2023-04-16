package fr.enderstevegamer.arcanauhc.scenarios;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class BetaZombies {
    public static void onEntityDeath(EntityDeathEvent event) {
        event.getDrops().clear();
        event.getDrops().add(new ItemStack(Material.FEATHER, (int) (Math.random() * 3)));
    }
}
