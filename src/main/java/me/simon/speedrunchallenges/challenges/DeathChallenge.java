package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeathChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Mort cible
    private DamageCause targetDeath;

    // Random
    private final Random random;

    public DeathChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {
        return "Death Challenge";
    }

    @Override
    public String getObjective() {

        if (targetDeath == null) {
            return "Aucune mort";
        }

        return "Mort : " + getDeathName();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§4Mort : §f"
                        + getDeathName()
        );

        bossBar.setProgress(1.0);
    }

    @Override
    public void start() {

        /*
         * Liste des morts possibles.
         */
        List<DamageCause> deaths = List.of(

                // Eau
                DamageCause.DROWNING,

                // Chute
                DamageCause.FALL,
                DamageCause.FALLING_BLOCK,

                // Feu
                DamageCause.FIRE,
                DamageCause.FIRE_TICK,
                DamageCause.LAVA,
                DamageCause.HOT_FLOOR,

                // Explosions
                DamageCause.BLOCK_EXPLOSION,
                DamageCause.ENTITY_EXPLOSION,

                // Foudre
                DamageCause.LIGHTNING,

                // Contact
                DamageCause.CONTACT, // cactus

                // Gel
                DamageCause.FREEZE,

                // Magie
                DamageCause.MAGIC,

                // Combat
                DamageCause.ENTITY_ATTACK,
                DamageCause.PROJECTILE,

                // Divers
                DamageCause.THORNS,
                DamageCause.CRAMMING,

                // Respiration / environnement
                DamageCause.SUFFOCATION,

                // Électricité / trident
                DamageCause.LIGHTNING,

                // Sol dangereux
                DamageCause.HOT_FLOOR
        );

        /*
         * Choix aléatoire.
         */
        targetDeath = deaths.get(
                random.nextInt(deaths.size())
        );

        Bukkit.broadcastMessage(
                "§ePremier à mourir de cette façon :"
        );

        Bukkit.broadcastMessage(
                "§f" + getDeathName()
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cDeath Challenge terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a" + player.getName()
                        + " a gagné le Death Challenge !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    /*
     * Getter mort cible.
     */
    public DamageCause getTargetDeath() {
        return targetDeath;
    }

    /*
     * Traduction FR.
     */
    private String getDeathName() {

        return switch (targetDeath) {

            case HOT_FLOOR -> "Bloc de magma";

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

            case FREEZE -> "Gel";

            case MAGIC -> "Magie";

            default -> targetDeath.name();
        };
    }
}