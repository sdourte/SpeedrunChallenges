package me.simon.speedrunchallenges.managers;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.utils.TimeUtils;

import org.bukkit.Bukkit;

import org.bukkit.entity.Player;

import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public ScoreboardManager(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    /*
     * Met à jour le scoreboard d'un joueur.
     */
    public void updateScoreboard(Player player) {

        /*
         * Création d'un nouveau scoreboard.
         */
        Scoreboard scoreboard = Bukkit.getScoreboardManager()
                .getNewScoreboard();

        /*
         * Sidebar principale.
         */
        Objective objective = scoreboard.registerNewObjective(
                "sidebar",
                Criteria.DUMMY,
                "§bSpeedruns"
        );

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        /*
         * Ligne vide unique
         */
        objective.getScore("§r").setScore(8);

        /*
         * Challenge actuel
         */
        objective.getScore(
                "§fChallenge:"
        ).setScore(7);

        objective.getScore(
                "§a"
                        + plugin.getGameManager()
                        .getActiveChallenge()
                        .getName()
        ).setScore(6);

        /*
         * Ligne vide unique
         */
        objective.getScore("§0").setScore(5);

        /*
         * Timer
         */
        objective.getScore(
                "§fTemps: §e"
                        + TimeUtils.formatTime(
                        plugin.getGameManager()
                                .getGameTime()
                )
        ).setScore(4);

        /*
         * Ligne vide unique
         */
        objective.getScore("§1").setScore(3);

        /*
         * Titre morts
         */
        objective.getScore(
                "§fMorts:"
        ).setScore(2);

        /*
         * Affichage des morts joueurs
         */
        int score = 1;

        for (Player onlinePlayer
                : Bukkit.getOnlinePlayers()) {

            objective.getScore(
                    "§c"
                            + onlinePlayer.getName()
                            + " : §f"
                            + plugin.getGameManager()
                            .getPlayerDeaths(onlinePlayer)
            ).setScore(score);

            score--;
        }

        /*
         * Application du scoreboard.
         */
        player.setScoreboard(scoreboard);
    }
}