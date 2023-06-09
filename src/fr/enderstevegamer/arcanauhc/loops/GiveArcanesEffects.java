package fr.enderstevegamer.arcanauhc.loops;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.arcanes.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class GiveArcanesEffects extends BukkitRunnable {
    @Override
    public void run() {
        for (UUID uuid : GameState.getAlivePlayers()) {
            Player player = Bukkit.getPlayer(uuid);
            Bateleur.giveEffects(player);
            Papesse.giveEffects(player);
            Imperatrice.giveEffects(player);
            Pape.giveEffects(player);
            Chariot.giveEffects(player);
            Hermite.giveEffects(player);
            RoueDeLaFortune.giveEffects(player);
            Pendu.giveEffects(player);
            Temperance.giveEffects(player);
            MaisonDieu.giveEffects(player);
            Monde.giveEffects(player);
            Mat.giveEffects(player);
            Jugement.giveEffects(player);


            Arcane arcane = GameState.getPlayerArcane(player);
            if (arcane.equals(Arcane.EMPEREUR)) player.setMaxHealth(18);
            else if (arcane.equals(Arcane.HERMITE)) player.setMaxHealth(24);
            else if (arcane.equals(Arcane.FORCE)) player.setMaxHealth(18);
            else if (arcane.equals(Arcane.MONDE)) player.setMaxHealth(26);
            else if (arcane.equals(Arcane.MAT)) player.setMaxHealth(18);
            else player.setMaxHealth(20);
        }
    }
}
