package fr.enderstevegamer.arcanauhc.commands;

import fr.enderstevegamer.arcanauhc.GameSettings;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetGameName implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.isOp()) {
            commandSender.sendMessage(ChatColor.RED + "Vous devez être opérateur pour pouvoir faire ceci!");
            return true;
        }
        if (strings.length == 0) return false;
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            string.append(strings[i]);
            if (i != strings.length - 1) string.append(" ");
        }
        GameSettings.gameName = string.toString();
        commandSender.sendMessage(ChatColor.GREEN + "Le nom de la partie a été défini à " + string);
        return true;
    }
}
