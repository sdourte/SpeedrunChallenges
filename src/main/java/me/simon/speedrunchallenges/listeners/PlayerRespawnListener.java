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

        /*
         * Laisse Minecraft gérer
         * si lit ou anchor.
         */
        if (event.isBedSpawn()

                ||

                event.isAnchorSpawn()) {

            return;
        }

        Player player = event.getPlayer();

        /*
         * Spawnpoint perso challenge.
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
         * Fallback spawn challenge.
         */
        event.setRespawnLocation(
                respawnLocation
        );
    }
}