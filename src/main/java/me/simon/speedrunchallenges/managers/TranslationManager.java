package me.simon.speedrunchallenges.managers;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class TranslationManager {

    // Traductions des mobs
    private final Map<EntityType, String> mobTranslations;

    public TranslationManager() {

        this.mobTranslations = new HashMap<>();

        loadTranslations();
    }

    /*
     * Charge les traductions FR.
     */
    private void loadTranslations() {

        /*
         * =========================
         * PASSIFS / FERME
         * =========================
         */

        mobTranslations.put(EntityType.PIG, "Cochon");
        mobTranslations.put(EntityType.COW, "Vache");
        mobTranslations.put(EntityType.SHEEP, "Mouton");
        mobTranslations.put(EntityType.CHICKEN, "Poulet");

        mobTranslations.put(EntityType.HORSE, "Cheval");
        mobTranslations.put(EntityType.DONKEY, "Âne");
        mobTranslations.put(EntityType.MULE, "Mule");

        mobTranslations.put(EntityType.GOAT, "Chèvre");
        mobTranslations.put(EntityType.RABBIT, "Lapin");

        mobTranslations.put(EntityType.CAMEL, "Chameau");

        mobTranslations.put(EntityType.LLAMA, "Lama");
        mobTranslations.put(EntityType.TRADER_LLAMA, "Lama du marchand");

        /*
         * =========================
         * VILLAGE / PNJ
         * =========================
         */

        mobTranslations.put(EntityType.VILLAGER, "Villageois");

        mobTranslations.put(EntityType.WANDERING_TRADER, "Marchand ambulant");

        /*
         * =========================
         * ANIMAUX SAUVAGES
         * =========================
         */

        mobTranslations.put(EntityType.WOLF, "Loup");

        mobTranslations.put(EntityType.FOX, "Renard");

        mobTranslations.put(EntityType.OCELOT, "Ocelot");

        mobTranslations.put(EntityType.CAT, "Chat");

        mobTranslations.put(EntityType.PARROT, "Perroquet");

        mobTranslations.put(EntityType.PANDA, "Panda");

        mobTranslations.put(EntityType.POLAR_BEAR, "Ours polaire");

        mobTranslations.put(EntityType.BEE, "Abeille");

        mobTranslations.put(EntityType.TURTLE, "Tortue");

        mobTranslations.put(EntityType.FROG, "Grenouille");

        mobTranslations.put(EntityType.AXOLOTL, "Axolotl");

        /*
         * =========================
         * AQUATIQUES
         * =========================
         */

        mobTranslations.put(EntityType.COD, "Morue");

        mobTranslations.put(EntityType.SALMON, "Saumon");

        mobTranslations.put(EntityType.PUFFERFISH, "Poisson-globe");

        mobTranslations.put(EntityType.TROPICAL_FISH, "Poisson tropical");

        mobTranslations.put(EntityType.SQUID, "Calamar");

        mobTranslations.put(EntityType.GLOW_SQUID, "Calamar lumineux");

        mobTranslations.put(EntityType.DOLPHIN, "Dauphin");

        /*
         * =========================
         * ZOMBIES
         * =========================
         */

        mobTranslations.put(EntityType.ZOMBIE, "Zombie");

        mobTranslations.put(EntityType.HUSK, "Husk (zombie désert)");

        mobTranslations.put(EntityType.DROWNED, "Noyé");

        mobTranslations.put(EntityType.ZOMBIE_VILLAGER, "Zombie villageois");

        /*
         * =========================
         * SQUELETTES
         * =========================
         */

        mobTranslations.put(EntityType.SKELETON, "Squelette");

        mobTranslations.put(EntityType.STRAY, "Vagabond (squelette neige)");

        mobTranslations.put(EntityType.WITHER_SKELETON, "Wither squelette");

        /*
         * =========================
         * HOSTILES CLASSIQUES
         * =========================
         */

        mobTranslations.put(EntityType.CREEPER, "Creeper");

        mobTranslations.put(EntityType.SPIDER, "Araignée");

        mobTranslations.put(EntityType.CAVE_SPIDER, "Araignée venimeuse");

        mobTranslations.put(EntityType.ENDERMAN, "Enderman");

        mobTranslations.put(EntityType.ENDERMITE, "Endermite");

        mobTranslations.put(EntityType.SLIME, "Slime");

        mobTranslations.put(EntityType.MAGMA_CUBE, "Cube de magma");

        mobTranslations.put(EntityType.WITCH, "Sorcière");

        mobTranslations.put(EntityType.SILVERFISH, "Poisson d'argent");

        /*
         * =========================
         * NETHER
         * =========================
         */

        mobTranslations.put(EntityType.BLAZE, "Blaze");

        mobTranslations.put(EntityType.GHAST, "Ghast");

        mobTranslations.put(EntityType.HOGLIN, "Hoglin");

        mobTranslations.put(EntityType.PIGLIN, "Piglin");

        /*
         * =========================
         * ILLAGERS
         * =========================
         */

        mobTranslations.put(EntityType.PILLAGER, "Pillard");

        mobTranslations.put(EntityType.VINDICATOR, "Vindicateur");

        /*
         * =========================
         * AQUATIQUES HOSTILES
         * =========================
         */

        mobTranslations.put(EntityType.GUARDIAN, "Gardien");

        mobTranslations.put(EntityType.ELDER_GUARDIAN, "Grand gardien");

        /*
         * =========================
         * DIVERS
         * =========================
         */

        mobTranslations.put(EntityType.IRON_GOLEM, "Golem de fer");

        mobTranslations.put(EntityType.SNOW_GOLEM, "Golem de neige");
    }

    /*
     * Retourne le nom FR d'un mob.
     */
    public String getMobName(EntityType entityType) {

        /*
         * Fallback si pas traduit.
         */
        return mobTranslations.getOrDefault(
                entityType,
                entityType.name()
        );
    }

    public String getBlockName(Material material) {

        return switch (material) {

            /*
             * =========================
             * BLOCS DE BASE
             * =========================
             */

            case STONE -> "Pierre";

            case COBBLESTONE -> "Pierre taillée";

            case MOSSY_COBBLESTONE -> "Pierre taillée moussue";

            case GRANITE -> "Granite";

            case DIORITE -> "Diorite";

            case ANDESITE -> "Andésite";

            case DEEPSLATE -> "Deepslate";

            case COBBLED_DEEPSLATE -> "Deepslate taillée";

            case TUFF -> "Tuf";

            case CALCITE -> "Calcite";

            case DRIPSTONE_BLOCK -> "Bloc de dripstone";

            /*
             * =========================
             * BOIS
             * =========================
             */

            case OAK_LOG -> "Bûche de chêne";

            case BIRCH_LOG -> "Bûche de bouleau";

            case SPRUCE_LOG -> "Bûche de sapin";

            case JUNGLE_LOG -> "Bûche de jungle";

            case ACACIA_LOG -> "Bûche d'acacia";

            case DARK_OAK_LOG -> "Bûche de chêne noir";

            case MANGROVE_LOG -> "Bûche de palétuvier";

            case CHERRY_LOG -> "Bûche de cerisier";

            case OAK_PLANKS -> "Planches de chêne";

            case BIRCH_PLANKS -> "Planches de bouleau";

            case SPRUCE_PLANKS -> "Planches de sapin";

            case JUNGLE_PLANKS -> "Planches de jungle";

            case ACACIA_PLANKS -> "Planches d'acacia";

            case DARK_OAK_PLANKS -> "Planches de chêne noir";

            case MANGROVE_PLANKS -> "Planches de palétuvier";

            case CHERRY_PLANKS -> "Planches de cerisier";

            /*
             * =========================
             * TERRE / NATURE
             * =========================
             */

            case DIRT -> "Terre";

            case GRASS_BLOCK -> "Bloc d'herbe";

            case COARSE_DIRT -> "Terre stérile";

            case PODZOL -> "Podzol";

            case CLAY -> "Argile";

            case GRAVEL -> "Gravier";

            case SAND -> "Sable";

            case RED_SAND -> "Sable rouge";

            case SNOW_BLOCK -> "Bloc de neige";

            case ICE -> "Glace";

            case PACKED_ICE -> "Glace compactée";

            case BLUE_ICE -> "Glace bleue";

            case MOSS_BLOCK -> "Bloc de mousse";

            /*
             * =========================
             * ORES
             * =========================
             */

            case COAL_ORE -> "Minerai de charbon";

            case IRON_ORE -> "Minerai de fer";

            case COPPER_ORE -> "Minerai de cuivre";

            case GOLD_ORE -> "Minerai d'or";

            case REDSTONE_ORE -> "Minerai de redstone";

            case LAPIS_ORE -> "Minerai de lapis";

            case DIAMOND_ORE -> "Minerai de diamant";

            case EMERALD_ORE -> "Minerai d'émeraude";

            case DEEPSLATE_COAL_ORE -> "Minerai de charbon des profondeurs";

            case DEEPSLATE_IRON_ORE -> "Minerai de fer des profondeurs";

            case DEEPSLATE_COPPER_ORE -> "Minerai de cuivre des profondeurs";

            case DEEPSLATE_GOLD_ORE -> "Minerai d'or des profondeurs";

            case DEEPSLATE_REDSTONE_ORE -> "Minerai de redstone des profondeurs";

            case DEEPSLATE_LAPIS_ORE -> "Minerai de lapis des profondeurs";

            case DEEPSLATE_DIAMOND_ORE -> "Minerai de diamant des profondeurs";

            case DEEPSLATE_EMERALD_ORE -> "Minerai d'émeraude des profondeurs";

            case NETHER_GOLD_ORE -> "Minerai d'or du Nether";

            case NETHER_QUARTZ_ORE -> "Minerai de quartz";

            /*
             * =========================
             * BLOCS PRÉCIEUX
             * =========================
             */

            case IRON_BLOCK -> "Bloc de fer";

            case GOLD_BLOCK -> "Bloc d'or";

            case DIAMOND_BLOCK -> "Bloc de diamant";

            case EMERALD_BLOCK -> "Bloc d'émeraude";

            case REDSTONE_BLOCK -> "Bloc de redstone";

            case LAPIS_BLOCK -> "Bloc de lapis";

            case COPPER_BLOCK -> "Bloc de cuivre";

            case AMETHYST_BLOCK -> "Bloc d'améthyste";

            /*
             * =========================
             * NETHER
             * =========================
             */

            case NETHERRACK -> "Netherrack";

            case SOUL_SAND -> "Sable des âmes";

            case SOUL_SOIL -> "Terre des âmes";

            case BASALT -> "Basalte";

            case BLACKSTONE -> "Pierre noire";

            case GILDED_BLACKSTONE -> "Pierre noire dorée";

            case MAGMA_BLOCK -> "Bloc de magma";

            case GLOWSTONE -> "Glowstone";

            case CRIMSON_NYLIUM -> "Nylium carmin";

            case WARPED_NYLIUM -> "Nylium biscornu";

            case NETHER_BRICKS -> "Briques du Nether";

            case ANCIENT_DEBRIS -> "Débris antiques";

            /*
             * =========================
             * END
             * =========================
             */

            case END_STONE -> "Pierre de l'End";

            case END_STONE_BRICKS -> "Briques de l'End";

            /*
             * =========================
             * CONSTRUCTION
             * =========================
             */

            case GLASS -> "Verre";

            case GLASS_PANE -> "Vitre";

            case BRICKS -> "Briques";

            case BRICK_SLAB -> "Dalle en briques";

            case STONE_BRICKS -> "Briques de pierre";

            case CHISELED_STONE_BRICKS -> "Briques de pierre sculptées";

            case QUARTZ_BLOCK -> "Bloc de quartz";

            case QUARTZ_BRICKS -> "Briques de quartz";

            case PRISMARINE -> "Prismarine";

            case PRISMARINE_BRICKS -> "Briques de prismarine";

            case DARK_PRISMARINE -> "Prismarine sombre";

            /*
             * =========================
             * DÉCORATION
             * =========================
             */

            case BOOKSHELF -> "Bibliothèque";

            case CHISELED_BOOKSHELF -> "Bibliothèque sculptée";

            case HAY_BLOCK -> "Botte de foin";

            case TNT -> "TNT";

            case PUMPKIN -> "Citrouille";

            case JACK_O_LANTERN -> "Citrouille-lanterne";

            case MELON -> "Pastèque";

            case BEE_NEST -> "Nid d'abeilles";

            case HONEYCOMB_BLOCK -> "Bloc de rayon de miel";

            case TARGET -> "Cible";

            /*
             * =========================
             * UTILITAIRES
             * =========================
             */

            case CRAFTING_TABLE -> "Établi";

            case FURNACE -> "Four";

            case BLAST_FURNACE -> "Haut fourneau";

            case SMOKER -> "Fumoir";

            case ANVIL -> "Enclume";

            case CHIPPED_ANVIL -> "Enclume ébréchée";

            case DAMAGED_ANVIL -> "Enclume endommagée";

            case ENCHANTING_TABLE -> "Table d'enchantement";

            case ENDER_CHEST -> "Coffre de l'End";

            case BARREL -> "Tonneau";

            case LOOM -> "Métier à tisser";

            case CARTOGRAPHY_TABLE -> "Table de cartographie";

            case SMITHING_TABLE -> "Table de forge";

            case FLETCHING_TABLE -> "Table d'archerie";

            case GRINDSTONE -> "Meule";

            /*
             * =========================
             * REDSTONE
             * =========================
             */

            case OBSERVER -> "Observateur";

            case PISTON -> "Piston";

            case STICKY_PISTON -> "Piston collant";

            case DISPENSER -> "Distributeur";

            case DROPPER -> "Dropper";

            case NOTE_BLOCK -> "Bloc musical";

            case JUKEBOX -> "Jukebox";

            case REPEATER -> "Répéteur";

            case COMPARATOR -> "Comparateur";

            case DAYLIGHT_DETECTOR -> "Détecteur de lumière";

            /*
             * =========================
             * BLOCS PLUS RARES
             * =========================
             */

            case OBSIDIAN -> "Obsidienne";

            case CRYING_OBSIDIAN -> "Obsidienne pleureuse";

            case SCULK -> "Sculk";

            case SCULK_CATALYST -> "Catalyseur sculk";

            case SCULK_SHRIEKER -> "Hurleur sculk";

            case SEA_LANTERN -> "Lanterne aquatique";

            case SHROOMLIGHT -> "Shroomlight";

            case SPONGE -> "Éponge";

            case WET_SPONGE -> "Éponge mouillée";

            default -> material.name();
        };
    }

    public String getItemName(Material material) {

        return switch (material) {

            /*
             * =========================
             * OUTILS / UTILITAIRES
             * =========================
             */

            case BUCKET -> "Seau";

            case WATER_BUCKET -> "Seau d'eau";

            case LAVA_BUCKET -> "Seau de lave";

            case COMPASS -> "Boussole";

            case CLOCK -> "Horloge";

            case SPYGLASS -> "Longue-vue";

            case SHEARS -> "Cisailles";

            case FLINT_AND_STEEL -> "Briquet";

            case LEAD -> "Laisse";

            case NAME_TAG -> "Étiquette";

            case SADDLE -> "Selle";

            case BRUSH -> "Pinceau";

            case WRITABLE_BOOK -> "Livre et plume";

            case BOOK -> "Livre";

            case BOOKSHELF -> "Bibliothèque";

            case MAP -> "Carte";

            case GLASS_BOTTLE -> "Fiole";

            /*
             * =========================
             * ARMES / COMBAT
             * =========================
             */

            case SHIELD -> "Bouclier";

            case BOW -> "Arc";

            case CROSSBOW -> "Arbalète";

            case ARROW -> "Flèche";

            case SPECTRAL_ARROW -> "Flèche spectrale";

            case TRIDENT -> "Trident";

            case TNT -> "TNT";

            case FIRE_CHARGE -> "Boule de feu";

            case END_CRYSTAL -> "Cristal de l'End";

            /*
             * =========================
             * REDSTONE
             * =========================
             */

            case OBSERVER -> "Observateur";

            case PISTON -> "Piston";

            case STICKY_PISTON -> "Piston collant";

            case REPEATER -> "Répéteur";

            case COMPARATOR -> "Comparateur";

            case DAYLIGHT_DETECTOR -> "Détecteur de lumière";

            case NOTE_BLOCK -> "Bloc musical";

            case JUKEBOX -> "Juke-box";

            case HOPPER -> "Entonnoir";

            case DROPPER -> "Dropper";

            case DISPENSER -> "Distributeur";

            case REDSTONE_LAMP -> "Lampe de redstone";

            case TARGET -> "Cible";

            case OAK_BUTTON -> "Bouton en chêne";

            case LEVER -> "Levier";

            case REDSTONE_TORCH -> "Torche de redstone";

            /*
             * =========================
             * TRANSPORT
             * =========================
             */

            case MINECART -> "Wagonnet";

            case CHEST_MINECART -> "Wagonnet avec coffre";

            case FURNACE_MINECART -> "Wagonnet avec four";

            case TNT_MINECART -> "Wagonnet avec TNT";

            case RAIL -> "Rails";

            case POWERED_RAIL -> "Rails de propulsion";

            case DETECTOR_RAIL -> "Rails détecteurs";

            case ACTIVATOR_RAIL -> "Rails activateurs";

            case OAK_BOAT -> "Bateau en chêne";

            case OAK_CHEST_BOAT -> "Bateau coffre en chêne";

            case SPRUCE_BOAT -> "Bateau en sapin";

            case BIRCH_BOAT -> "Bateau en bouleau";

            case ACACIA_BOAT -> "Bateau en acacia";

            case CHERRY_BOAT -> "Bateau en cerisier";

            case DARK_OAK_BOAT -> "Bateau en chêne noir";

            case JUNGLE_BOAT -> "Bateau en jungle";

            /*
             * =========================
             * BLOCS UTILITAIRES
             * =========================
             */

            case CAMPFIRE -> "Feu de camp";

            case BLAST_FURNACE -> "Haut fourneau";

            case SMOKER -> "Fumoir";

            case CARTOGRAPHY_TABLE -> "Table de cartographie";

            case FLETCHING_TABLE -> "Table d'archerie";

            case SMITHING_TABLE -> "Table de forge";

            case BREWING_STAND -> "Alambic";

            case ANVIL -> "Enclume";

            case CAULDRON -> "Chaudron";

            case LECTERN -> "Lutrin";

            case BARREL -> "Tonneau";

            case LOOM -> "Métier à tisser";

            case GRINDSTONE -> "Meule";

            case STONECUTTER -> "Tailleur de pierre";

            case ENCHANTING_TABLE -> "Table d'enchantement";

            case ENDER_CHEST -> "Coffre de l'End";

            /*
             * =========================
             * DÉCORATION
             * =========================
             */

            case LANTERN -> "Lanterne";

            case SOUL_LANTERN -> "Lanterne des âmes";

            case ITEM_FRAME -> "Cadre";

            case GLOW_ITEM_FRAME -> "Cadre lumineux";

            case PAINTING -> "Tableau";

            case ARMOR_STAND -> "Porte-armure";

            case FLOWER_POT -> "Pot de fleurs";

            case IRON_CHAIN -> "Chaîne";

            case IRON_BARS -> "Barreaux de fer";

            case BELL -> "Cloche";

            case CANDLE -> "Bougie";

            case SEA_LANTERN -> "Lanterne aquatique";

            /*
             * =========================
             * LITS / CONFORT
             * =========================
             */

            case RED_BED -> "Lit rouge";

            case BLUE_BED -> "Lit bleu";

            case GREEN_BED -> "Lit vert";

            case YELLOW_BED -> "Lit jaune";

            case BLACK_BED -> "Lit noir";

            case WHITE_BED -> "Lit blanc";

            case PURPLE_BED -> "Lit violet";

            case CYAN_BED -> "Lit cyan";

            /*
             * =========================
             * NOURRITURE
             * =========================
             */

            case CAKE -> "Gâteau";

            case GOLDEN_APPLE -> "Pomme dorée";

            case PUMPKIN_PIE -> "Tarte à la citrouille";

            case COOKIE -> "Cookie";

            case BREAD -> "Pain";

            case COOKED_BEEF -> "Steak";

            case COOKED_CHICKEN -> "Poulet cuit";

            case COOKED_PORKCHOP -> "Porc cuit";

            case COOKED_MUTTON -> "Mouton cuit";

            case COOKED_RABBIT -> "Lapin cuit";

            case RABBIT_STEW -> "Ragoût de lapin";

            case SUSPICIOUS_STEW -> "Ragoût suspect";

            case BEETROOT_SOUP -> "Soupe de betterave";

            case HONEY_BOTTLE -> "Bouteille de miel";

            case MUSHROOM_STEW -> "Soupe de champignons";

            case DRIED_KELP -> "Algues séchées";

            case GLOW_BERRIES -> "Baies lumineuses";

            /*
             * =========================
             * FARM / MOBS
             * =========================
             */

            case SLIME_BALL -> "Boule de slime";

            case STRING -> "Ficelle";

            case FEATHER -> "Plume";

            case LEATHER -> "Cuir";

            case EGG -> "Œuf";

            case INK_SAC -> "Poche d'encre";

            case GLOW_INK_SAC -> "Poche d'encre lumineuse";

            case GUNPOWDER -> "Poudre à canon";

            case BONE -> "Os";

            case BONE_MEAL -> "Poudre d'os";

            case ROTTEN_FLESH -> "Chair putréfiée";

            case SPIDER_EYE -> "Œil d'araignée";

            case FERMENTED_SPIDER_EYE -> "Œil d'araignée fermenté";

            case RABBIT_FOOT -> "Patte de lapin";

            case RABBIT_HIDE -> "Peau de lapin";

            case PRISMARINE_SHARD -> "Éclat de prismarine";

            case PRISMARINE_CRYSTALS -> "Cristaux de prismarine";

            case TURTLE_SCUTE -> "Écaille de tortue";

            case PUFFERFISH -> "Poisson-globe";

            /*
             * =========================
             * NETHER
             * =========================
             */

            case BLAZE_ROD -> "Bâton de blaze";

            case BLAZE_POWDER -> "Poudre de blaze";

            case GHAST_TEAR -> "Larme de ghast";

            case MAGMA_CREAM -> "Crème de magma";

            case NETHER_WART -> "Verrue du Nether";

            case QUARTZ -> "Quartz du Nether";

            case GLOWSTONE_DUST -> "Poudre lumineuse";

            case PIGLIN_BANNER_PATTERN -> "Motif de bannière piglin";

            case CRYING_OBSIDIAN -> "Obsidienne pleureuse";

            case SOUL_TORCH -> "Torche des âmes";

            case SOUL_CAMPFIRE -> "Feu de camp des âmes";

            /*
             * =========================
             * END / RARES
             * =========================
             */

            case ENDER_PEARL -> "Perle de l'End";

            case ENDER_EYE -> "Œil de l'Ender";

            case SHULKER_SHELL -> "Carapace de shulker";

            case CHORUS_FRUIT -> "Fruit de chorus";

            case DRAGON_BREATH -> "Souffle du dragon";

            case END_ROD -> "Barre de l'End";

            /*
             * =========================
             * LOOT / EXPLORATION
             * =========================
             */

            case NAUTILUS_SHELL -> "Coquille de nautile";

            case HEART_OF_THE_SEA -> "Cœur de la mer";

            case ENCHANTED_BOOK -> "Livre enchanté";

            case GOLDEN_HORSE_ARMOR -> "Armure en or pour cheval";

            case IRON_HORSE_ARMOR -> "Armure en fer pour cheval";

            case DIAMOND_HORSE_ARMOR -> "Armure en diamant pour cheval";

            case MUSIC_DISC_13 -> "Disque 13";

            case MUSIC_DISC_CAT -> "Disque Cat";

            case MUSIC_DISC_BLOCKS -> "Disque Blocks";

            case MUSIC_DISC_CHIRP -> "Disque Chirp";

            case MUSIC_DISC_FAR -> "Disque Far";

            case MUSIC_DISC_11 -> "Disque 11";

            case MUSIC_DISC_MALL -> "Disque Mall";

            case MUSIC_DISC_MELLOHI -> "Disque Mellohi";

            case MUSIC_DISC_STAL -> "Disque Stal";

            case MUSIC_DISC_STRAD -> "Disque Strad";

            case MUSIC_DISC_WARD -> "Disque Ward";

            case MUSIC_DISC_WAIT -> "Disque Wait";

            case MUSIC_DISC_OTHERSIDE -> "Disque Otherside";

            case MUSIC_DISC_PIGSTEP -> "Disque Pigstep";

            case ECHO_SHARD -> "Fragment d'écho";

            case OMINOUS_BOTTLE -> "Bouteille inquiétante";

            case TRIAL_KEY -> "Clé d'épreuve";

            case GOAT_HORN -> "Corne de chèvre";

            /*
             * =========================
             * RESSOURCES
             * =========================
             */

            case EMERALD -> "Émeraude";

            case DIAMOND -> "Diamant";

            case AMETHYST_SHARD -> "Éclat d'améthyste";

            case COPPER_INGOT -> "Lingot de cuivre";

            case IRON_INGOT -> "Lingot de fer";

            case GOLD_INGOT -> "Lingot d'or";

            case NETHERITE_SCRAP -> "Débris de netherite";

            case COAL -> "Charbon";

            case CHARCOAL -> "Charbon de bois";

            case LAPIS_LAZULI -> "Lapis-lazuli";

            case REDSTONE -> "Redstone";

            /*
             * =========================
             * PÊCHE / OCÉAN
             * =========================
             */

            case FISHING_ROD -> "Canne à pêche";

            case COD -> "Morue";

            case SALMON -> "Saumon";

            case TROPICAL_FISH -> "Poisson tropical";

            case PUFFERFISH_BUCKET -> "Seau avec poisson-globe";

            case TADPOLE_BUCKET -> "Seau avec têtard";

            /*
             * =========================
             * FUN / DIVERS
             * =========================
             */

            case FIREWORK_ROCKET -> "Fusée de feu d'artifice";

            case FIREWORK_STAR -> "Étoile de feu d'artifice";

            case SLIME_BLOCK -> "Bloc de slime";

            case HONEY_BLOCK -> "Bloc de miel";

            case TOTEM_OF_UNDYING -> "Totem d'immortalité";

            case WIND_CHARGE -> "Charge de vent";

            default -> material.name();
        };
    }
}