package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class BlockHuntChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Bloc cible
    private Material targetBlock;

    // Random
    private final Random random;

    public BlockHuntChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {

        return "Block Hunt";
    }

    @Override
    public String getObjective() {

        return "Cassez un bloc aléatoire";
    }

    @Override
    public void start() {

        /*
         * Liste des blocs possibles.
         */
        List<Material> possibleBlocks = List.of(

                /*
                 * =========================
                 * BLOCS DE BASE
                 * =========================
                 */

                Material.STONE,
                Material.COBBLESTONE,
                Material.MOSSY_COBBLESTONE,
                Material.GRANITE,
                Material.DIORITE,
                Material.ANDESITE,
                Material.DEEPSLATE,
                Material.COBBLED_DEEPSLATE,
                Material.TUFF,
                Material.CALCITE,
                Material.DRIPSTONE_BLOCK,

                /*
                 * =========================
                 * BOIS
                 * =========================
                 */

                Material.OAK_LOG,
                Material.BIRCH_LOG,
                Material.SPRUCE_LOG,
                Material.JUNGLE_LOG,
                Material.ACACIA_LOG,
                Material.DARK_OAK_LOG,
                Material.MANGROVE_LOG,
                Material.CHERRY_LOG,

                Material.OAK_PLANKS,
                Material.BIRCH_PLANKS,
                Material.SPRUCE_PLANKS,
                Material.JUNGLE_PLANKS,
                Material.ACACIA_PLANKS,
                Material.DARK_OAK_PLANKS,
                Material.MANGROVE_PLANKS,
                Material.CHERRY_PLANKS,

                /*
                 * =========================
                 * TERRE / NATURE
                 * =========================
                 */

                Material.DIRT,
                Material.GRASS_BLOCK,
                Material.COARSE_DIRT,
                Material.PODZOL,
                Material.CLAY,
                Material.GRAVEL,
                Material.SAND,
                Material.RED_SAND,
                Material.SNOW_BLOCK,
                Material.ICE,
                Material.PACKED_ICE,
                Material.BLUE_ICE,
                Material.MOSS_BLOCK,

                /*
                 * =========================
                 * ORES
                 * =========================
                 */

                Material.COAL_ORE,
                Material.IRON_ORE,
                Material.COPPER_ORE,
                Material.GOLD_ORE,
                Material.REDSTONE_ORE,
                Material.LAPIS_ORE,
                Material.DIAMOND_ORE,
                Material.EMERALD_ORE,

                Material.DEEPSLATE_COAL_ORE,
                Material.DEEPSLATE_IRON_ORE,
                Material.DEEPSLATE_COPPER_ORE,
                Material.DEEPSLATE_GOLD_ORE,
                Material.DEEPSLATE_REDSTONE_ORE,
                Material.DEEPSLATE_LAPIS_ORE,
                Material.DEEPSLATE_DIAMOND_ORE,
                Material.DEEPSLATE_EMERALD_ORE,

                Material.NETHER_GOLD_ORE,
                Material.NETHER_QUARTZ_ORE,

                /*
                 * =========================
                 * BLOCS PRÉCIEUX
                 * =========================
                 */

                Material.IRON_BLOCK,
                Material.GOLD_BLOCK,
                Material.DIAMOND_BLOCK,
                Material.EMERALD_BLOCK,
                Material.REDSTONE_BLOCK,
                Material.LAPIS_BLOCK,
                Material.COPPER_BLOCK,

                Material.AMETHYST_BLOCK,

                /*
                 * =========================
                 * NETHER
                 * =========================
                 */

                Material.NETHERRACK,
                Material.SOUL_SAND,
                Material.SOUL_SOIL,
                Material.BASALT,
                Material.BLACKSTONE,
                Material.GILDED_BLACKSTONE,
                Material.MAGMA_BLOCK,
                Material.GLOWSTONE,
                Material.CRIMSON_NYLIUM,
                Material.WARPED_NYLIUM,
                Material.NETHER_BRICKS,

                Material.ANCIENT_DEBRIS,

                /*
                 * =========================
                 * END
                 * =========================
                 */

                Material.END_STONE,
                Material.END_STONE_BRICKS,

                /*
                 * =========================
                 * CONSTRUCTION
                 * =========================
                 */

                Material.GLASS,
                Material.GLASS_PANE,
                Material.BRICKS,
                Material.BRICK_SLAB,
                Material.STONE_BRICKS,
                Material.CHISELED_STONE_BRICKS,

                Material.QUARTZ_BLOCK,
                Material.QUARTZ_BRICKS,

                Material.PRISMARINE,
                Material.PRISMARINE_BRICKS,
                Material.DARK_PRISMARINE,

                /*
                 * =========================
                 * DÉCORATION
                 * =========================
                 */

                Material.BOOKSHELF,
                Material.CHISELED_BOOKSHELF,
                Material.HAY_BLOCK,
                Material.TNT,
                Material.PUMPKIN,
                Material.JACK_O_LANTERN,
                Material.MELON,
                Material.BEE_NEST,
                Material.HONEYCOMB_BLOCK,
                Material.TARGET,

                /*
                 * =========================
                 * UTILITAIRES
                 * =========================
                 */

                Material.CRAFTING_TABLE,
                Material.FURNACE,
                Material.BLAST_FURNACE,
                Material.SMOKER,
                Material.ANVIL,
                Material.CHIPPED_ANVIL,
                Material.DAMAGED_ANVIL,

                Material.ENCHANTING_TABLE,
                Material.ENDER_CHEST,
                Material.BARREL,
                Material.LOOM,
                Material.CARTOGRAPHY_TABLE,
                Material.SMITHING_TABLE,
                Material.FLETCHING_TABLE,
                Material.GRINDSTONE,

                /*
                 * =========================
                 * REDSTONE
                 * =========================
                 */

                Material.OBSERVER,
                Material.PISTON,
                Material.STICKY_PISTON,
                Material.DISPENSER,
                Material.DROPPER,
                Material.NOTE_BLOCK,
                Material.JUKEBOX,
                Material.REPEATER,
                Material.COMPARATOR,
                Material.DAYLIGHT_DETECTOR,

                /*
                 * =========================
                 * BLOCS PLUS RARES
                 * =========================
                 */

                Material.OBSIDIAN,
                Material.CRYING_OBSIDIAN,

                Material.SCULK,
                Material.SCULK_CATALYST,
                Material.SCULK_SHRIEKER,

                Material.SEA_LANTERN,

                Material.SHROOMLIGHT,

                Material.SPONGE,
                Material.WET_SPONGE
        );

        /*
         * Choix aléatoire.
         */
        targetBlock = possibleBlocks.get(
                random.nextInt(possibleBlocks.size())
        );

        Bukkit.broadcastMessage(
                "§eBloc à casser :"
        );

        Bukkit.broadcastMessage(
                "§f"
                        + plugin.getTranslationManager()
                        .getBlockName(targetBlock)
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe Block Hunt est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le Block Hunt !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§eCassez : §f"
                        + plugin.getTranslationManager()
                        .getBlockName(targetBlock)
        );

        bossBar.setProgress(1.0);
    }

    /*
     * Getter du bloc cible.
     */
    public Material getTargetBlock() {

        return targetBlock;
    }
}