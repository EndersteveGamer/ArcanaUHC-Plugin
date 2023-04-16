package fr.enderstevegamer.arcanauhc.commands;

import fr.enderstevegamer.arcanauhc.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EquipStartingStuff implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) return false;
        if (commandSender.isOp()) {
            if (strings[0].equals("*")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    PlayerUtils.equipStartingStuff(player);
                }
                commandSender.sendMessage(ChatColor.GREEN + "Tous les joueurs ont été équipés avec un stuff de départ");
                return true;
            }
            String playerName = strings[0];
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getName().equals(playerName)) {
                    PlayerUtils.equipStartingStuff(player);
                    commandSender.sendMessage(ChatColor.GREEN + "Stuff de départ équippé pour " + playerName);
                    return true;
                }
            }
            commandSender.sendMessage(ChatColor.RED + "Aucun joueur avec ce pseudo n'est connecté");
            return true;
        }
        commandSender.sendMessage(ChatColor.RED + "Vous devez être opérateur pour pouvoir utiliser cette commande");
        return true;
    }
}
