package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.arcanes.Amoureux;
import fr.enderstevegamer.arcanauhc.arcanes.MaisonDieu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class OnProjectileLand implements Listener {
    @EventHandler
    public static void onProjectileLand(ProjectileHitEvent event) {
        Amoureux.onProjectileLand(event);
        MaisonDieu.onArrowLand(event);
    }
}
