package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.arcanes.Lune;
import fr.enderstevegamer.arcanauhc.arcanes.Soleil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OnFoodLevelChange implements Listener {
    @EventHandler
    public static void onFoodLevelChange(FoodLevelChangeEvent event) {
        Lune.onFoodChange(event);
        Soleil.onFoodChange(event);
    }
}
