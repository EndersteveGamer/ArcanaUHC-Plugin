package fr.enderstevegamer.arcanauhc;

import fr.enderstevegamer.arcanauhc.commands.Config;
import fr.enderstevegamer.arcanauhc.listeners.OnInventoryClick;
import fr.enderstevegamer.arcanauhc.listeners.OnItemPickup;
import fr.enderstevegamer.arcanauhc.loops.ArmorPassiveLimit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("config").setExecutor(new Config());

        GameSettings.resetSettings();

        Bukkit.getServer().getPluginManager().registerEvents(new OnInventoryClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnItemPickup(), this);

        new ArmorPassiveLimit().runTaskTimer(this, 0, 0);

        Bukkit.getLogger().log(Level.INFO, ChatColor.GREEN + "Le plugin ArcanaUHC a été chargé avec succès!");
    }
}
