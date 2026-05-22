package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class DeathSwapChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Temps entre les swaps (en secondes)
    private final int swapInterval = 300;

    // Timer actuel
    private int swapTimer;

    // Task de swap
    private BukkitRunnable swapTask;

    public DeathSwapChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        // Timer initial
        this.swapTimer = swapInterval;
    }

    @Override
    public String getName() {
        return "Death Swap";
    }

    @Override
    public String getObjective() {
        return "Faites mourir votre adversaire";
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§cFaites mourir votre adversaire"
        );

        bossBar.setProgress(1.0);
    }

    @Override
    public void start() {

        Bukkit.broadcastMessage(
                "§cDeath Swap commencé !"
        );

        startSwapTask();
    }

    @Override
    public void stop() {

        /*
         * Stop du runnable de swap.
         */
        if (swapTask != null) {

            swapTask.cancel();
        }

        Bukkit.broadcastMessage(
                "§cDeath Swap terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a" + player.getName()
                        + " a gagné le Death Swap !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    /*
     * Lance le timer de swap.
     */
    private void startSwapTask() {

        swapTask = new BukkitRunnable() {

            @Override
            public void run() {

                /*
                 * Vérifie que le challenge
                 * est toujours actif.
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
                 * Affichage timer chat.
                 */
                if (swapTimer <= 10
                        || swapTimer % 60 == 0) {

                    Bukkit.broadcastMessage(
                            "§eSwap dans "
                                    + swapTimer
                                    + " secondes !"
                    );
                }

                /*
                 * Countdown au centre de l'écran.
                 */
                if (swapTimer <= 5
                        && swapTimer > 0) {

                    for (Player player
                            : Bukkit.getOnlinePlayers()) {

                        player.sendTitle(
                                "§c" + swapTimer,
                                "§fPréparez-vous au swap !",
                                0,
                                20,
                                0
                        );
                    }
                }

                /*
                 * Déclenchement du swap.
                 */
                if (swapTimer <= 0) {

                    performSwap();

                    // Reset timer
                    swapTimer = swapInterval;
                }
            }
        };

        /*
         * Lancement du runnable.
         */
        swapTask.runTaskTimer(
                plugin,
                20L,
                20L
        );
    }

    /*
     * Échange les positions.
     */
    private void performSwap() {

        List<Player> players =
                new ArrayList<>(Bukkit.getOnlinePlayers());

        /*
         * Vérifie qu'il y a 2 joueurs.
         */
        if (players.size() != 2) {

            Bukkit.broadcastMessage(
                    "§cPas assez de joueurs pour swap."
            );

            return;
        }

        Player player1 = players.get(0);
        Player player2 = players.get(1);

        /*
         * Sauvegarde positions.
         */
        Location loc1 = player1.getLocation();
        Location loc2 = player2.getLocation();

        /*
         * Swap des positions.
         */
        player1.teleport(loc2);
        player2.teleport(loc1);

        /*
         * Effets visuels.
         */
        player1.sendTitle(
                "§4§lSWAP !",
                "§fLes positions ont été échangées",
                10,
                40,
                10
        );

        player2.sendTitle(
                "§4§lSWAP !",
                "§fLes positions ont été échangées",
                10,
                40,
                10
        );

        Bukkit.broadcastMessage(
                "§cLes joueurs ont été échangés !"
        );
    }
}