package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.Bukkit;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.*;

public class AnyMobChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Liste des mobs à tuer
    private final List<EntityType> targetMobs;

    // Progression des joueurs
    private final Map<Player, Set<EntityType>> playerProgress;

    // Générateur aléatoire
    private final Random random;

    public AnyMobChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.targetMobs = new ArrayList<>();

        this.playerProgress = new HashMap<>();

        this.random = new Random();
    }

    @Override
    public String getName() {
        return "Any Mob Challenge";
    }

    @Override
    public String getObjective() {

        return "Tuez 2 mobs différents";
    }

    @Override
    public String getRecordKey() {

        List<String> names =
                targetMobs.stream()
                        .map(Enum::name)
                        .sorted()
                        .toList();

        return "anymobkill:"
                + String.join("_", names);
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        /*
         * BossBar pleine en permanence.
         */
        bossBar.setProgress(1.0);

        /*
         * Initialise affichage objectifs.
         */
        setupBossBarObjectives();
    }

    /*
     * Initialise affichage BossBar.
     */
    private void setupBossBarObjectives() {

        /*
         * Vérifie BossBar.
         */
        if (plugin.getGameManager()
                .getBossBar() == null) {

            return;
        }

        /*
         * Construction texte.
         */
        StringBuilder builder =
                new StringBuilder("§eMobs : §f");

        for (EntityType mob : targetMobs) {

            builder.append(
                    plugin.getTranslationManager()
                            .getMobName(mob)
            );

            builder.append(" §f| ");
        }

        /*
         * Retire dernier séparateur.
         */
        if (builder.length() >= 2) {

            builder.setLength(
                    builder.length() - 2
            );
        }

        /*
         * Mise à jour titre.
         */
        plugin.getGameManager()
                .getBossBar()
                .setTitle(builder.toString());

        /*
         * BossBar fixe.
         */
        plugin.getGameManager()
                .getBossBar()
                .setProgress(1.0);
    }

    @Override
    public void start() {

        /*
         * Liste des mobs possibles.
         */
        EntityType[] possibleMobs = {

                // Passive
                EntityType.ALLAY,
                EntityType.ARMADILLO,
                EntityType.AXOLOTL,
                EntityType.BAT,
                EntityType.CAMEL,
                EntityType.CAT,
                EntityType.CHICKEN,
                EntityType.COD,
                EntityType.COPPER_GOLEM,
                EntityType.COW,
                EntityType.DONKEY,
                EntityType.FROG,
                EntityType.GLOW_SQUID,
                EntityType.HAPPY_GHAST,
                EntityType.HORSE,
                EntityType.MULE,
                EntityType.OCELOT,
                EntityType.PARROT,
                EntityType.PIG,
                EntityType.RABBIT,
                EntityType.SALMON,
                EntityType.SHEEP,
                EntityType.SNOW_GOLEM,
                EntityType.SQUID,
                EntityType.STRIDER,
                EntityType.TROPICAL_FISH,
                EntityType.TURTLE,
                EntityType.VILLAGER,

                // Neutral
                EntityType.BEE,
                EntityType.CAVE_SPIDER,
                EntityType.DOLPHIN,
                EntityType.DROWNED,
                EntityType.ENDERMAN,
                EntityType.FOX,
                EntityType.GOAT,
                EntityType.IRON_GOLEM,
                EntityType.LLAMA,
                EntityType.NAUTILUS,
                EntityType.PANDA,
                EntityType.PIGLIN,
                EntityType.POLAR_BEAR,
                EntityType.PUFFERFISH,
                EntityType.SPIDER,
                EntityType.WOLF,

                // Hostile
                EntityType.BLAZE,
                EntityType.BOGGED,
                EntityType.BREEZE,
                EntityType.CREAKING,
                EntityType.CREEPER,
                EntityType.ENDERMITE,
                EntityType.GHAST,
                EntityType.GUARDIAN,
                EntityType.HOGLIN,
                EntityType.HUSK,
                EntityType.MAGMA_CUBE,
                EntityType.PARCHED,
                EntityType.PILLAGER,
                EntityType.SKELETON,
                EntityType.SLIME,
                EntityType.STRAY,
                EntityType.WITCH,
                EntityType.WITHER_SKELETON,
                EntityType.ZOMBIE,
                EntityType.ZOMBIE_VILLAGER
        };

        /*
         * Mélange la liste.
         */
        List<EntityType> shuffled =
                new ArrayList<>(Arrays.asList(possibleMobs));

        Collections.shuffle(shuffled);

        /*
         * Garde uniquement 2 mobs.
         */
        targetMobs.add(shuffled.get(0));
        targetMobs.add(shuffled.get(1));

        /*
         * Affichage des objectifs.
         */
        Bukkit.broadcastMessage("§eMobs à tuer :");

        for (EntityType mob : targetMobs) {

            Bukkit.broadcastMessage(
                    "§f- " + plugin.getTranslationManager()
                            .getMobName(mob)
            );
        }

        /*
         * Initialise progression joueurs.
         */
        for (Player player
                : Bukkit.getOnlinePlayers()) {

            playerProgress.put(
                    player,
                    new HashSet<>()
            );
        }

        /*
         * Initialise BossBar.
         */
        setupBossBarObjectives();
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
                        + " a gagné le AnyMob Challenge !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    /*
     * Gestion des kills.
     */
    public void handleKill(Player player,
                           EntityType killedMob) {

        /*
         * Vérifie que le mob fait partie
         * des objectifs.
         */
        if (!targetMobs.contains(killedMob)) {
            return;
        }

        /*
         * Crée la progression du joueur
         * si elle n'existe pas.
         */
        playerProgress.putIfAbsent(
                player,
                new HashSet<>()
        );

        /*
         * Vérifie si déjà validé.
         */
        if (playerProgress.get(player)
                .contains(killedMob)) {

            return;
        }

        /*
         * Ajoute le mob tué.
         */
        playerProgress.get(player)
                .add(killedMob);

        player.sendMessage(
                "§aObjectif validé : "
                        + plugin.getTranslationManager()
                        .getMobName(killedMob)
        );

        /*
         * Vérifie victoire.
         */
        if (playerProgress.get(player)
                .size() >= targetMobs.size()) {

            win(player);
        }
    }

    /*
     * Getter des mobs objectifs.
     */
    public List<EntityType> getTargetMobs() {
        return targetMobs;
    }
}