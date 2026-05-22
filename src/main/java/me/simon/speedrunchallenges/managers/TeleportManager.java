package me.simon.speedrunchallenges.managers;

import me.simon.speedrunchallenges.SpeedrunChallenges;

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

        World world = player.getWorld();

        /*
         * Rayon maximal de téléportation.
         */
        int radius = 3000;

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

        /*
         * Définit le spawnpoint personnel
         * du joueur.
         *
         * Ainsi :
         * - en cas de mort il respawn ici.
         */
        player.setRespawnLocation(location, true);

        player.sendMessage(
                "§aTéléportation aléatoire..."
        );
    }
}