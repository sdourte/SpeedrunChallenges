package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.challenges.MobKillChallenge;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDeathEvent;

public class MobKillListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public MobKillListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent event) {

        // Vérifie que la partie est en cours
        if (plugin.getGameManager().getGameState() != GameState.RUNNING) {
            return;
        }

        // Vérifie que le challenge actif est MobKillChallenge
        if (!(plugin.getGameManager().getActiveChallenge()
                instanceof MobKillChallenge mobChallenge)) {

            return;
        }

        // Vérifie qu'un joueur a bien tué le mob
        Player killer = event.getEntity().getKiller();

        if (killer == null) {
            return;
        }

        // Vérifie que le mob correspond à l'objectif
        if (event.getEntityType() == mobChallenge.getTargetMob()) {

            mobChallenge.win(killer);
        }
    }
}