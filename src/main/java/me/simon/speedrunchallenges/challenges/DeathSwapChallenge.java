package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Random;

public class DeathSwapChallenge
        implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Random
    private final Random random;

    // Timer actuel
    private int swapTimer;

    // Task swap
    private BukkitRunnable swapTask;

    /*
     * Joueur -> propriétaire
     * de la position.
     */
    private final Map<Player, Player>
            swapOwners;

    public DeathSwapChallenge(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;

        this.random = new Random();

        this.swapOwners =
                new HashMap<>();
    }

    @Override
    public String getName() {

        return "Death Swap";
    }

    @Override
    public String getObjective() {

        return "Faites mourir un joueur";
    }

    @Override
    public void setupBossBar(
            BossBar bossBar
    ) {

        bossBar.setTitle(
                "§cFaites mourir un joueur"
        );

        bossBar.setProgress(1.0);
    }

    @Override
    public void start() {

        Bukkit.broadcastMessage(
                "§cDeath Swap commencé !"
        );

        /*
         * Premier swap :
         * 10 minutes.
         */
        scheduleNextSwap(10);
    }

    @Override
    public void stop() {

        /*
         * Stop task swap.
         */
        if (swapTask != null) {

            swapTask.cancel();
        }

        /*
         * Reset swaps.
         */
        swapOwners.clear();

        Bukkit.broadcastMessage(
                "§cDeath Swap terminé."
        );
    }

    @Override
    public void win(
            Player player
    ) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le Death Swap !"
        );

        plugin.getGameManager()
                .endGame(player);

        stop();
    }

    /*
     * Planifie prochain swap.
     */
    private void scheduleNextSwap(
            int minutes
    ) {

        swapTimer = minutes * 60;

        /*
         * Affichage lisible.
         */
        String timeMessage;

        /*
         * Minutes.
         */
        if (swapTimer >= 60) {

            int remainingMinutes =
                    swapTimer / 60;

            timeMessage =
                    remainingMinutes
                            + " minute"
                            + (remainingMinutes > 1 ? "s" : "");
        }

        /*
         * Secondes.
         */
        else {

            timeMessage =
                    swapTimer
                            + " seconde"
                            + (swapTimer > 1 ? "s" : "");
        }

        Bukkit.broadcastMessage(
                "§eSwap dans "
                        + timeMessage
                        + " !"
        );

        swapTask =
                new BukkitRunnable() {

                    @Override
                    public void run() {

                        /*
                         * Vérifie challenge actif.
                         */
                        if (!(plugin.getGameManager()
                                .getActiveChallenge()
                                instanceof DeathSwapChallenge)) {

                            cancel();
                            return;
                        }

                        // Réduction timer
                        swapTimer--;

                        /*
                         * Affichage timer.
                         */
                        if (swapTimer <= 10
                                || swapTimer % 60 == 0) {

                            /*
                             * Temps lisible.
                             */
                            String timeMessage;

                            /*
                             * Minutes.
                             */
                            if (swapTimer >= 60) {

                                int remainingMinutes =
                                        swapTimer / 60;

                                timeMessage =
                                        remainingMinutes
                                                + " minute"
                                                + (remainingMinutes > 1 ? "s" : "");
                            }

                            /*
                             * Secondes.
                             */
                            else {

                                timeMessage =
                                        swapTimer
                                                + " seconde"
                                                + (swapTimer > 1 ? "s" : "");
                            }

                            Bukkit.broadcastMessage(
                                    "§eSwap dans "
                                            + timeMessage
                                            + " !"
                            );
                        }

                        /*
                         * Countdown écran.
                         */
                        if (swapTimer <= 5
                                && swapTimer > 0) {

                            for (Player player
                                    : Bukkit.getOnlinePlayers()) {

                                player.sendTitle(
                                        "§c"
                                                + swapTimer,
                                        "§fPréparez-vous au swap !",
                                        0,
                                        20,
                                        0
                                );
                            }
                        }

                        /*
                         * Déclenche swap.
                         */
                        if (swapTimer <= 0) {

                            cancel();

                            performSwap();

                            /*
                             * Nouveau délai :
                             * 5 -> 15 minutes.
                             */
                            int nextSwap =
                                    random.nextInt(11)
                                            + 5;

                            scheduleNextSwap(
                                    nextSwap
                            );
                        }
                    }

                };

        /*
         * Lancement task.
         */
        swapTask.runTaskTimer(
                plugin,
                20L,
                20L
        );
    }

    /*
     * Effectue swap multi.
     */
    private void performSwap() {

        List<Player> players =
                new ArrayList<>(
                        Bukkit.getOnlinePlayers()
                );

        /*
         * Minimum 2 joueurs.
         */
        if (players.size() < 2) {

            Bukkit.broadcastMessage(
                    "§cPas assez de joueurs pour swap."
            );

            return;
        }

        /*
         * Sauvegarde positions.
         */
        Map<Player, Location> locations =
                new HashMap<>();

        for (Player player : players) {

            locations.put(
                    player,
                    player.getLocation()
            );
        }

        /*
         * Mélange joueurs.
         */
        List<Player> shuffled =
                new ArrayList<>(players);

        do {

            Collections.shuffle(shuffled);

        } while (containsSelfAssignment(
                players,
                shuffled
        ));

        /*
         * Effectue swaps.
         */
        for (int i = 0;
             i < players.size();
             i++) {

            Player player =
                    players.get(i);

            Player target =
                    shuffled.get(i);

            Location targetLocation =
                    locations.get(target);

            /*
             * Téléportation.
             */
            player.teleport(
                    targetLocation
            );

            /*
             * Sauvegarde propriétaire.
             */
            swapOwners.put(
                    player,
                    target
            );

            /*
             * Effet visuel.
             */
            player.sendTitle(
                    "§4§lSWAP !",
                    "§fVous avez été échangé",
                    10,
                    40,
                    10
            );
        }

        Bukkit.broadcastMessage(
                "§cLes positions ont été échangées !"
        );
    }

    /*
     * Vérifie qu'aucun joueur
     * ne garde sa propre position.
     */
    private boolean containsSelfAssignment(
            List<Player> original,
            List<Player> shuffled
    ) {

        for (int i = 0;
             i < original.size();
             i++) {

            if (original.get(i)
                    .equals(shuffled.get(i))) {

                return true;
            }
        }

        return false;
    }

    /*
     * Retourne propriétaire
     * du piège.
     */
    public Player getSwapOwner(
            Player deadPlayer
    ) {

        return swapOwners.get(deadPlayer);
    }
}