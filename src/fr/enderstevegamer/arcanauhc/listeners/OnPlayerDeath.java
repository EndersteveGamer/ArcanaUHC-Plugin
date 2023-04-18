package fr.enderstevegamer.arcanauhc.listeners;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.arcanes.Empereur;
import fr.enderstevegamer.arcanauhc.arcanes.Justice;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class OnPlayerDeath implements Listener {
    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage("");
        Empereur.onKill(event);
        Justice.onKill(event);
        if (event.getEntity().getKiller() != null && GameSettings.getBooleanSetting(GameSettings.GOLDEN_APPLE_ON_KILL)) {
            event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
        }
        if (event.getEntity().getKiller() == null) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.GOLD + event.getEntity().getName() + ChatColor.RED + " est mort!");
            }
        }
        else {
            GameState.addNewMurderer(event.getEntity().getKiller());
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!GameState.getPlayerArcane(player).equals(Arcane.JUSTICE) && !player.getGameMode().equals(GameMode.SPECTATOR)) {
                    player.sendMessage(ChatColor.GOLD + event.getEntity().getName() + ChatColor.RED + " est mort!");
                }
                else {
                    player.sendMessage(ChatColor.GOLD + event.getEntity().getName() + ChatColor.RED +
                            " a été tué par " + ChatColor.GOLD + event.getEntity().getKiller().getName());
                }
            }
        }

        if (event.getEntity().getKiller() == null || !GameState.getPlayerArcane(event.getEntity().getKiller()).equals(Arcane.SANS_ARCANE)) {
            if (!GameState.getPlayerArcane(event.getEntity()).equals(Arcane.SANS_ARCANE)
                    && !GameState.getPlayerArcane(event.getEntity()).equals(Arcane.LUNE)
                    && !GameState.getPlayerArcane(event.getEntity()).equals(Arcane.SOLEIL)) {
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
                            GameState.getPlayerArcane(event.getEntity())
                    );
                    Bukkit.getPlayer(potentialPlayers.get(selectedPlayer)).sendMessage(ChatColor.GREEN +
                            "Vous avez hérité de l'arcane " + ChatColor.GOLD +
                            GameState.getPlayerArcane(event.getEntity()).toString());
                }
            }
        }
        else {
            if (!GameState.getPlayerArcane(event.getEntity()).equals(Arcane.SANS_ARCANE)) {
                GameState.setPlayerArcane(event.getEntity().getKiller().getUniqueId(),
                        GameState.getPlayerArcane(event.getEntity()));
                event.getEntity().getKiller().sendMessage(ChatColor.GREEN + "Vous avez hérité de l'arcane " +
                        ChatColor.GOLD + GameState.getPlayerArcane(event.getEntity()).toString());
            }
        }

        if (GameState.getPlayerArcane(event.getEntity()).equals(Arcane.LUNE)) GameState.setInfiniteTime(-1);
        else if (GameState.getPlayerArcane(event.getEntity()).equals(Arcane.SOLEIL)) GameState.setInfiniteTime(1);

        GameState.setPlayerArcane(event.getEntity().getUniqueId(), Arcane.SANS_ARCANE);

        event.getEntity().setGameMode(GameMode.SPECTATOR);
        Location location = event.getEntity().getLocation();
        event.getEntity().spigot().respawn();
        event.getEntity().teleport(location);
        event.getEntity().sendTitle(ChatColor.RED + "Vous êtes mort!", "");
    }
}
