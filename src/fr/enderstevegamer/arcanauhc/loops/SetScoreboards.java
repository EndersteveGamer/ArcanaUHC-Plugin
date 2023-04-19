package fr.enderstevegamer.arcanauhc.loops;

import fr.enderstevegamer.arcanauhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SetScoreboards extends BukkitRunnable {
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(Main.getScoreboard());
        }
    }
}
