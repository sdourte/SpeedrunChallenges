package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {

    // Référence vers le plugin
    private final SpeedrunChallenges plugin;

    public MoveListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    /*
     * Vérifie si le jeu est
     * en phase STARTING.
     */
    private boolean isFrozen() {

        return plugin.getGameManager().getGameState()
                == GameState.STARTING;
    }

    /*
     * Freeze des déplacements.
     */
    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        /*
         * Freeze uniquement
         * pendant le countdown.
         */
        if (!isFrozen()) {
            return;
        }

        /*
         * Vérifie si le joueur
         * change réellement de bloc.
         */
        if (event.getFrom().getBlockX()
                != event.getTo().getBlockX()

                ||

                event.getFrom().getBlockY()
                        != event.getTo().getBlockY()

                ||

                event.getFrom().getBlockZ()
                        != event.getTo().getBlockZ()) {

            // Annule le déplacement
            event.setCancelled(true);
        }
    }

    /*
     * Empêche de casser des blocs.
     */
    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        if (isFrozen()) {

            event.setCancelled(true);
        }
    }

    /*
     * Empêche de poser des blocs.
     */
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {

        if (isFrozen()) {

            event.setCancelled(true);
        }
    }

    /*
     * Empêche les interactions.
     */
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if (isFrozen()) {

            event.setCancelled(true);
        }
    }

    /*
     * Empêche les coups.
     */
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {

        if (isFrozen()) {

            event.setCancelled(true);
        }
    }
}