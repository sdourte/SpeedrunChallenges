package me.simon.speedrunchallenges.commands;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RemoveLobbyCommand implements CommandExecutor {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public RemoveLobbyCommand(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        /*
         * Supprime le lobby.
         */
        plugin.getLobbyManager().removeLobby();

        sender.sendMessage(
                "§aLe lobby a été supprimé."
        );

        return true;
    }
}