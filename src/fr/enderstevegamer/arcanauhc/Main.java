package fr.enderstevegamer.arcanauhc;

import fr.enderstevegamer.arcanauhc.commands.Config;
import fr.enderstevegamer.arcanauhc.commands.Doc;
import fr.enderstevegamer.arcanauhc.commands.EquipStartingStuff;
import fr.enderstevegamer.arcanauhc.commands.SetGameName;
import fr.enderstevegamer.arcanauhc.commands.tabcompleters.DocCompleter;
import fr.enderstevegamer.arcanauhc.commands.tabcompleters.EquipStartingStuffCompleter;
import fr.enderstevegamer.arcanauhc.listeners.*;
import fr.enderstevegamer.arcanauhc.loops.*;
import fr.enderstevegamer.arcanauhc.utils.DisplayUtils;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable() {
        instance = this;

        getCommand("config").setExecutor(new Config());
        getCommand("equipstartingstuff").setExecutor(new EquipStartingStuff());
        getCommand("equipstartingstuff").setTabCompleter(new EquipStartingStuffCompleter());
        getCommand("setgamename").setExecutor(new SetGameName());
        getCommand("doc").setExecutor(new Doc());
        getCommand("doc").setTabCompleter(new DocCompleter());

        GameSettings.resetSettings();
        GameState.resetGame();

        Bukkit.getServer().getPluginManager().registerEvents(new OnInventoryClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnItemPickup(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnLavaPickup(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnLavaPlace(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnProjectileLaunch(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnEntityDeath(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnBlockBreak(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnEntityDamageEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnLeavesDecay(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnServerListPing(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerXpChange(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnEntityDamageByEntity(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerDeath(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerInteract(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnItemConsume(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnProjectileLand(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerMove(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnFoodLevelChange(), this);

        new ArmorPassiveLimit().runTaskTimer(this, 0, 0);
        new DiamondPassiveLimit().runTaskTimer(this, 0, 0);
        new SetScoreboards().runTaskTimer(this, 0, 0);
        new GameStateUpdater().runTaskTimer(this, 0, 0);
        new GiveArcanesEffects().runTaskTimer(this, 0, 0);

        Bukkit.getLogger().log(Level.INFO, ChatColor.GREEN + "Le plugin ArcanaUHC a été chargé avec succès!");
    }

    public static Scoreboard getScoreboard() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        if (GameSettings.getBooleanSetting(GameSettings.HEALTH_IN_TAB)) {
            Objective obj = scoreboard.registerNewObjective("health", "health");
            obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            for (Player player : Bukkit.getOnlinePlayers()) {
                obj.getScore(player.getName()).setScore((int) player.getHealth());
            }
        }
        if (GameSettings.getBooleanSetting(GameSettings.LIFE_UNDER_NAME)) {
            Objective obj = scoreboard.registerNewObjective("pv", "health");
            obj.setDisplaySlot(DisplaySlot.BELOW_NAME);
            for (Player player : Bukkit.getOnlinePlayers()) {
                obj.getScore(player.getName()).setScore((int) player.getHealth());
            }
        }
        if (GameState.gameStarted()) {
            Objective obj = scoreboard.registerNewObjective(ChatColor.GOLD + GameSettings.getGameName(), "dummy");
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
            obj.getScore(ChatColor.WHITE + "Temps actuel: " + ChatColor.GOLD + DisplayUtils.millisecondsToTimeString(GameState.getGameTime())).setScore(5);
            obj.getScore("").setScore(4);
            obj.getScore(ChatColor.WHITE + "Activation du PVP: " + ChatColor.GOLD +
                    DisplayUtils.millisecondsToTimeString(GameSettings.getIntegerSetting(GameSettings.TIME_BEFORE_PVP) * 60000L)).setScore(3);
            obj.getScore(ChatColor.WHITE + "Final heal: " + ChatColor.GOLD +
                    DisplayUtils.millisecondsToTimeString(GameSettings.getIntegerSetting(GameSettings.FINAL_HEAL) * 60000L)).setScore(2);
            obj.getScore(ChatColor.WHITE + "Réduction de la bordure: " + ChatColor.GOLD +
                    DisplayUtils.millisecondsToTimeString(GameSettings.getIntegerSetting(GameSettings.BORDER_WAIT_TIME) * 60000L)).setScore(1);
            obj.getScore(ChatColor.WHITE + "Bordure taille minimale: " + ChatColor.GOLD +
                    DisplayUtils.millisecondsToTimeString(
                            (GameSettings.getIntegerSetting(GameSettings.BORDER_WAIT_TIME) + GameSettings.getIntegerSetting(GameSettings.BORDER_REDUCTION_TIME)) * 60000L
                    )).setScore(0);
        }
        return scoreboard;
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.INFO, ChatColor.GREEN + "Le plugin ArcanaUHC a été désactivé avec succès!");
    }

    public static Main getInstance() {
        return instance;
    }
}
