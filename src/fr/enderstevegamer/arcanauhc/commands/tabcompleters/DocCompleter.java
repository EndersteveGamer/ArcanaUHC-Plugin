package fr.enderstevegamer.arcanauhc.commands.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class DocCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return Arrays.asList(
                "self",
                "bateleur",
                "papesse",
                "imperatrice",
                "empereur",
                "pape",
                "amoureux",
                "chariot",
                "justice",
                "hermite",
                "roue_de_la_fortune",
                "force",
                "pendu",
                "sans_nom",
                "temperance",
                "diable",
                "maison_dieu",
                "etoile",
                "lune",
                "soleil",
                "jugement",
                "monde",
                "mat",
                "sans_arcane"
        );
    }
}
