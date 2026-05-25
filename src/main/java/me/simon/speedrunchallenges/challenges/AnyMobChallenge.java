package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;
import me.simon.speedrunchallenges.game.GameState;

import org.bukkit.Bukkit;

import org.bukkit.boss.BossBar;
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

        return "Tuez 3 mobs différents";
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
                new StringBuilder("§eMobs : ");

        for (EntityType mob : targetMobs) {

            builder.append(
                    plugin.getTranslationManager()
                            .getMobName(mob)
            );

            builder.append(" §7| ");
        }

        /*
         * Retire dernier séparateur.
         */
        if (builder.length() >= 3) {

            builder.setLength(
                    builder.length() - 3
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

                // Ferme / passifs
                EntityType.PIG,
                EntityType.COW,
                EntityType.SHEEP,
                EntityType.CHICKEN,
                EntityType.HORSE,
                EntityType.DONKEY,
                EntityType.MULE,
                EntityType.GOAT,
                EntityType.RABBIT,
                EntityType.CAMEL,
                EntityType.LLAMA,
                EntityType.TRADER_LLAMA,

                // Village / PNJ
                EntityType.VILLAGER,
                EntityType.WANDERING_TRADER,

                // Animaux sauvages
                EntityType.WOLF,
                EntityType.FOX,
                EntityType.OCELOT,
                EntityType.CAT,
                EntityType.PARROT,
                EntityType.PANDA,
                EntityType.POLAR_BEAR,
                EntityType.BEE,
                EntityType.TURTLE,
                EntityType.FROG,
                EntityType.AXOLOTL,

                // Aquatiques
                EntityType.COD,
                EntityType.SALMON,
                EntityType.PUFFERFISH,
                EntityType.TROPICAL_FISH,
                EntityType.SQUID,
                EntityType.GLOW_SQUID,
                EntityType.DOLPHIN,

                // Hostiles classiques
                EntityType.ZOMBIE,
                EntityType.HUSK,
                EntityType.DROWNED,
                EntityType.ZOMBIE_VILLAGER,

                EntityType.SKELETON,
                EntityType.STRAY,
                EntityType.WITHER_SKELETON,

                EntityType.CREEPER,
                EntityType.SPIDER,
                EntityType.CAVE_SPIDER,

                EntityType.ENDERMAN,
                EntityType.ENDERMITE,

                EntityType.SLIME,
                EntityType.MAGMA_CUBE,

                EntityType.WITCH,
                EntityType.SILVERFISH,

                // Nether
                EntityType.BLAZE,
                EntityType.GHAST,
                EntityType.HOGLIN,
                EntityType.PIGLIN,

                // Illagers
                EntityType.PILLAGER,
                EntityType.VINDICATOR,

                // Aquatiques hostiles
                EntityType.GUARDIAN,
                EntityType.ELDER_GUARDIAN,

                // Divers fun
                EntityType.IRON_GOLEM,
                EntityType.SNOW_GOLEM
        };

        /*
         * Mélange la liste.
         */
        List<EntityType> shuffled =
                new ArrayList<>(Arrays.asList(possibleMobs));

        Collections.shuffle(shuffled);

        /*
         * Garde uniquement 3 mobs.
         */
        targetMobs.add(shuffled.get(0));
        targetMobs.add(shuffled.get(1));
        targetMobs.add(shuffled.get(2));

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