package me.simon.speedrunchallenges.challenges;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public interface Challenge {

    /*
     * Nom du challenge.
     */
    String getName();

    /*
     * Affichage du challenge.
     */
    String getObjective();

    /*
     * Méthode de personnalisation de la Boss Bar
     */
    void setupBossBar(BossBar bossBar);

    /*
     * Appelé lorsque la partie démarre.
     */
    void start();

    /*
     * Appelé lorsque la partie se termine.
     */
    void stop();

    /*
     * Vérifie si un joueur a gagné.
     */
    void win(Player player);
}