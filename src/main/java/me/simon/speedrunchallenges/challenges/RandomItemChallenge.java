package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class RandomItemChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Objet cible
    private Material targetItem;

    // Random
    private final Random random;

    public RandomItemChallenge(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {

        return "Random Item";
    }

    @Override
    public String getObjective() {

        return "Obtenez un objet aléatoire";
    }

    @Override
    public void start() {

        /*
         * Liste des objets possibles.
         */
        List<Material> possibleItems = List.of(

                /*
                 * =========================
                 * CRAFTABLES SIMPLES
                 * =========================
                 */

                Material.BUCKET,
                Material.COMPASS,
                Material.CLOCK,

                Material.SHIELD,

                Material.SHEARS,

                Material.RED_BED,
                Material.BLUE_BED,
                Material.GREEN_BED,
                Material.YELLOW_BED,

                Material.TNT,

                Material.BOOKSHELF,

                Material.CROSSBOW,
                Material.BOW,

                Material.FISHING_ROD,

                Material.HOPPER,

                Material.MINECART,

                Material.LANTERN,

                Material.ITEM_FRAME,

                Material.CAMPFIRE,

                Material.BLAST_FURNACE,

                Material.SMOKER,

                Material.CARTOGRAPHY_TABLE,

                Material.FLETCHING_TABLE,

                Material.SMITHING_TABLE,

                Material.BREWING_STAND,

                Material.ANVIL,

                Material.CAULDRON,

                Material.OBSERVER,

                Material.PISTON,

                Material.STICKY_PISTON,

                Material.REPEATER,

                Material.COMPARATOR,

                Material.DAYLIGHT_DETECTOR,

                Material.NOTE_BLOCK,

                Material.JUKEBOX,

                Material.LECTERN,

                Material.BARREL,

                Material.IRON_CHAIN,

                Material.PAINTING,

                /*
                 * =========================
                 * NOURRITURE
                 * =========================
                 */

                Material.CAKE,

                Material.GOLDEN_APPLE,

                Material.PUMPKIN_PIE,

                Material.COOKIE,

                Material.BREAD,

                Material.COOKED_BEEF,

                Material.RABBIT_STEW,

                Material.SUSPICIOUS_STEW,

                /*
                 * =========================
                 * LOOT / EXPLORATION
                 * =========================
                 */

                Material.SADDLE,

                Material.NAME_TAG,

                Material.ENDER_PEARL,

                Material.TRIDENT,

                Material.NAUTILUS_SHELL,

                Material.HEART_OF_THE_SEA,

                Material.MUSIC_DISC_13,

                Material.MUSIC_DISC_CAT,

                Material.ENCHANTED_BOOK,

                Material.GOLDEN_HORSE_ARMOR,

                Material.DIAMOND_HORSE_ARMOR,

                /*
                 * =========================
                 * NETHER
                 * =========================
                 */

                Material.BLAZE_ROD,

                Material.GHAST_TEAR,

                Material.MAGMA_CREAM,

                Material.NETHER_WART,

                Material.QUARTZ,

                Material.GLOWSTONE_DUST,

                /*
                 * =========================
                 * FARM / MOBS
                 * =========================
                 */

                Material.HONEY_BOTTLE,

                Material.SLIME_BALL,

                Material.STRING,

                Material.FEATHER,

                Material.LEATHER,

                Material.EGG,

                Material.INK_SAC,

                Material.GUNPOWDER,

                Material.BONE,

                Material.ROTTEN_FLESH,

                Material.SPIDER_EYE,

                /*
                 * =========================
                 * RARES MAIS ACCESSIBLES
                 * =========================
                 */

                Material.EMERALD,

                Material.DIAMOND,

                Material.AMETHYST_SHARD,

                Material.PRISMARINE_CRYSTALS,

                Material.ECHO_SHARD
        );

        /*
         * Choix aléatoire.
         */
        targetItem = possibleItems.get(
                random.nextInt(possibleItems.size())
        );

        Bukkit.broadcastMessage(
                "§eObjet à obtenir :"
        );

        Bukkit.broadcastMessage(
                "§f"
                        + plugin.getTranslationManager()
                        .getItemName(targetItem)
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe Random Item Challenge est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le Random Item Challenge !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§dObtenez : §f"
                        + plugin.getTranslationManager()
                        .getItemName(targetItem)
        );

        bossBar.setProgress(1.0);
    }

    /*
     * Getter objet cible.
     */
    public Material getTargetItem() {

        return targetItem;
    }
}