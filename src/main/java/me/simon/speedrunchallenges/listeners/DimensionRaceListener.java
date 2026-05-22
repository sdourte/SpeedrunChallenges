package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.DimensionRaceChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerChangedWorldEvent;

public class DimensionRaceListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public DimensionRaceListener(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onDimensionChange(
            PlayerChangedWorldEvent event
    ) {

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
                instanceof DimensionRaceChallenge challenge)) {

            return;
        }

        Player player = event.getPlayer();

        /*
         * Vérifie dimension cible.
         */
        if (player.getWorld().getEnvironment()
                == challenge.getTargetDimension()) {

            challenge.win(player);
        }
    }
}