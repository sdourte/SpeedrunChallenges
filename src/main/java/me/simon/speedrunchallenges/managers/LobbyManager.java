package me.simon.speedrunchallenges.managers;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import org.bukkit.entity.Player;

public class LobbyManager {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public LobbyManager(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    /*
     * Sauvegarde la position du lobby.
     */
    public void setLobby(Location location) {

        plugin.getConfig().set(
                "lobby.world",
                location.getWorld().getName()
        );

        plugin.getConfig().set(
                "lobby.x",
                location.getX()
        );

        plugin.getConfig().set(
                "lobby.y",
                location.getY()
        );

        plugin.getConfig().set(
                "lobby.z",
                location.getZ()
        );

        plugin.getConfig().set(
                "lobby.yaw",
                location.getYaw()
        );

        plugin.getConfig().set(
                "lobby.pitch",
                location.getPitch()
        );

        /*
         * Sauvegarde dans config.yml
         */
        plugin.saveConfig();
    }

    /*
     * Récupère la position du lobby.
     */
    public Location getLobby() {

        /*
         * Vérifie qu'un lobby existe.
         */
        if (!plugin.getConfig().contains("lobby.world")) {
            return null;
        }

        World world = Bukkit.getWorld(
                plugin.getConfig().getString("lobby.world")
        );

        double x = plugin.getConfig().getDouble("lobby.x");
        double y = plugin.getConfig().getDouble("lobby.y");
        double z = plugin.getConfig().getDouble("lobby.z");

        float yaw = (float) plugin.getConfig().getDouble("lobby.yaw");
        float pitch = (float) plugin.getConfig().getDouble("lobby.pitch");

        return new Location(
                world,
                x,
                y,
                z,
                yaw,
                pitch
        );
    }

    /*
     * Téléporte un joueur au lobby.
     */
    public void teleportToLobby(Player player) {

        Location lobby = getLobby();

        if (lobby == null) {

            player.sendMessage(
                    "§cLe lobby n'est pas défini."
            );

            return;
        }

        player.teleport(lobby);
    }

    /*
     * Supprime le lobby actuel.
     */
    public void removeLobby() {

        plugin.getConfig().set("lobby", null);

        plugin.saveConfig();
    }
}