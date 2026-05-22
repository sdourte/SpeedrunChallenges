package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Random;

public class MobKillChallenge implements Challenge {

    // Référence vers le plugin
    private final SpeedrunChallenges plugin;

    // Mob à tuer
    private EntityType targetMob;

    // Générateur aléatoire
    private final Random random;

    public MobKillChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {
        return "Mob Kill Challenge";
    }

    @Override
    public String getObjective() {
        return "Tuer un " + targetMob;
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§cTuez : §f"
                        + plugin.getTranslationManager()
                        .getMobName(targetMob)
        );

        bossBar.setProgress(1.0);
    }

    @Override
    public void start() {

        // Liste des mobs possibles
        EntityType[] possibleMobs = {

                // Zombies
                EntityType.ZOMBIE,
                EntityType.HUSK,
                EntityType.DROWNED,
                EntityType.ZOMBIE_VILLAGER,

                // Squelettes
                EntityType.SKELETON,
                EntityType.STRAY,
                EntityType.WITHER_SKELETON,

                // Creepers & araignées
                EntityType.CREEPER,
                EntityType.SPIDER,
                EntityType.CAVE_SPIDER,

                // Nether
                EntityType.BLAZE,
                EntityType.GHAST,
                EntityType.MAGMA_CUBE,
                EntityType.PIGLIN_BRUTE,
                EntityType.ZOMBIFIED_PIGLIN,

                // End
                EntityType.ENDERMAN,
                EntityType.ENDERMITE,

                // Illagers
                EntityType.PILLAGER,
                EntityType.VINDICATOR,

                // Slimes
                EntityType.SLIME,

                // Aquatiques hostiles
                EntityType.GUARDIAN,
                EntityType.ELDER_GUARDIAN,

                // Divers
                EntityType.WITCH,
                EntityType.PHANTOM,
                EntityType.SILVERFISH,

                // Boss-lite / rares
                EntityType.RAVAGER,
                EntityType.HOGLIN
        };

        // Choix aléatoire
        targetMob = possibleMobs[random.nextInt(possibleMobs.length)];

        Bukkit.broadcastMessage(
                "§ePremier à tuer un " + plugin.getTranslationManager()
                        .getMobName(targetMob) + " !"
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
                "§a" + player.getName()
                        + " a gagné le Mob Kill Challenge !"
        );

        // Fin de la partie
        plugin.getGameManager().endGame(player);

        // Stop du challenge
        stop();
    }

    /*
     * Getter du mob cible.
     */
    public EntityType getTargetMob() {
        return targetMob;
    }
}