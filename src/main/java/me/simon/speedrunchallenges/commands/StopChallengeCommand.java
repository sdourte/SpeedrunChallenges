package me.simon.speedrunchallenges.commands;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.game.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopChallengeCommand implements CommandExecutor {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public StopChallengeCommand(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        /*
         * Vérifie qu'une partie existe.
         */
        if (plugin.getGameManager().getGameState() == GameState.WAITING) {

            sender.sendMessage(
                    "§cAucune partie en cours."
            );

            return true;
        }

        /*
         * Stop la partie.
         */
        plugin.getGameManager().stopGame();

        return true;
    }
}