package fr.enderstevegamer.arcanauhc;

import fr.enderstevegamer.arcanauhc.commands.Config;
import fr.enderstevegamer.arcanauhc.commands.EquipStartingStuff;
import fr.enderstevegamer.arcanauhc.commands.SetGameName;
import fr.enderstevegamer.arcanauhc.commands.tabcompleters.EquipStartingStuffCompleter;
import fr.enderstevegamer.arcanauhc.listeners.*;
import fr.enderstevegamer.arcanauhc.loops.ArmorPassiveLimit;
import fr.enderstevegamer.arcanauhc.loops.DiamondPassiveLimit;
import fr.enderstevegamer.arcanauhc.loops.SetScoreboards;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    public static Scoreboard healthSbAll;
    public static Objective healthObjectiveAll1;
    public static Objective healthObjectiveAll2;
    public static Scoreboard healthList;
    public static Objective healthObjList;
    public static Scoreboard healthUnderName;
    public static Objective healthObjUnderName;
    public static Main instance;
    @Override
    public void onEnable() {
        instance = this;

        getCommand("config").setExecutor(new Config());
        getCommand("equipstartingstuff").setExecutor(new EquipStartingStuff());
        getCommand("equipstartingstuff").setTabCompleter(new EquipStartingStuffCompleter());
        getCommand("setgamename").setExecutor(new SetGameName());

        GameSettings.resetSettings();

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

        new ArmorPassiveLimit().runTaskTimer(this, 0, 0);
        new DiamondPassiveLimit().runTaskTimer(this, 0, 0);
        new SetScoreboards().runTaskTimer(this, 0, 0);

        healthSbAll = Bukkit.getScoreboardManager().getNewScoreboard();
        healthObjectiveAll1 = healthSbAll.registerNewObjective("health", "health");
        healthObjectiveAll1.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        healthObjectiveAll2 = healthSbAll.registerNewObjective("pv", "health");
        healthObjectiveAll2.setDisplaySlot(DisplaySlot.BELOW_NAME);
        healthList = Bukkit.getScoreboardManager().getNewScoreboard();
        healthObjList = healthList.registerNewObjective("healthlist", "health");
        healthObjList.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        healthUnderName = Bukkit.getScoreboardManager().getNewScoreboard();
        healthObjUnderName = healthUnderName.registerNewObjective("pv", "health");
        healthObjUnderName.setDisplaySlot(DisplaySlot.BELOW_NAME);

        Bukkit.getLogger().log(Level.INFO, ChatColor.GREEN + "Le plugin ArcanaUHC a été chargé avec succès!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.INFO, ChatColor.GREEN + "Le plugin ArcanaUHC a été désactivé avec succès!");
    }

    public static Scoreboard getHealthSbAll() {
        return healthSbAll;
    }

    public static Objective getHealthObjectiveAll1() {
        return healthObjectiveAll1;
    }

    public static Objective getHealthObjectiveAll2() {
        return healthObjectiveAll2;
    }

    public static Scoreboard getHealthList() {
        return healthList;
    }

    public static Objective getHealthObjList() {
        return healthObjList;
    }

    public static Scoreboard getHealthUnderName() {
        return healthUnderName;
    }

    public static Objective getHealthObjUnderName() {
        return healthObjUnderName;
    }

    public static Main getInstance() {
        return instance;
    }
}
