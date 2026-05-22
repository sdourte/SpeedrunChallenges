package me.simon.speedrunchallenges.commands;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.game.GameState;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;

import java.util.Comparator;

public class ResetWorldCommand
        implements CommandExecutor {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public ResetWorldCommand(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {

        /*
         * Mondes à reset.
         */
        String[] worlds = {

                "world",
                "world_nether",
                "world_the_end"
        };

        /*
         * Vérifie lobby.
         */
        if (plugin.getLobbyManager()
                .getLobby() == null) {

            sender.sendMessage(
                    "§cLe lobby n'est pas défini."
            );

            return true;
        }

        /*
         * Stop le challenge actuel s'il y en a un
         */
        if (plugin.getGameManager().getGameState() == GameState.RUNNING) {
            plugin.getGameManager().stopGame();
        }

        /*
         * Téléporte tous les joueurs
         * vers le lobby.
         */
        for (Player player
                : Bukkit.getOnlinePlayers()) {

            plugin.getLobbyManager()
                    .teleportToLobby(player);
        }

        /*
         * Petit délai pour laisser
         * les téléportations se terminer.
         */
        Bukkit.getScheduler().runTaskLater(
                plugin,
                () -> {

                    /*
                     * Unload des mondes.
                     */
                    for (String worldName
                            : worlds) {

                        World world =
                                Bukkit.getWorld(worldName);

                        if (world != null) {

                            Bukkit.unloadWorld(
                                    world,
                                    false
                            );
                        }
                    }

                    /*
                     * Suppression des dossiers.
                     */
                    for (String worldName
                            : worlds) {

                        File worldFolder =
                                new File(
                                        Bukkit.getWorldContainer(),
                                        worldName
                                );

                        /*
                         * Ignore si inexistant.
                         */
                        if (!worldFolder.exists()) {
                            continue;
                        }

                        try {

                            Files.walk(
                                            worldFolder.toPath()
                                    )
                                    .sorted(
                                            Comparator.reverseOrder()
                                    )
                                    .map(
                                            java.nio.file.Path::toFile
                                    )
                                    .forEach(File::delete);

                        } catch (IOException e) {

                            sender.sendMessage(
                                    "§cErreur suppression : "
                                            + worldName
                            );

                            e.printStackTrace();

                            return;
                        }
                    }

                    /*
                     * Attend avant recréation
                     * pour laisser le filesystem
                     * finir la suppression.
                     */
                    Bukkit.getScheduler().runTaskLater(
                            plugin,
                            () -> {

                                /*
                                 * Recréation monde principal.
                                 */
                                WorldCreator creator =
                                        new WorldCreator("world");

                                Bukkit.createWorld(creator);

                                Bukkit.broadcastMessage(
                                        "§aLe monde (normal, nether et end) a été régénéré !"
                                );
                                // Prévenir qu'il faut restart le serveur
                                Bukkit.broadcastMessage(
                                        "§cIl faut maintenant relancer le serveur pour avoir le monde reset"
                                );

                            },
                            60L
                    );
                },
                40L
        );

        return true;
    }
}