package fr.enderstevegamer.arcanauhc;

import fr.enderstevegamer.arcanauhc.commands.Config;
import fr.enderstevegamer.arcanauhc.listeners.OnInventoryClick;
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

        Bukkit.getLogger().log(Level.INFO, ChatColor.GREEN + "Le plugin ArcanaUHC a été chargé avec succès!");
    }
}
