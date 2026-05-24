package me.simon.speedrunchallenges.managers;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import org.bukkit.entity.Player;

import java.util.Random;

public class TeleportManager {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Générateur aléatoire
    private final Random random;

    public TeleportManager(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    /*
     * Téléporte un joueur
     * à une position aléatoire.
     */
    public void teleportRandom(Player player) {

        // On récupère le monde normal >< world_lobby
        World world = Bukkit.getWorld("world");
        // Sécurité
        if (world == null) {

            Bukkit.broadcastMessage(
                    "§cLe monde principal est introuvable."
            );

            return;
        }

        /*
         * Rayon maximal de téléportation.
         */
        int radius = 5000;

        /*
         * Coordonnées aléatoires.
         */
        int x = random.nextInt(radius * 2) - radius;

        int z = random.nextInt(radius * 2) - radius;

        /*
         * Trouve le sol le plus haut.
         */
        int y = world.getHighestBlockYAt(x, z);

        /*
         * Création de la position.
         */
        Location location = new Location(
                world,
                x + 0.5,
                y + 1,
                z + 0.5
        );

        /*
         * Précharge le chunk
         * avant téléportation pour qu'il soit chargé
         */
        location.getChunk().load();

        /*
         * Téléportation du joueur.
         */
        player.teleport(location);

        player.sendMessage(
                "§aTéléportation aléatoire..."
        );

        /*
         * Attend quelques ticks
         * avant de définir
         * le spawnpoint.
         */
        Bukkit.getScheduler().runTaskLater(
                plugin,
                () -> {

                    /*
                     * Reset anciens lits / anchors.
                     * -> évite d'avoir un spawnpoint d'une partie précédente
                     */
                    player.setRespawnLocation(
                            null,
                            true
                    );

                    /*
                     * Définit le spawnpoint personnel
                     * du joueur.
                     */
                    plugin.getGameManager()
                            .setPlayerSpawn(
                                    player,
                                    location
                            );
                    player.sendMessage(
                            "§aSpawnpoint redéfini !"
                    );

                },
                100L // 5 seconde
        );
    }
}