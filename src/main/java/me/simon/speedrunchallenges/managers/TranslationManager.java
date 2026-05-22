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

        // Passifs
        mobTranslations.put(EntityType.PIG, "Cochon");
        mobTranslations.put(EntityType.COW, "Vache");
        mobTranslations.put(EntityType.SHEEP, "Mouton");
        mobTranslations.put(EntityType.CHICKEN, "Poulet");
        mobTranslations.put(EntityType.HORSE, "Cheval");
        mobTranslations.put(EntityType.DONKEY, "Âne");
        mobTranslations.put(EntityType.MULE, "Mule");
        mobTranslations.put(EntityType.GOAT, "Chèvre");
        mobTranslations.put(EntityType.RABBIT, "Lapin");

        // Village
        mobTranslations.put(EntityType.VILLAGER, "Villageois");
        mobTranslations.put(EntityType.WANDERING_TRADER, "Marchand ambulant");

        // Sauvages
        mobTranslations.put(EntityType.WOLF, "Loup");
        mobTranslations.put(EntityType.FOX, "Renard");
        mobTranslations.put(EntityType.OCELOT, "Ocelot");
        mobTranslations.put(EntityType.CAT, "Chat");
        mobTranslations.put(EntityType.PARROT, "Perroquet");
        mobTranslations.put(EntityType.PANDA, "Panda");
        mobTranslations.put(EntityType.POLAR_BEAR, "Ours polaire");
        mobTranslations.put(EntityType.BEE, "Abeille");

        // Aquatiques
        mobTranslations.put(EntityType.COD, "Morue");
        mobTranslations.put(EntityType.SALMON, "Saumon");
        mobTranslations.put(EntityType.PUFFERFISH, "Poisson-globe");
        mobTranslations.put(EntityType.TROPICAL_FISH, "Poisson tropical");
        mobTranslations.put(EntityType.SQUID, "Calamar");
        mobTranslations.put(EntityType.DOLPHIN, "Dauphin");

        // Hostiles
        mobTranslations.put(EntityType.ZOMBIE, "Zombie");
        mobTranslations.put(EntityType.HUSK, "Husk");
        mobTranslations.put(EntityType.DROWNED, "Noyé");
        mobTranslations.put(EntityType.ZOMBIE_VILLAGER, "Zombie villageois");

        mobTranslations.put(EntityType.SKELETON, "Squelette");
        mobTranslations.put(EntityType.STRAY, "Vagabond");
        mobTranslations.put(EntityType.WITHER_SKELETON, "Wither squelette");

        mobTranslations.put(EntityType.CREEPER, "Creeper");
        mobTranslations.put(EntityType.SPIDER, "Araignée");
        mobTranslations.put(EntityType.CAVE_SPIDER, "Araignée venimeuse");

        mobTranslations.put(EntityType.ENDERMAN, "Enderman");
        mobTranslations.put(EntityType.ENDERMITE, "Endermite");

        mobTranslations.put(EntityType.SLIME, "Slime");
        mobTranslations.put(EntityType.MAGMA_CUBE, "Cube de magma");

        mobTranslations.put(EntityType.WITCH, "Sorcière");
        mobTranslations.put(EntityType.PHANTOM, "Phantom");
        mobTranslations.put(EntityType.SILVERFISH, "Poisson d'argent");

        // Nether
        mobTranslations.put(EntityType.BLAZE, "Blaze");
        mobTranslations.put(EntityType.GHAST, "Ghast");
        mobTranslations.put(EntityType.HOGLIN, "Hoglin");
        mobTranslations.put(EntityType.PIGLIN, "Piglin");
        mobTranslations.put(EntityType.ZOMBIFIED_PIGLIN, "Piglin zombifié");

        // Illagers
        mobTranslations.put(EntityType.PILLAGER, "Pillard");
        mobTranslations.put(EntityType.VINDICATOR, "Vindicateur");

        // Aquatiques hostiles
        mobTranslations.put(EntityType.GUARDIAN, "Gardien");
        mobTranslations.put(EntityType.ELDER_GUARDIAN, "Grand gardien");

        // Boss-lite / rares
        mobTranslations.put(EntityType.RAVAGER, "Ravageur");

        // Divers
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

            case OAK_LOG -> "Bûche de chêne";

            case STONE -> "Pierre";
            case COBBLESTONE -> "Pierre taillée";

            case COAL_ORE -> "Minerai de charbon";
            case IRON_ORE -> "Minerai de fer";
            case GOLD_ORE -> "Minerai d'or";

            case REDSTONE_ORE -> "Minerai de redstone";

            case LAPIS_ORE -> "Minerai de lapis";

            case DIAMOND_ORE -> "Minerai de diamant";

            case EMERALD_ORE -> "Minerai d'émeraude";

            case COPPER_ORE -> "Minerai de cuivre";

            case NETHER_GOLD_ORE -> "Minerai d'or du Nether";

            case NETHER_QUARTZ_ORE -> "Minerai de quartz";

            case OBSIDIAN -> "Obsidienne";

            case GLASS -> "Verre";

            case BOOKSHELF -> "Bibliothèque";

            case HAY_BLOCK -> "Botte de foin";

            case TNT -> "TNT";

            case NETHERRACK -> "Netherrack";

            case SOUL_SAND -> "Sable des âmes";

            case ANCIENT_DEBRIS -> "Débris antiques";

            case END_STONE -> "Pierre de l'End";

            default -> material.name();
        };
    }

    public String getItemName(Material material) {

        return switch (material) {

            /*
             * =========================
             * CRAFTABLES SIMPLES
             * =========================
             */

            case BUCKET -> "Seau";

            case COMPASS -> "Boussole";

            case CLOCK -> "Horloge";

            case SHIELD -> "Bouclier";

            case SHEARS -> "Cisailles";

            case RED_BED -> "Lit rouge";
            case BLUE_BED -> "Lit bleu";
            case GREEN_BED -> "Lit vert";
            case YELLOW_BED -> "Lit jaune";

            case TNT -> "TNT";

            case BOOKSHELF -> "Bibliothèque";

            case CROSSBOW -> "Arbalète";

            case BOW -> "Arc";

            case FISHING_ROD -> "Canne à pêche";

            case HOPPER -> "Entonnoir";

            case MINECART -> "Wagonnet";

            case LANTERN -> "Lanterne";

            case ITEM_FRAME -> "Cadre";

            case CAMPFIRE -> "Feu de camp";

            case BLAST_FURNACE -> "Haut fourneau";

            case SMOKER -> "Fumoir";

            case CARTOGRAPHY_TABLE -> "Table de cartographie";

            case FLETCHING_TABLE -> "Table d'archerie";

            case SMITHING_TABLE -> "Table de forge";

            case BREWING_STAND -> "Alambic";

            case ANVIL -> "Enclume";

            case CAULDRON -> "Chaudron";

            case OBSERVER -> "Observateur";

            case PISTON -> "Piston";

            case STICKY_PISTON -> "Piston collant";

            case REPEATER -> "Répéteur";

            case COMPARATOR -> "Comparateur";

            case DAYLIGHT_DETECTOR -> "Détecteur de lumière";

            case NOTE_BLOCK -> "Bloc musical";

            case JUKEBOX -> "Juke-box";

            case LECTERN -> "Lutrin";

            case BARREL -> "Tonneau";

            case IRON_CHAIN -> "Chaîne";

            case PAINTING -> "Tableau";

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

            case RABBIT_STEW -> "Ragoût de lapin";

            case SUSPICIOUS_STEW -> "Ragoût suspect";

            /*
             * =========================
             * LOOT / EXPLORATION
             * =========================
             */

            case SADDLE -> "Selle";

            case NAME_TAG -> "Étiquette";

            case ENDER_PEARL -> "Perle de l'End";

            case TRIDENT -> "Trident";

            case NAUTILUS_SHELL -> "Coquille de nautile";

            case HEART_OF_THE_SEA -> "Cœur de la mer";

            case MUSIC_DISC_13 -> "Disque 13";

            case MUSIC_DISC_CAT -> "Disque Cat";

            case ENCHANTED_BOOK -> "Livre enchanté";

            case GOLDEN_HORSE_ARMOR -> "Armure en or pour cheval";

            case DIAMOND_HORSE_ARMOR -> "Armure en diamant pour cheval";

            /*
             * =========================
             * NETHER
             * =========================
             */

            case BLAZE_ROD -> "Bâton de blaze";

            case GHAST_TEAR -> "Larme de ghast";

            case MAGMA_CREAM -> "Crème de magma";

            case NETHER_WART -> "Verrue du Nether";

            case QUARTZ -> "Quartz du Nether";

            case GLOWSTONE_DUST -> "Poudre lumineuse";

            /*
             * =========================
             * FARM / MOBS
             * =========================
             */

            case HONEY_BOTTLE -> "Bouteille de miel";

            case SLIME_BALL -> "Boule de slime";

            case STRING -> "Ficelle";

            case FEATHER -> "Plume";

            case LEATHER -> "Cuir";

            case EGG -> "Œuf";

            case INK_SAC -> "Poche d'encre";

            case GUNPOWDER -> "Poudre à canon";

            case BONE -> "Os";

            case ROTTEN_FLESH -> "Chair putréfiée";

            case SPIDER_EYE -> "Œil d'araignée";

            /*
             * =========================
             * RARES MAIS ACCESSIBLES
             * =========================
             */

            case EMERALD -> "Émeraude";

            case DIAMOND -> "Diamant";

            case AMETHYST_SHARD -> "Éclat d'améthyste";

            case PRISMARINE_CRYSTALS -> "Cristaux de prismarine";

            case ECHO_SHARD -> "Fragment d'écho";

            default -> material.name();
        };
    }
}