package fr.enderstevegamer.arcanauhc.loops;

import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SetScoreboards extends BukkitRunnable {
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (GameSettings.getBooleanSetting(GameSettings.HEALTH_IN_TAB)
                    && GameSettings.getBooleanSetting(GameSettings.LIFE_UNDER_NAME)) {
                player.setScoreboard(Main.getHealthSbAll());
                Main.getHealthObjectiveAll1().getScore(player.getName()).setScore((int) player.getHealth());
                Main.getHealthObjectiveAll2().getScore(player.getName()).setScore((int) player.getHealth());
            }
            else if (GameSettings.getBooleanSetting(GameSettings.HEALTH_IN_TAB)) {
                player.setScoreboard(Main.getHealthList());
                Main.getHealthObjList().getScore(player.getName()).setScore((int) player.getHealth());
            }
            else if (GameSettings.getBooleanSetting(GameSettings.LIFE_UNDER_NAME)) {
                player.setScoreboard(Main.getHealthUnderName());
                Main.getHealthObjUnderName().getScore(player.getName()).setScore((int) player.getHealth());
            }
            else player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }
    }
}
