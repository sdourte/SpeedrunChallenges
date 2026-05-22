package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.BlockHuntChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockBreakEvent;

public class BlockHuntListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public BlockHuntListener(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        /*
         * Vérifie partie active.
         */
        if (plugin.getGameManager().getGameState()
                != GameState.RUNNING) {

            return;
        }

        /*
         * Vérifie challenge actif.
         */
        if (!(plugin.getGameManager()
                .getActiveChallenge()
                instanceof BlockHuntChallenge challenge)) {

            return;
        }

        Player player = event.getPlayer();

        /*
         * Vérifie bloc cible.
         */
        if (event.getBlock().getType()
                == challenge.getTargetBlock()) {

            challenge.win(player);
        }
    }
}