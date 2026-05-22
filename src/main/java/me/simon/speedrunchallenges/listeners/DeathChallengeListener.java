package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.DeathChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathChallengeListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public DeathChallengeListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

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
                instanceof DeathChallenge challenge)) {

            return;
        }

        Player player = event.getEntity();

        /*
         * Vérifie cause de mort.
         */
        if (player.getLastDamageCause() == null) {
            return;
        }

        if (player.getLastDamageCause().getCause()
                == challenge.getTargetDeath()) {

            challenge.win(player);
        }
    }
}