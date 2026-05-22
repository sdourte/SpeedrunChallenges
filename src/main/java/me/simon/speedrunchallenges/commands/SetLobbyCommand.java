package me.simon.speedrunchallenges.commands;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

public class SetLobbyCommand implements CommandExecutor {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public SetLobbyCommand(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        /*
         * Vérifie que le sender est un joueur.
         */
        if (!(sender instanceof Player player)) {

            sender.sendMessage(
                    "§cCommande réservée aux joueurs."
            );

            return true;
        }

        /*
         * Sauvegarde le lobby.
         */
        plugin.getLobbyManager()
                .setLobby(player.getLocation());

        player.sendMessage(
                "§aLobby défini avec succès !"
        );

        return true;
    }
}