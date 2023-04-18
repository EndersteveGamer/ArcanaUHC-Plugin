package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class Force {
    private static final ArrayList<Material> SWORDS = new ArrayList<>(Arrays.asList(
            Material.WOOD_SWORD,
            Material.STONE_SWORD,
            Material.GOLD_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD
    ));

    public static void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!GameState.getPlayerArcane(player).equals(Arcane.FORCE)) return;

    }
}
