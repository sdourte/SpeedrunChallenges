package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class XPChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Niveau cible
    private int targetLevel;

    // Random
    private final Random random;

    public XPChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {

        return "XP Challenge";
    }

    @Override
    public String getObjective() {

        return "Atteignez un niveau XP";
    }

    @Override
    public String getRecordKey() {

        return "xp:"
                + targetLevel;
    }

    @Override
    public void start() {

        /*
         * Niveau aléatoire entre
         * 1 et 30.
         */
        targetLevel = random.nextInt(30) + 1;

        Bukkit.broadcastMessage(
                "§eNiveau à atteindre :"
        );

        Bukkit.broadcastMessage(
                "§fNiveau "
                        + targetLevel
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe XP Challenge est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le XP Challenge !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§aAtteignez le niveau §f"
                        + targetLevel
        );

        bossBar.setProgress(1.0);
    }

    /*
     * Getter niveau cible.
     */
    public int getTargetLevel() {

        return targetLevel;
    }
}