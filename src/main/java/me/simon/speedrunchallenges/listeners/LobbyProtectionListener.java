package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class LobbyProtectionListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public LobbyProtectionListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    /*
     * Empêche de casser des blocs
     * dans le lobby.
     */
    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        /*
         * Désactive la protection
         * si aucun lobby n'est défini.
         */
        if (plugin.getLobbyManager().getLobby() == null) {
            return;
        }

        if (plugin.getGameManager().getGameState()
                == GameState.WAITING) {

            event.setCancelled(true);
        }
    }

    /*
     * Empêche de poser des blocs
     * dans le lobby.
     */
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {

        /*
         * Désactive la protection
         * si aucun lobby n'est défini.
         */
        if (plugin.getLobbyManager().getLobby() == null) {
            return;
        }

        if (plugin.getGameManager().getGameState()
                == GameState.WAITING) {

            event.setCancelled(true);
        }
    }
}