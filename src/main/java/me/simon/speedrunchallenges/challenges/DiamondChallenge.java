package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class DiamondChallenge implements Challenge {

    // Référence vers le plugin
    private final SpeedrunChallenges plugin;

    // Constructeur
    public DiamondChallenge(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "Diamond Challenge";
    }

    @Override
    public String getObjective() {
        return "Trouver un diamant";
    }

    @Override
    public String getRecordKey() {

        return "diamond";
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§bPremier à obtenir un diamant !"
        );

        bossBar.setProgress(1.0);
    }

    @Override
    public void start() {

        Bukkit.broadcastMessage(
                "§bLe Diamond Challenge commence !"
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe challenge est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a" + player.getName() + " gagne le Diamond Challenge !"
        );

        // Fin de partie
        plugin.getGameManager().endGame(player);

        // Stop du challenge
        stop();
    }
}