package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.World;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class DimensionRaceChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;
    private final DimensionMode mode;

    // Dimension cible
    private World.Environment targetDimension;

    // Random
    private final Random random;

    public DimensionRaceChallenge(
            SpeedrunChallenges plugin,
            DimensionMode mode
    ) {

        this.plugin = plugin;
        this.mode = mode;
        this.random = new Random();
    }

    @Override
    public String getName() {

        return "Dimension Race";
    }

    @Override
    public String getObjective() {

        return "Atteignez une dimension";
    }

    @Override
    public String getRecordKey() {

        return "dimensionrace:"
                + targetDimension.name();
    }

    @Override
    public void start() {

        /*
         * Choix selon mode.
         */
        switch (mode) {

            case NETHER ->

                    targetDimension =
                            World.Environment.NETHER;

            case END ->

                    targetDimension =
                            World.Environment.THE_END;

            case RANDOM -> {

                List<World.Environment> dimensions = List.of(

                        World.Environment.NETHER,

                        World.Environment.THE_END
                );

                targetDimension = dimensions.get(
                        random.nextInt(dimensions.size())
                );
            }
        }

        Bukkit.broadcastMessage(
                "§eDimension à atteindre :"
        );

        Bukkit.broadcastMessage(
                "§f"
                        + getDimensionName()
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe Dimension Race est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le Dimension Race !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§5Atteignez : §f"
                        + getDimensionName()
        );

        bossBar.setProgress(1.0);
    }

    /*
     * Getter dimension cible.
     */
    public World.Environment getTargetDimension() {

        return targetDimension;
    }

    /*
     * Nom FR dimension.
     */
    private String getDimensionName() {

        return switch (targetDimension) {

            case NETHER -> "Le Nether";

            case THE_END -> "L'End";

            default -> targetDimension.name();
        };
    }
}