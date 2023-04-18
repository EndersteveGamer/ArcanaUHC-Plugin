package fr.enderstevegamer.arcanauhc.loops;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class GameStateUpdater extends BukkitRunnable {
    @Override
    public void run() {
        if (GameState.getGameTime() >=
                GameSettings.getIntegerSetting(GameSettings.TIME_BEFORE_PVP) * 60000L
                && GameState.isPvpDisabled()
                && GameState.gameStarted()) {
            GameState.enablePvp();
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.GOLD + "Le PVP est maintenant activé!");
            }
        }
        if (GameState.getGameTime() >=
                GameSettings.getIntegerSetting(GameSettings.FINAL_HEAL) * 60000L
                && GameSettings.getIntegerSetting(GameSettings.FINAL_HEAL) != 0
                && !GameState.isFinalHealGiven()
                && GameState.gameStarted()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.setHealth(player.getMaxHealth());
                player.setFoodLevel(20);
                player.setSaturation(20);
                player.sendMessage(ChatColor.GOLD + "Le heal final a été appliqué!");
                GameState.setFinalHealGiven(true);
            }
        }
        if (GameState.getGameTime() >=
                GameSettings.getIntegerSetting(GameSettings.BORDER_WAIT_TIME) * 60000L
                && GameState.gameStarted()
                && !GameState.wasBorderReduced()) {
            Bukkit.getWorld("world2").getWorldBorder().setSize(
                    GameSettings.getIntegerSetting(GameSettings.FINAL_BORDER_SIZE),
                    GameSettings.getIntegerSetting(GameSettings.BORDER_REDUCTION_TIME) * 60L
            );
            GameState.setBorderReduced(true);
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.GOLD + "La bordure du monde commence à se réduire!");
            }
        }
        if (GameState.getGameTime() >= 60000 && !GameState.wereArcanesGiven() && GameState.gameStarted()) {
            GameState.distributeArcanes();
            GameState.setArcanesGiven(true);
        }
        if (GameState.gameStarted() && (GameState.getInfiniteTime() == 1 || GameState.getInfiniteTime() == -1)) {
            Bukkit.getWorld("world2").setTime((GameState.getInfiniteTime() == 1) ? 6000 : 18000);
        }
        if (GameState.gameStarted() && GameState.papeCooldownFinished()) {
            for (UUID uuid: GameState.getAlivePlayers()) {
                Player player = Bukkit.getPlayer(uuid);
                if (GameState.getPlayerArcane(player).equals(Arcane.PAPE)) giveRandomGapple();
            }
            GameState.resetPapeCooldown();
        }
        if (GameState.gameStarted()) {
            GameState.updateHermites();
            GameState.updateRoueDeLaFortune();
            GameState.updateAmoureuxLinks();
        }
    }

    public static void giveRandomGapple() {
        Player player = Bukkit.getPlayer(
                GameState.getAlivePlayers().get(
                        (int)(Math.random() * GameState.getAlivePlayers().size())
                )
        );
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
        player.sendMessage(ChatColor.GOLD + Arcane.PAPE.toString() + ChatColor.GREEN + " vous a donné une pomme dorée!");
    }
}
