package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.UUID;

public class OnPlayerLeave implements Listener {
    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage("");

        // Annonce du leave
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RED + " a quitté la partie");
            player.sendMessage(ChatColor.RED + "Il était " + ChatColor.GOLD + GameState.getPlayerArcane(event.getPlayer()));
        }

        // Détection de fin de partie
        if (GameState.getAlivePlayers().size() == 2) {
            GameState.setGameStarted(false);
            GameState.setPlayerArcane(event.getPlayer().getUniqueId(), Arcane.SANS_ARCANE);
            for (Player player : Bukkit.getOnlinePlayers()) {
                ArrayList<UUID> list = (ArrayList<UUID>) GameState.getAlivePlayers().clone();
                list.remove(event.getPlayer().getUniqueId());
                player.sendTitle(ChatColor.GOLD + "Fin de la partie!", ChatColor.GOLD + Bukkit.getPlayer(list.get(0)).getName() + " a gagné!");
                player.sendMessage(ChatColor.GOLD + Bukkit.getPlayer(list.get(0)).getName() + " a gagné avec l'arcane " + GameState.getPlayerArcane(Bukkit.getPlayer(list.get(0))));
            }
        }

        // Héritage de l'arcane
        if (!GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.SANS_ARCANE)
                && !GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.LUNE)
                && !GameState.getPlayerArcane(event.getPlayer()).equals(Arcane.SOLEIL)) {
            ArrayList<UUID> potentialPlayers = new ArrayList<>();
            for (UUID uuid : GameState.getAlivePlayers()) {
                if (GameState.getPlayerArcane(Bukkit.getPlayer(uuid)).equals(Arcane.SANS_ARCANE)) {
                    potentialPlayers.add(uuid);
                }
            }
            if (potentialPlayers.size() != 0) {
                int selectedPlayer = (int) (Math.random() * potentialPlayers.size());
                GameState.setPlayerArcane(
                        potentialPlayers.get(selectedPlayer),
                        GameState.getPlayerArcane(event.getPlayer())
                );
                Bukkit.getPlayer(potentialPlayers.get(selectedPlayer)).sendMessage(ChatColor.GREEN +
                        "Vous avez hérité de l'arcane " + ChatColor.GOLD +
                        GameState.getPlayerArcane(event.getPlayer()).toString());
            }
        }

        GameState.setPlayerArcane(event.getPlayer().getUniqueId(), Arcane.SANS_ARCANE);

        event.getPlayer().getInventory().clear();
        event.getPlayer().setGameMode(GameMode.SPECTATOR);
    }

}
