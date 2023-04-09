package fr.enderstevegamer.arcanauhc.commands;

import fr.enderstevegamer.arcanauhc.GameSettingsMenu.MainSettingsMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Config implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (!player.isOp()) {
            player.sendMessage(ChatColor.RED + "Vous n'êtes pas opérateur!");
            return true;
        }
        player.openInventory(MainSettingsMenu.getMenu());
        return true;
    }
}
