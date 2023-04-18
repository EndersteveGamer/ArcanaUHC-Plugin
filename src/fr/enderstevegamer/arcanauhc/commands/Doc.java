package fr.enderstevegamer.arcanauhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Doc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("Lien du doc: https://aloryva-uhc.gitbook.io/arcana-uhc/");
        return true;
    }
}
