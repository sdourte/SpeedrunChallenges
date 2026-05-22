package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.AdvancementChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class AdvancementListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public AdvancementListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAdvancement(PlayerAdvancementDoneEvent event) {

        /*
         * Vérifie qu'une partie est active.
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
                instanceof AdvancementChallenge challenge)) {

            return;
        }

        /*
         * Vérifie advancement cible.
         */
        if (event.getAdvancement()
                .equals(challenge.getTargetAdvancement())) {

            challenge.win(event.getPlayer());
        }
    }
}