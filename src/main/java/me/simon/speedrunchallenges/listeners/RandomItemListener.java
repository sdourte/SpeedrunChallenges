package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.RandomItemChallenge;

import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityPickupItemEvent;

import org.bukkit.event.inventory.InventoryClickEvent;

public class RandomItemListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public RandomItemListener(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    /*
     * Pickup item.
     */
    @EventHandler
    public void onPickup(
            EntityPickupItemEvent event
    ) {

        /*
         * Vérifie joueur.
         */
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        checkWin(player);
    }

    /*
     * Déplacement inventaire.
     */
    @EventHandler
    public void onInventoryClick(
            InventoryClickEvent event
    ) {

        if (!(event.getWhoClicked()
                instanceof Player player)) {

            return;
        }

        /*
         * Delay d'1 tick :
         * l'item doit être
         * réellement déplacé.
         */
        Bukkit.getScheduler().runTaskLater(
                plugin,
                () -> checkWin(player),
                1L
        );
    }

    /*
     * Vérifie victoire.
     */
    private void checkWin(Player player) {

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
                instanceof RandomItemChallenge challenge)) {

            return;
        }

        /*
         * Vérifie possession item.
         */
        if (player.getInventory().contains(
                challenge.getTargetItem()
        )) {

            challenge.win(player);
        }
    }
}