package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.EntityType;
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

        return "Subissez des dégâts";
    }

    @Override
    public void start() {

        /*
         * Causes possibles.
         */
        List<EntityDamageEvent.DamageCause> causes = List.of(

                // Eau
                EntityDamageEvent.DamageCause.DROWNING,

                // Chute
                EntityDamageEvent.DamageCause.FALL,

                // Feu
                EntityDamageEvent.DamageCause.FIRE,
                EntityDamageEvent.DamageCause.FIRE_TICK,
                EntityDamageEvent.DamageCause.LAVA,
                EntityDamageEvent.DamageCause.HOT_FLOOR,

                // Explosions
                EntityDamageEvent.DamageCause.BLOCK_EXPLOSION,
                EntityDamageEvent.DamageCause.ENTITY_EXPLOSION,

                // Foudre
                EntityDamageEvent.DamageCause.LIGHTNING,

                // Contact
                EntityDamageEvent.DamageCause.CONTACT, // cactus

                // Faim (seulement ici car on ne peut pas mourir de faim)
                EntityDamageEvent.DamageCause.STARVATION,

                // Gel
                EntityDamageEvent.DamageCause.FREEZE,

                // Magie
                EntityDamageEvent.DamageCause.MAGIC,
                //(seulement ici car on ne peut pas mourir de poison)
                EntityDamageEvent.DamageCause.POISON,

                // Combat
                EntityDamageEvent.DamageCause.ENTITY_ATTACK,
                EntityDamageEvent.DamageCause.PROJECTILE,

                // Divers
                EntityDamageEvent.DamageCause.THORNS,
                EntityDamageEvent.DamageCause.CRAMMING,

                // Respiration / environnement
                EntityDamageEvent.DamageCause.SUFFOCATION,

                // Électricité / trident
                EntityDamageEvent.DamageCause.LIGHTNING,

                // Sol dangereux
                EntityDamageEvent.DamageCause.HOT_FLOOR
        );

        /*
         * Choix aléatoires.
         */
        targetCause = causes.get(
                random.nextInt(causes.size())
        );

        /*
         * Dégâts aléatoires en 1 et 50.
         *
         * En demi-cœurs Minecraft :
         * 1 cœur = 2 damage
         */
        targetDamage = random.nextInt(50) + 1;

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

            case HOT_FLOOR -> "Bloc de magma";

            case POISON -> "Poison";

            case ENTITY_ATTACK -> "Attaque de mob";

            case PROJECTILE -> "Projectile";

            case THORNS -> "Épines";

            case CRAMMING -> "Écrasement (plein d'entités)";

            case SUFFOCATION -> "Suffocation";

            case DROWNING -> "Se noyer";
            case FALL -> "Tomber dans le vide";
            case FALLING_BLOCK -> "Gravité des blocs (enclume, stalactite)";
            case LAVA -> "Mourir dans la lave";
            case FIRE -> "Brûler (dans le feu)";
            case FIRE_TICK -> "Brûler (hors du feu)";

            case ENTITY_EXPLOSION -> "Explosion (mob)";
            case BLOCK_EXPLOSION -> "Explosion (bloc)";

            case LIGHTNING -> "Foudre";

            case CONTACT -> "Cactus";

            case STARVATION -> "Faim";

            case FREEZE -> "Gel";

            case MAGIC -> "Magie";

            default -> targetCause.name();
        };
    }


}