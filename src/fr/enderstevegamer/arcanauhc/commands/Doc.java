package fr.enderstevegamer.arcanauhc.commands;

import fr.enderstevegamer.arcanauhc.Arcane;
import fr.enderstevegamer.arcanauhc.GameSettings;
import fr.enderstevegamer.arcanauhc.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Doc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command command, String string, String[] strings) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;
        if (strings.length == 0) {
            s.sendMessage("Lien du doc: https://aloryva-uhc.gitbook.io/arcana-uhc/");
            return true;
        }
        String arcane = strings[0];
        switch (arcane) {
            case "bateleur":
                displayDoc(Arcane.BATELEUR, s);
                break;
            case "papesse":
                displayDoc(Arcane.PAPESSE, s);
                break;
            case "imperatrice":
                displayDoc(Arcane.IMPERATRICE, s);
                break;
            case "empereur":
                displayDoc(Arcane.EMPEREUR, s);
                break;
            case "pape":
                displayDoc(Arcane.PAPE, s);
                break;
            case "amoureux":
                displayDoc(Arcane.AMOUREUX, s);
                break;
            case "chariot":
                displayDoc(Arcane.CHARIOT, s);
                break;
            case "justice":
                displayDoc(Arcane.JUSTICE, s);
                break;
            case "hermite":
                displayDoc(Arcane.HERMITE, s);
                break;
            case "roue_de_la_fortune":
                displayDoc(Arcane.ROUE_DE_LA_FORTUNE, s);
                break;
            case "force":
                displayDoc(Arcane.FORCE, s);
                break;
            case "pendu":
                displayDoc(Arcane.PENDU, s);
                break;
            case "sans_nom":
                displayDoc(Arcane.SANS_NOM, s);
                break;
            case "temperance":
                displayDoc(Arcane.TEMPERANCE, s);
                break;
            case "diable":
                displayDoc(Arcane.DIABLE, s);
                break;
            case "maison_dieu":
                displayDoc(Arcane.MAISON_DIEU, s);
                break;
            case "etoile":
                displayDoc(Arcane.ETOILE, s);
                break;
            case "lune":
                displayDoc(Arcane.LUNE, s);
                break;
            case "soleil":
                displayDoc(Arcane.SOLEIL, s);
                break;
            case "jugement":
                displayDoc(Arcane.JUGEMENT, s);
                break;
            case "monde":
                displayDoc(Arcane.MONDE, s);
                break;
            case "mat":
                displayDoc(Arcane.MAT, s);
                break;
            case "sans_arcane":
                displayDoc(Arcane.SANS_ARCANE, s);
                break;
            case "self":
                displayDoc(GameState.getPlayerArcane(p), s);
                break;
        }
        return true;
    }

    public static void displayDoc(Arcane arcane, CommandSender sender) {
        for (String string : arcane.getDocumentation()) {
            sender.sendMessage(string);
        }
    }
}
