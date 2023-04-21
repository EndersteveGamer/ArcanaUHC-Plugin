package fr.enderstevegamer.arcanauhc.loops;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.ActionbarUtils;
import fr.enderstevegamer.arcanauhc.utils.DisplayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DiableStrengthBuffUpdates extends BukkitRunnable {
    @Override
    public void run() {
        GameState.updateDiableBuffs();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!GameState.getPlayerArcane(player).equals(Arcane.DIABLE)) continue;
            GameState.DiableStengthBuff buff = GameState.getPlayerDiableBuff(player);
            if (buff == null) continue;
            ActionbarUtils.sendActionBarMessage(player,
                    ChatColor.GREEN + "Il vous reste " + ChatColor.GOLD +
                            DisplayUtils.millisecondsToTimeString(buff.getRemainingTime()) + ChatColor.GREEN +
                            " de Force " + ChatColor.GOLD + 40 * (buff.getLevel() + 1) + "%");
        }
    }
}
