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
                 * OUTILS / UTILITAIRES
                 * =========================
                 */

                Material.BUCKET,
                Material.WATER_BUCKET,
                Material.LAVA_BUCKET,

                Material.COMPASS,

                Material.CLOCK,

                Material.SPYGLASS,

                Material.SHEARS,

                Material.FLINT_AND_STEEL,

                Material.LEAD,

                Material.NAME_TAG,

                Material.SADDLE,

                Material.BRUSH,

                Material.WRITABLE_BOOK,

                Material.BOOK,
                Material.BOOKSHELF,

                Material.MAP,

                Material.GLASS_BOTTLE,

                /*
                 * =========================
                 * ARMES / COMBAT
                 * =========================
                 */

                Material.SHIELD,

                Material.BOW,
                Material.CROSSBOW,

                Material.ARROW,
                Material.SPECTRAL_ARROW,

                Material.TRIDENT,

                Material.TNT,

                Material.FIRE_CHARGE,

                Material.END_CRYSTAL,

                /*
                 * =========================
                 * REDSTONE
                 * =========================
                 */

                Material.OBSERVER,

                Material.PISTON,
                Material.STICKY_PISTON,

                Material.REPEATER,
                Material.COMPARATOR,

                Material.DAYLIGHT_DETECTOR,

                Material.NOTE_BLOCK,

                Material.JUKEBOX,

                Material.HOPPER,

                Material.DROPPER,
                Material.DISPENSER,

                Material.REDSTONE_LAMP,

                Material.TARGET,

                Material.OAK_BUTTON,
                Material.LEVER,
                Material.REDSTONE_TORCH,

                /*
                 * =========================
                 * TRANSPORT
                 * =========================
                 */

                Material.MINECART,
                Material.CHEST_MINECART,
                Material.FURNACE_MINECART,
                Material.TNT_MINECART,

                Material.RAIL,
                Material.POWERED_RAIL,
                Material.DETECTOR_RAIL,
                Material.ACTIVATOR_RAIL,

                Material.OAK_BOAT,
                Material.OAK_CHEST_BOAT,
                Material.SPRUCE_BOAT,
                Material.BIRCH_BOAT,
                Material.ACACIA_BOAT,
                Material.CHERRY_BOAT,
                Material.DARK_OAK_BOAT,
                Material.JUNGLE_BOAT,

                /*
                 * =========================
                 * BLOCS UTILITAIRES
                 * =========================
                 */

                Material.CAMPFIRE,

                Material.BLAST_FURNACE,

                Material.SMOKER,

                Material.CARTOGRAPHY_TABLE,

                Material.FLETCHING_TABLE,

                Material.SMITHING_TABLE,

                Material.BREWING_STAND,

                Material.ANVIL,

                Material.CAULDRON,

                Material.LECTERN,

                Material.BARREL,

                Material.LOOM,

                Material.GRINDSTONE,

                Material.STONECUTTER,

                Material.ENCHANTING_TABLE,

                Material.ENDER_CHEST,

                /*
                 * =========================
                 * DÉCORATION
                 * =========================
                 */

                Material.LANTERN,
                Material.SOUL_LANTERN,

                Material.ITEM_FRAME,
                Material.GLOW_ITEM_FRAME,

                Material.PAINTING,

                Material.ARMOR_STAND,

                Material.FLOWER_POT,

                Material.IRON_CHAIN,
                Material.IRON_BARS,

                Material.BELL,

                Material.CANDLE,

                Material.SEA_LANTERN,

                /*
                 * =========================
                 * LITS / CONFORT
                 * =========================
                 */

                Material.RED_BED,
                Material.BLUE_BED,
                Material.GREEN_BED,
                Material.YELLOW_BED,
                Material.BLACK_BED,
                Material.WHITE_BED,
                Material.PURPLE_BED,
                Material.CYAN_BED,

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
                Material.COOKED_CHICKEN,
                Material.COOKED_PORKCHOP,
                Material.COOKED_MUTTON,
                Material.COOKED_RABBIT,

                Material.RABBIT_STEW,

                Material.SUSPICIOUS_STEW,

                Material.BEETROOT_SOUP,

                Material.HONEY_BOTTLE,

                Material.MUSHROOM_STEW,

                Material.DRIED_KELP,

                Material.GLOW_BERRIES,

                /*
                 * =========================
                 * FARM / MOBS
                 * =========================
                 */

                Material.SLIME_BALL,

                Material.STRING,

                Material.FEATHER,

                Material.LEATHER,

                Material.EGG,

                Material.INK_SAC,
                Material.GLOW_INK_SAC,

                Material.GUNPOWDER,

                Material.BONE,
                Material.BONE_MEAL,

                Material.ROTTEN_FLESH,

                Material.SPIDER_EYE,
                Material.FERMENTED_SPIDER_EYE,

                Material.RABBIT_FOOT,

                Material.RABBIT_HIDE,

                Material.PRISMARINE_SHARD,
                Material.PRISMARINE_CRYSTALS,

                Material.TURTLE_SCUTE,

                Material.PUFFERFISH,

                /*
                 * =========================
                 * NETHER
                 * =========================
                 */

                Material.BLAZE_ROD,
                Material.BLAZE_POWDER,

                Material.GHAST_TEAR,

                Material.MAGMA_CREAM,

                Material.NETHER_WART,

                Material.QUARTZ,

                Material.GLOWSTONE_DUST,

                Material.PIGLIN_BANNER_PATTERN,

                Material.CRYING_OBSIDIAN,

                Material.SOUL_TORCH,

                Material.SOUL_CAMPFIRE,

                /*
                 * =========================
                 * END / RARES
                 * =========================
                 */

                Material.ENDER_PEARL,

                Material.ENDER_EYE,

                Material.SHULKER_SHELL,

                Material.CHORUS_FRUIT,

                Material.DRAGON_BREATH,

                Material.END_ROD,

                /*
                 * =========================
                 * LOOT / EXPLORATION
                 * =========================
                 */

                Material.NAUTILUS_SHELL,

                Material.HEART_OF_THE_SEA,

                Material.ENCHANTED_BOOK,

                Material.GOLDEN_HORSE_ARMOR,
                Material.IRON_HORSE_ARMOR,
                Material.DIAMOND_HORSE_ARMOR,

                Material.MUSIC_DISC_13,
                Material.MUSIC_DISC_CAT,
                Material.MUSIC_DISC_BLOCKS,
                Material.MUSIC_DISC_CHIRP,
                Material.MUSIC_DISC_FAR,
                Material.MUSIC_DISC_11,
                Material.MUSIC_DISC_MALL,
                Material.MUSIC_DISC_MELLOHI,
                Material.MUSIC_DISC_STAL,
                Material.MUSIC_DISC_STRAD,
                Material.MUSIC_DISC_WARD,
                Material.MUSIC_DISC_WAIT,
                Material.MUSIC_DISC_OTHERSIDE,
                Material.MUSIC_DISC_PIGSTEP,

                Material.ECHO_SHARD,

                Material.OMINOUS_BOTTLE,

                Material.TRIAL_KEY,

                Material.GOAT_HORN,

                /*
                 * =========================
                 * RESSOURCES
                 * =========================
                 */

                Material.EMERALD,

                Material.DIAMOND,

                Material.AMETHYST_SHARD,

                Material.COPPER_INGOT,

                Material.IRON_INGOT,

                Material.GOLD_INGOT,

                Material.NETHERITE_SCRAP,

                Material.COAL,

                Material.CHARCOAL,

                Material.LAPIS_LAZULI,

                Material.REDSTONE,

                /*
                 * =========================
                 * PÊCHE / OCÉAN
                 * =========================
                 */

                Material.FISHING_ROD,

                Material.COD,
                Material.SALMON,
                Material.TROPICAL_FISH,

                Material.PUFFERFISH_BUCKET,

                Material.TADPOLE_BUCKET,

                /*
                 * =========================
                 * FUN / DIVERS
                 * =========================
                 */

                Material.FIREWORK_ROCKET,

                Material.FIREWORK_STAR,

                Material.SLIME_BLOCK,

                Material.HONEY_BLOCK,

                Material.TOTEM_OF_UNDYING,

                Material.WIND_CHARGE
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