package fr.enderstevegamer.arcanauhc.arcanes;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameState;
import fr.enderstevegamer.arcanauhc.utils.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class Monde {
    public static void giveEffects(Player player) {
        if (!GameState.getPlayerArcane(player).equals(Arcane.MONDE)) return;
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.WEAKNESS, 1, 3, false, false
        ));
    }

    private static void viewPlayer(Player viewer, Player viewed) {
        viewer.sendMessage(ChatColor.GREEN + "Votre lien avec le monde vous permet de voir le joueur " +
                ChatColor.GOLD + viewed.getName());
        if (GameState.getPlayerArcane(viewed).equals(Arcane.SANS_ARCANE)) {
            viewer.sendMessage(ChatColor.GREEN + "Ce joueur ne possède pas d'arcane");
        }
        else {
            viewer.sendMessage(ChatColor.GREEN + "Ce joueur possède l'arcane " + ChatColor.GOLD +
                    GameState.getPlayerArcane(viewed));
        }
        if (PlayerInfo.getItemNumber(viewed, Material.GOLDEN_APPLE) == 0) {
            viewer.sendMessage(ChatColor.GREEN + "Ce joueur ne possède pas de pommes dorées");
        }
        else {
            viewer.sendMessage(ChatColor.GREEN + "Ce joueur possède " + ChatColor.GOLD +
                    PlayerInfo.getItemNumber(viewed, Material.GOLDEN_APPLE) + ChatColor.GREEN + " Pommes Dorées");
        }
        viewer.sendMessage(ChatColor.GREEN + "La vie de ce joueur est de " + ChatColor.GOLD + viewed.getHealth() +
                ChatColor.GREEN + " points de vie");
        viewed.sendMessage(ChatColor.RED + "Vous avez été vu par le monde, et vous êtes affaibli");
        viewed.addPotionEffect(new PotionEffect(
                PotionEffectType.WEAKNESS, 5 * 60 * 20, 0, false, false
        ));
    }

    private static Player getRandomPlayer() {
        int number = (int) (Math.random() * GameState.getAlivePlayers().size());
        return Bukkit.getPlayer(GameState.getAlivePlayers().get(number));
    }

    public static void giveInformation() {
        if (!GameState.mondeCooldownFinished()) return;
        GameState.resetMondeCooldown();
        for (UUID uuid : GameState.getAlivePlayers()) {
            Player player = Bukkit.getPlayer(uuid);
            if (!GameState.getPlayerArcane(player).equals(Arcane.MONDE)) continue;
            viewPlayer(player, getRandomPlayer());
        }
    }
}
