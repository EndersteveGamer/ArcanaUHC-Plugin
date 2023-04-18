package fr.enderstevegamer.arcanauhc.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.logging.Level;

public class AmoureuxLink {
    UUID player1;
    UUID player2;
    long linkTime;
    boolean doublePlayerLink;

    public AmoureuxLink(UUID amoureux, UUID player, boolean doublePlayerLink) {
        this.player1 = amoureux;
        this.player2 = player;
        this.linkTime = System.currentTimeMillis();
        this.doublePlayerLink = doublePlayerLink;
    }

    public boolean linkExpired() {
        return System.currentTimeMillis() - linkTime >= 60000;
    }

    public boolean areLinked(UUID player1, UUID player2) {
        return (this.player1 == player1 && this.player2 == player2)
                || (this.player2 == player1 && this.player1 == player2);
    }

    public void announceLink() {
        Player firstPlayer = Bukkit.getPlayer(this.player1);
        Player secondPlayer = Bukkit.getPlayer(this.player2);
        if (firstPlayer == null || secondPlayer == null) {
            Bukkit.getLogger().log(Level.WARNING, "Link of an Amoureux contains one entity that is not a player!");
            return;
        }
        firstPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "Vous êtes maintenant lié à " +
                ChatColor.GOLD + secondPlayer.getName() + '\n' + ChatColor.LIGHT_PURPLE + "Vous ne pouvez pas vous attaquer!");
        secondPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "Vous êtes maintenant lié à " +
                ChatColor.GOLD + firstPlayer.getName() + '\n' + ChatColor.LIGHT_PURPLE + "Vous ne pouvez pas vous attaquer!");
    }

    public void announceEndOfLink() {
        if (!doublePlayerLink) return;
        Player firstPlayer = Bukkit.getPlayer(this.player1);
        Player secondPlayer = Bukkit.getPlayer(this.player2);
        if (firstPlayer == null || secondPlayer == null) return;
        firstPlayer.sendMessage(ChatColor.GREEN + "Votre lien avec " + ChatColor.GOLD + secondPlayer.getName() +
                ChatColor.GREEN + " s'est brisé!");
        secondPlayer.sendMessage(ChatColor.GREEN + "Votre lien avec " + ChatColor.GOLD + firstPlayer.getName() +
                ChatColor.GREEN + " s'est brisé!");
    }
}
