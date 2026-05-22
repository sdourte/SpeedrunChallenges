package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.AnyMobChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDeathEvent;

public class AnyMobListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public AnyMobListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onKill(EntityDeathEvent event) {

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
                instanceof AnyMobChallenge challenge)) {

            return;
        }

        /*
         * Vérifie qu'un joueur a tué le mob.
         */
        Player killer = event.getEntity().getKiller();

        if (killer == null) {
            return;
        }

        /*
         * Envoie le kill au challenge.
         */
        challenge.handleKill(
                killer,
                event.getEntityType()
        );
    }
}