package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Location;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener
        implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public PlayerRespawnListener(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(
            PlayerRespawnEvent event
    ) {

        Player player = event.getPlayer();

        /*
         * Spawnpoint perso.
         */
        Location respawnLocation =
                plugin.getGameManager()
                        .getPlayerSpawn(player);

        /*
         * Vérifie spawnpoint.
         */
        if (respawnLocation == null) {
            return;
        }

        /*
         * Force respawn custom.
         */
        event.setRespawnLocation(
                respawnLocation
        );
    }
}