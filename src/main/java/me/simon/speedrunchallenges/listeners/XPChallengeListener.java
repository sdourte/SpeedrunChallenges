package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.XPChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerExpChangeEvent;

public class XPChallengeListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public XPChallengeListener(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onExpGain(
            PlayerExpChangeEvent event
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
                instanceof XPChallenge challenge)) {

            return;
        }

        Player player = event.getPlayer();

        /*
         * Delay 1 tick :
         * le niveau doit être
         * réellement mis à jour.
         */
        plugin.getServer().getScheduler()
                .runTaskLater(
                        plugin,
                        () -> {

                            if (player.getLevel()
                                    >= challenge.getTargetLevel()) {

                                challenge.win(player);
                            }

                        },
                        1L
                );
    }
}