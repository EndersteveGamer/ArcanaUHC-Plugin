package fr.enderstevegamer.arcanauhc;

import fr.enderstevegamer.arcanauhc.utils.MathUtils;
import fr.enderstevegamer.arcanauhc.utils.PlayerUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

public class GameState {
    private static boolean gameStarted;
    private static boolean pvpEnabled;
    private static long startTime;
    private static boolean worldPregenerated;
    private static boolean isPregenerating;
    private static HashMap<UUID, Arcane> playerArcanes;
    private static boolean warnedAboutPregen;

    public static boolean isPvpEnabled() {
        return pvpEnabled;
    }

    public static void enablePvp() {
        pvpEnabled = true;
    }

    public static void disablePvp() {
        pvpEnabled = false;
    }

    public static boolean getWarnedAboutPregen() {
        return warnedAboutPregen;
    }

    public static void setWarnedAboutPregen(boolean warned) {
        warnedAboutPregen = warned;
    }

    public static long getGameTime() {
        return System.currentTimeMillis() - startTime;
    }

    public static boolean isWorldPregenerated() {
        return worldPregenerated;
    }

    public static void setWorldPregenerated(boolean isWorldPregenerated) {
        worldPregenerated = isWorldPregenerated;
    }

    public static boolean gameStarted() {
        return gameStarted;
    }

    public static void setGameStarted(boolean gameStarted) {
        GameState.gameStarted = gameStarted;
    }

    public static boolean isPregenerating() {
        return isPregenerating;
    }

    public static void resetGame() {
        setWorldPregenerated(false);
        disablePvp();
        setGameStarted(false);
        isPregenerating = false;
        playerArcanes = new HashMap<>();
        setWarnedAboutPregen(false);
    }

    public static void pregenerateWorld() {
        World world = new WorldCreator("world2").createWorld();
        if (world == null) {Bukkit.getLogger().log(Level.SEVERE, "Impossible de créer le monde, veuillez supprimer le monde nommé 'world2' avant de pregenerer a nouveau"); return;}
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getLogger().log(Level.INFO, "Pregeneration finie!");
                GameState.setWorldPregenerated(true);
            }
        }.runTaskLater(Main.getInstance(), 9500);
        for (int i = -47; i <= 47; i++) {
            final int i1 = i;
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getLogger().log(Level.INFO, "Pregeneration " + MathUtils.round(((float)(i1 + 47) / (47 + 47) * 100), 1) + "%");
                    pregenerateZPart(world, i1);
                }
            }.runTaskLater(Main.getInstance(), (i + 47) * 100);
        }
    }

    public static void pregenerateZPart(World world, int zChunk) {
        for (int i = 0; i <= 9; i++) {
            pregeneratePart(world, i, zChunk);
        }
    }

    public static void pregeneratePart(World world, int step, int zChunk) {
        int start;
        int end;
        if (step == 0) {start = -47; end = -40;}
        else if (step == 9) {start = 41; end = 47;}
        else {start = (step - 5) * 10 + 1; end = (step - 4) * 10;}
        new BukkitRunnable() {
            final int startChunk = start;
            final int endChunk = end;
            final int zChunkPos = zChunk;
            final World world1 = world;
            @Override
            public void run() {
                for (int x = startChunk; x <= endChunk; x++) {
                    world1.loadChunk(x, zChunkPos);
                    world1.unloadChunk(x, zChunkPos);
                }
            }
        }.runTaskLater(Main.getInstance(), (long) (step * 10f));
    }

    public static void startGame() {
        startTime = System.currentTimeMillis();

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            PlayerUtils.equipStartingStuff(player);
            player.teleport(Bukkit.getWorld("world2").getHighestBlockAt(0, 0).getLocation().add(new Vector(0, 1, 0)));
        }

        Bukkit.getWorld("world2").getWorldBorder().setCenter(0, 0);
        Bukkit.getWorld("world2").getWorldBorder().setSize(GameSettings.getIntegerSetting(GameSettings.DEFAULT_BORDER_SIZE));

        for (Player player : Bukkit.getOnlinePlayers()) playerArcanes.put(player.getUniqueId(), Arcane.SANS_ARCANE);
    }

    public static void distributeArcanes() {
        ArrayList<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getGameMode().equals(GameMode.SURVIVAL)) players.add(player);
        }

        ArrayList<Arcane> arcanes = new ArrayList<>();
        for (Arcane arcane : GameSettings.arcanesNumbers.keySet()) {
            for (int i = 0; i < GameSettings.arcanesNumbers.get(arcane); i++) arcanes.add(arcane);
        }
        while (arcanes.size() < players.size()) {
            if (GameSettings.getBooleanSetting(GameSettings.COMPLETE_RANDOM_ARCANE)) {
                arcanes.add(Arcane.getRandomArcane());
            }
            else arcanes.add(Arcane.SANS_ARCANE.copy());
        }

        for (Player player : players) {
            int i = (int) (Math.random() * arcanes.size());
            playerArcanes.put(player.getUniqueId(), arcanes.get(i));
            if (arcanes.get(i).equals(Arcane.SANS_ARCANE)) {
                player.sendMessage(ChatColor.GOLD + "Vous n'avez pas reçu d'Arcane!");
            }
            else {
                player.sendMessage(ChatColor.GOLD + "Vous avez reçu l'Arcane " + arcanes.get(i).toString());
            }
            arcanes.remove(i);
        }
    }
}
