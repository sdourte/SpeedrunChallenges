package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.DeathSwapChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.Bukkit;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathSwapListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public DeathSwapListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        /*
         * Vérifie game actif.
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
                instanceof DeathSwapChallenge challenge)) {

            return;
        }

        Player deadPlayer = event.getEntity();

        /*
         * Trouve le gagnant.
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            if (!player.equals(deadPlayer)) {

                challenge.win(player);

                break;
            }
        }
    }
}