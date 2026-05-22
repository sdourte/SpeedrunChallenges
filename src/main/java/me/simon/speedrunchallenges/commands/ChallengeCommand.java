package me.simon.speedrunchallenges.commands;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.gui.ChallengeMenu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

public class ChallengeCommand implements CommandExecutor {

    // Référence vers le plugin principal
    private final SpeedrunChallenges plugin;

    // Constructeur
    public ChallengeCommand(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        /*
         * Vérifie que la commande
         * est exécutée par un joueur.
         *
         * La console ne peut pas ouvrir de GUI.
         */
        if (!(sender instanceof Player player)) {

            sender.sendMessage(
                    "§cCette commande est réservée aux joueurs."
            );

            return true;
        }

        /*
         * Ouvre le menu des challenges.
         */
        new ChallengeMenu(plugin).open(player);

        return true;
    }
}