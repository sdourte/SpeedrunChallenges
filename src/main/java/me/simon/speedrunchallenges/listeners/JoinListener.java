package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.game.GameState;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    // Référence vers le plugin
    private final SpeedrunChallenges plugin;

    // Constructeur
    public JoinListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        // Annonce qui rejoint le serveur
        Bukkit.broadcastMessage(
                event.getPlayer().getName() + " a rejoint la partie !"
        );

        /*
         * Téléporte le joueur au lobby
         */
        // On vérifie que la partie n'est pas en cours
        if (plugin.getGameManager().getGameState() != GameState.RUNNING) {
            plugin.getLobbyManager()
                    .teleportToLobby(event.getPlayer());
        }
    }
}