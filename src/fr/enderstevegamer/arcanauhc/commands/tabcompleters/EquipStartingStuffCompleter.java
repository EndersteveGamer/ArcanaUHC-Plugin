package fr.enderstevegamer.arcanauhc.commands.tabcompleters;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class EquipStartingStuffCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> usernames = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            usernames.add(player.getName());
        }
        usernames.add("*");
        return usernames;
    }
}
