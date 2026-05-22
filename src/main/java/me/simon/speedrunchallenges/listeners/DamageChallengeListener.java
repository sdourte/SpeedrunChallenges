package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.DamageChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDamageEvent;

public class DamageChallengeListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public DamageChallengeListener(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(
            EntityDamageEvent event
    ) {

        /*
         * Vérifie joueur.
         */
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

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
                instanceof DamageChallenge challenge)) {

            return;
        }

        /*
         * Vérifie type dégâts.
         */
        if (event.getCause()
                != challenge.getTargetCause()) {

            return;
        }

        /*
         * Ajout progression dégâts.
         */
        challenge.addDamage(
                player,
                event.getFinalDamage()
        );
    }
}