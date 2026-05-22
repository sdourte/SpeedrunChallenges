package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.challenges.DiamondChallenge;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class DiamondListener implements Listener {

    // Référence vers le plugin principal
    private final SpeedrunChallenges plugin;

    // Constructeur
    public DiamondListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    /*
     * Event déclenché lorsqu'un joueur ramasse un item.
     */
    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {

        // Vérifie que la partie est en cours
        if (plugin.getGameManager().getGameState() != GameState.RUNNING) {
            return;
        }

        /*
         * Vérifie challenge actif.
         */
        if (!(plugin.getGameManager()
                .getActiveChallenge()
                instanceof DiamondChallenge challenge)) {

            return;
        }

        // Vérifie que l'item ramassé est un diamant
        if (event.getItem().getItemStack().getType() == Material.DIAMOND) {

            Player player = event.getPlayer();

            plugin.getGameManager()
                    .getActiveChallenge()
                    .win(player);
        }
    }
}