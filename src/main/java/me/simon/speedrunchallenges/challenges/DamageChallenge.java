package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class DamageChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Type de dégâts
    private EntityDamageEvent.DamageCause targetCause;

    // Dégâts nécessaires
    private double targetDamage;

    // Progression dégâts joueurs
    private final Map<Player, Double> playerDamage;

    // Random
    private final Random random;

    public DamageChallenge(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
        this.playerDamage = new HashMap<>();
        this.random = new Random();
    }

    @Override
    public String getName() {

        return "Damage Challenge";
    }

    @Override
    public String getObjective() {

        return "Subissez des dégâts sans mourir";
    }

    @Override
    public void start() {

        /*
         * Causes possibles.
         */
        List<EntityDamageEvent.DamageCause> causes = List.of(

                EntityDamageEvent.DamageCause.FALL,

                EntityDamageEvent.DamageCause.FIRE,

                EntityDamageEvent.DamageCause.LAVA,

                EntityDamageEvent.DamageCause.DROWNING,

                EntityDamageEvent.DamageCause.CONTACT,

                EntityDamageEvent.DamageCause.FREEZE
        );

        /*
         * Dégâts possibles.
         *
         * En demi-cœurs Minecraft :
         * 1 cœur = 2 damage
         */
        List<Double> damages = List.of(
                2.0,
                4.0,
                6.0,
                8.0,
                10.0,
                12.0,
                14.0,
                16.0,
                18.0,
                20.0
        );

        /*
         * Choix aléatoires.
         */
        targetCause = causes.get(
                random.nextInt(causes.size())
        );

        targetDamage = damages.get(
                random.nextInt(damages.size())
        );

        Bukkit.broadcastMessage(
                "§eObjectif :"
        );

        Bukkit.broadcastMessage(
                "§fSubissez §c"
                        + (targetDamage / 2)
                        + " cœurs§f de dégâts de type : "
                        + getDamageName()
        );
        /*
         * Initialise progression joueurs.
         */
        for (Player player
                : Bukkit.getOnlinePlayers()) {

            playerDamage.put(player, 0.0);
        }
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe Damage Challenge est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le Damage Challenge !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        /*
         * BossBar initiale.
         */
        if (!Bukkit.getOnlinePlayers().isEmpty()) {

            updateBossBar(
                    Bukkit.getOnlinePlayers()
                            .iterator()
                            .next()
            );
        }
    }

    /*
     * Ajoute dégâts.
     */
    public void addDamage(
            Player player,
            double damage
    ) {

        double current =
                playerDamage.getOrDefault(player, 0.0);

        current += damage;

        playerDamage.put(player, current);
        // Mise à jour de la barre de progression
        updateBossBar(player);

        /*
         * Vérifie victoire.
         */
        if (current >= targetDamage) {

            win(player);
        }
    }

    /*
     * Getter dégâts joueur.
     */
    public double getPlayerDamage(
            Player player
    ) {

        return playerDamage.getOrDefault(
                player,
                0.0
        );
    }

    /*
     * Getter dégâts cible.
     */
    public double getTargetDamage() {

        return targetDamage;
    }

    /*
     * Getter type dégâts.
     */
    public EntityDamageEvent.DamageCause getTargetCause() {

        return targetCause;
    }

    /*
     * Met à jour la BossBar.
     */
    private void updateBossBar(
            Player player
    ) {

        /*
         * Vérifie BossBar.
         */
        if (plugin.getGameManager()
                .getBossBar() == null) {

            return;
        }

        double currentDamage =
                getPlayerDamage(player);

        double remainingDamage =
                Math.max(
                        0,
                        targetDamage - currentDamage
                );

        /*
         * Progression restante.
         */
        double progress =
                remainingDamage / targetDamage;

        /*
         * Conversion dégâts -> cœurs.
         */
        double remainingHearts =
                remainingDamage / 2;

        double totalHearts =
                targetDamage / 2;

        /*
         * Mise à jour titre.
         */
        plugin.getGameManager()
                .getBossBar()
                .setTitle(

                        "§c"
                                + remainingHearts

                                + " / "

                                + totalHearts

                                + " ❤ "

                                + getDamageName()
                );

        /*
         * Mise à jour progression.
         */
        plugin.getGameManager()
                .getBossBar()
                .setProgress(progress);
    }

    /*
     * Traduction dégâts.
     */
    private String getDamageName() {

        return switch (targetCause) {

            case FALL -> "de chute";

            case FIRE -> "de feu";

            case LAVA -> "de lave";

            case DROWNING -> "de noyade";

            case CONTACT -> "de cactus";

            case FREEZE -> "de gel";

            default -> targetCause.name();
        };
    }


}