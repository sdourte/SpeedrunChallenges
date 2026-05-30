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
             * PASSIFS
             * =========================
             */

            mobTranslations.put(EntityType.ALLAY, "Allay");
            mobTranslations.put(EntityType.ARMADILLO, "Tatou");
            mobTranslations.put(EntityType.AXOLOTL, "Axolotl");
            mobTranslations.put(EntityType.BAT, "Chauve-souris");
            mobTranslations.put(EntityType.CAMEL, "Chameau");
            mobTranslations.put(EntityType.CAT, "Chat");
            mobTranslations.put(EntityType.CHICKEN, "Poulet");
            mobTranslations.put(EntityType.COD, "Morue");
            mobTranslations.put(EntityType.COPPER_GOLEM, "Golem de cuivre");
            mobTranslations.put(EntityType.COW, "Vache");
            mobTranslations.put(EntityType.DONKEY, "Âne");
            mobTranslations.put(EntityType.FROG, "Grenouille");
            mobTranslations.put(EntityType.GLOW_SQUID, "Calamar lumineux");
            mobTranslations.put(EntityType.HAPPY_GHAST, "Ghast heureux");
            mobTranslations.put(EntityType.HORSE, "Cheval");
            mobTranslations.put(EntityType.MULE, "Mule");
            mobTranslations.put(EntityType.OCELOT, "Ocelot");
            mobTranslations.put(EntityType.PARROT, "Perroquet");
            mobTranslations.put(EntityType.PIG, "Cochon");
            mobTranslations.put(EntityType.RABBIT, "Lapin");
            mobTranslations.put(EntityType.SALMON, "Saumon");
            mobTranslations.put(EntityType.SHEEP, "Mouton");
            mobTranslations.put(EntityType.SNOW_GOLEM, "Golem de neige");
            mobTranslations.put(EntityType.SQUID, "Calamar");
            mobTranslations.put(EntityType.STRIDER, "Strider");
            mobTranslations.put(EntityType.TROPICAL_FISH, "Poisson tropical");
            mobTranslations.put(EntityType.TURTLE, "Tortue");
            mobTranslations.put(EntityType.VILLAGER, "Villageois");

            /*
             * =========================
             * NEUTRES
             * =========================
             */

            mobTranslations.put(EntityType.BEE, "Abeille");
            mobTranslations.put(EntityType.CAVE_SPIDER, "Araignée venimeuse");
            mobTranslations.put(EntityType.DOLPHIN, "Dauphin");
            mobTranslations.put(EntityType.DROWNED, "Noyé");
            mobTranslations.put(EntityType.ENDERMAN, "Enderman");
            mobTranslations.put(EntityType.FOX, "Renard");
            mobTranslations.put(EntityType.GOAT, "Chèvre");
            mobTranslations.put(EntityType.IRON_GOLEM, "Golem de fer");
            mobTranslations.put(EntityType.LLAMA, "Lama");
            mobTranslations.put(EntityType.NAUTILUS, "Nautilus");
            mobTranslations.put(EntityType.PANDA, "Panda");
            mobTranslations.put(EntityType.PIGLIN, "Piglin");
            mobTranslations.put(EntityType.POLAR_BEAR, "Ours polaire");
            mobTranslations.put(EntityType.PUFFERFISH, "Poisson-globe");
            mobTranslations.put(EntityType.SPIDER, "Araignée");
            mobTranslations.put(EntityType.WOLF, "Loup");

            /*
             * =========================
             * HOSTILES
             * =========================
             */

            mobTranslations.put(EntityType.BLAZE, "Blaze");
            mobTranslations.put(EntityType.BOGGED, "Bogged");
            mobTranslations.put(EntityType.BREEZE, "Breeze");
            mobTranslations.put(EntityType.CREAKING, "Creaking");
            mobTranslations.put(EntityType.CREEPER, "Creeper");
            mobTranslations.put(EntityType.ENDERMITE, "Endermite");
            mobTranslations.put(EntityType.GHAST, "Ghast");
            mobTranslations.put(EntityType.GUARDIAN, "Gardien");
            mobTranslations.put(EntityType.HOGLIN, "Hoglin");
            mobTranslations.put(EntityType.HUSK, "Husk (zombie désert)");
            mobTranslations.put(EntityType.MAGMA_CUBE, "Cube de magma");
            mobTranslations.put(EntityType.PARCHED, "Parched (squelette désert)");
            mobTranslations.put(EntityType.PILLAGER, "Pillard");
            mobTranslations.put(EntityType.SKELETON, "Squelette");
            mobTranslations.put(EntityType.SLIME, "Slime");
            mobTranslations.put(EntityType.STRAY, "Vagabond (squelette neige)");
            mobTranslations.put(EntityType.WITCH, "Sorcière");
            mobTranslations.put(EntityType.WITHER_SKELETON, "Wither squelette");
            mobTranslations.put(EntityType.ZOMBIE, "Zombie");
            mobTranslations.put(EntityType.ZOMBIE_VILLAGER, "Zombie villageois");
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

            case ACACIA_BUTTON -> "Bouton en acacia";
            case ACACIA_DOOR -> "Porte en acacia";
            case ACACIA_FENCE -> "Barrière en acacia";
            case ACACIA_FENCE_GATE -> "Portillon en acacia";
            case ACACIA_HANGING_SIGN -> "Panneau suspendu en acacia";
            case ACACIA_LEAVES -> "Feuilles d'acacia";
            case ACACIA_LOG -> "Bûche d'acacia";
            case ACACIA_PLANKS -> "Planches d'acacia";
            case ACACIA_PRESSURE_PLATE -> "Plaque de pression en acacia";
            case ACACIA_SAPLING -> "Pousse d'acacia";
            case ACACIA_SHELF -> "Étagère en acacia";
            case ACACIA_SIGN -> "Panneau en acacia";
            case ACACIA_SLAB -> "Dalle en acacia";
            case ACACIA_STAIRS -> "Escaliers en acacia";
            case ACACIA_TRAPDOOR -> "Trappe en acacia";
            case ACACIA_WOOD -> "Bois d'acacia";

            case ACTIVATOR_RAIL -> "Rail activateur";

            case ALLIUM -> "Allium";

            case ANDESITE -> "Andésite";
            case ANDESITE_SLAB -> "Dalle en andésite";
            case ANDESITE_STAIRS -> "Escaliers en andésite";
            case ANDESITE_WALL -> "Mur en andésite";

            case ANVIL -> "Enclume";

            case AZALEA -> "Azalée";
            case AZALEA_LEAVES -> "Feuilles d'azalée";

            case AZURE_BLUET -> "Houstonie bleue";

            case BAMBOO -> "Bambou";
            case BAMBOO_BUTTON -> "Bouton en bambou";
            case BAMBOO_DOOR -> "Porte en bambou";
            case BAMBOO_FENCE -> "Barrière en bambou";
            case BAMBOO_FENCE_GATE -> "Portillon en bambou";
            case BAMBOO_HANGING_SIGN -> "Panneau suspendu en bambou";
            case BAMBOO_MOSAIC -> "Mosaïque de bambou";
            case BAMBOO_MOSAIC_SLAB -> "Dalle en mosaïque de bambou";
            case BAMBOO_MOSAIC_STAIRS -> "Escaliers en mosaïque de bambou";
            case BAMBOO_PLANKS -> "Planches de bambou";
            case BAMBOO_PRESSURE_PLATE -> "Plaque de pression en bambou";
            case BAMBOO_SHELF -> "Étagère en bambou";
            case BAMBOO_SIGN -> "Panneau en bambou";
            case BAMBOO_SLAB -> "Dalle en bambou";
            case BAMBOO_STAIRS -> "Escaliers en bambou";
            case BAMBOO_TRAPDOOR -> "Trappe en bambou";

            case BARREL -> "Tonneau";

            case BASALT -> "Basalte";

            case BEE_NEST -> "Nid d'abeilles";
            case BEEHIVE -> "Ruche";

            case BEETROOTS -> "Betteraves";

            case BELL -> "Cloche";

            case BIG_DRIPLEAF -> "Grande dripleaf";

            case BIRCH_BUTTON -> "Bouton en bouleau";
            case BIRCH_DOOR -> "Porte en bouleau";
            case BIRCH_FENCE -> "Barrière en bouleau";
            case BIRCH_FENCE_GATE -> "Portillon en bouleau";
            case BIRCH_HANGING_SIGN -> "Panneau suspendu en bouleau";
            case BIRCH_LEAVES -> "Feuilles de bouleau";
            case BIRCH_LOG -> "Bûche de bouleau";
            case BIRCH_PLANKS -> "Planches de bouleau";
            case BIRCH_PRESSURE_PLATE -> "Plaque de pression en bouleau";
            case BIRCH_SAPLING -> "Pousse de bouleau";
            case BIRCH_SHELF -> "Étagère en bouleau";
            case BIRCH_SIGN -> "Panneau en bouleau";
            case BIRCH_SLAB -> "Dalle en bouleau";
            case BIRCH_STAIRS -> "Escaliers en bouleau";
            case BIRCH_TRAPDOOR -> "Trappe en bouleau";
            case BIRCH_WOOD -> "Bois de bouleau";

            case BLACK_BANNER -> "Bannière noire";
            case BLACK_BED -> "Lit noir";
            case BLACK_CANDLE -> "Bougie noire";
            case BLACK_CARPET -> "Tapis noir";
            case BLACK_CONCRETE -> "Béton noir";
            case BLACK_CONCRETE_POWDER -> "Poudre de béton noire";
            case BLACK_STAINED_GLASS -> "Verre teinté noir";
            case BLACK_STAINED_GLASS_PANE -> "Vitre teintée noire";
            case BLACK_TERRACOTTA -> "Terre cuite noire";
            case BLACK_WOOL -> "Laine noire";

            case BLACKSTONE -> "Pierre noire";
            case BLACKSTONE_SLAB -> "Dalle en pierre noire";
            case BLACKSTONE_STAIRS -> "Escaliers en pierre noire";
            case BLACKSTONE_WALL -> "Mur en pierre noire";

            case BLAST_FURNACE -> "Haut fourneau";

            case AMETHYST_BLOCK -> "Bloc d'améthyste";
            case BAMBOO_BLOCK -> "Bloc de bambou";
            case COAL_BLOCK -> "Bloc de charbon";
            case COPPER_BLOCK -> "Bloc de cuivre";
            case DIAMOND_BLOCK -> "Bloc de diamant";
            case EMERALD_BLOCK -> "Bloc d'émeraude";
            case GOLD_BLOCK -> "Bloc d'or";
            case IRON_BLOCK -> "Bloc de fer";
            case LAPIS_BLOCK -> "Bloc de lapis-lazuli";
            case QUARTZ_BLOCK -> "Bloc de quartz";
            case RAW_COPPER_BLOCK -> "Bloc de cuivre brut";
            case RAW_GOLD_BLOCK -> "Bloc d'or brut";
            case RAW_IRON_BLOCK -> "Bloc de fer brut";
            case REDSTONE_BLOCK -> "Bloc de redstone";
            case RESIN_BLOCK -> "Bloc de résine";
            case STRIPPED_BAMBOO_BLOCK -> "Bloc de bambou écorcé";

            case BLUE_BANNER -> "Bannière bleue";
            case BLUE_BED -> "Lit bleu";
            case BLUE_CANDLE -> "Bougie bleue";
            case BLUE_CARPET -> "Tapis bleu";
            case BLUE_CONCRETE -> "Béton bleu";
            case BLUE_CONCRETE_POWDER -> "Poudre de béton bleue";
            case BLUE_ICE -> "Glace bleue";
            case BLUE_ORCHID -> "Orchidée bleue";
            case BLUE_STAINED_GLASS -> "Verre teinté bleu";
            case BLUE_STAINED_GLASS_PANE -> "Vitre teintée bleue";
            case BLUE_TERRACOTTA -> "Terre cuite bleue";
            case BLUE_WOOL -> "Laine bleue";

            case BONE_BLOCK -> "Bloc d'os";

            case BOOKSHELF -> "Bibliothèque";

            case BRAIN_CORAL -> "Corail cerveau";
            case BRAIN_CORAL_BLOCK -> "Bloc de corail cerveau";
            case BRAIN_CORAL_FAN -> "Éventail de corail cerveau";

            case BREWING_STAND -> "Alambic";

            case BRICK_SLAB -> "Dalle en briques";
            case BRICK_STAIRS -> "Escaliers en briques";
            case BRICK_WALL -> "Mur en briques";
            case BRICKS -> "Briques";

            case BROWN_BANNER -> "Bannière marron";
            case BROWN_BED -> "Lit marron";
            case BROWN_CANDLE -> "Bougie marron";
            case BROWN_CARPET -> "Tapis marron";
            case BROWN_CONCRETE -> "Béton marron";
            case BROWN_CONCRETE_POWDER -> "Poudre de béton marron";
            case BROWN_MUSHROOM -> "Champignon brun";
            case BROWN_MUSHROOM_BLOCK -> "Bloc de champignon brun";
            case BROWN_STAINED_GLASS -> "Verre teinté marron";
            case BROWN_STAINED_GLASS_PANE -> "Vitre teintée marron";
            case BROWN_TERRACOTTA -> "Terre cuite marron";
            case BROWN_WOOL -> "Laine marron";

            case BUBBLE_CORAL -> "Corail bulle";
            case BUBBLE_CORAL_BLOCK -> "Bloc de corail bulle";
            case BUBBLE_CORAL_FAN -> "Éventail de corail bulle";

            case BUDDING_AMETHYST -> "Améthyste bourgeonnante";

            case BUSH -> "Buisson";

            case CACTUS -> "Cactus";
            case CACTUS_FLOWER -> "Fleur de cactus";
            case CAKE -> "Gâteau";
            case CALCITE -> "Calcite";
            case CALIBRATED_SCULK_SENSOR -> "Capteur sculk calibré";
            case CAMPFIRE -> "Feu de camp";
            case CANDLE -> "Bougie";
            case CARROTS -> "Carottes";
            case CARTOGRAPHY_TABLE -> "Table de cartographie";
            case CARVED_PUMPKIN -> "Citrouille sculptée";
            case CAULDRON -> "Chaudron";
            case CAVE_VINES -> "Lianes des cavernes";
            case CHEST -> "Coffre";

            case CHERRY_BUTTON -> "Bouton en cerisier";
            case CHERRY_DOOR -> "Porte en cerisier";
            case CHERRY_FENCE -> "Barrière en cerisier";
            case CHERRY_FENCE_GATE -> "Portillon en cerisier";
            case CHERRY_HANGING_SIGN -> "Panneau suspendu en cerisier";
            case CHERRY_LEAVES -> "Feuilles de cerisier";
            case CHERRY_LOG -> "Bûche de cerisier";
            case CHERRY_PLANKS -> "Planches de cerisier";
            case CHERRY_PRESSURE_PLATE -> "Plaque de pression en cerisier";
            case CHERRY_SAPLING -> "Pousse de cerisier";
            case CHERRY_SHELF -> "Étagère en cerisier";
            case CHERRY_SIGN -> "Panneau en cerisier";
            case CHERRY_SLAB -> "Dalle en cerisier";
            case CHERRY_STAIRS -> "Escaliers en cerisier";
            case CHERRY_TRAPDOOR -> "Trappe en cerisier";
            case CHERRY_WOOD -> "Bois de cerisier";

            case CHIPPED_ANVIL -> "Enclume ébréchée";

            case CHISELED_BOOKSHELF -> "Bibliothèque sculptée";
            case CHISELED_COPPER -> "Cuivre sculpté";
            case CHISELED_DEEPSLATE -> "Deepslate sculptée";
            case CHISELED_NETHER_BRICKS -> "Briques du Nether sculptées";
            case CHISELED_POLISHED_BLACKSTONE -> "Pierre noire polie sculptée";
            case CHISELED_QUARTZ_BLOCK -> "Bloc de quartz sculpté";
            case CHISELED_RED_SANDSTONE -> "Grès rouge sculpté";
            case CHISELED_RESIN_BRICKS -> "Briques de résine sculptées";
            case CHISELED_SANDSTONE -> "Grès sculpté";
            case CHISELED_STONE_BRICKS -> "Briques de pierre sculptées";
            case CHISELED_TUFF -> "Tuf sculpté";
            case CHISELED_TUFF_BRICKS -> "Briques de tuf sculptées";

            case CLAY -> "Argile";
            case CLOSED_EYEBLOSSOM -> "Œilfleur fermé";

            case COAL_ORE -> "Minerai de charbon";
            case COARSE_DIRT -> "Terre stérile";

            case COBBLED_DEEPSLATE -> "Deepslate taillée";
            case COBBLED_DEEPSLATE_SLAB -> "Dalle de deepslate taillée";
            case COBBLED_DEEPSLATE_STAIRS -> "Escaliers de deepslate taillée";
            case COBBLED_DEEPSLATE_WALL -> "Mur de deepslate taillée";

            case COBBLESTONE -> "Pierre taillée";
            case COBBLESTONE_SLAB -> "Dalle de pierre taillée";
            case COBBLESTONE_STAIRS -> "Escaliers de pierre taillée";
            case COBBLESTONE_WALL -> "Mur de pierre taillée";

            case COBWEB -> "Toile d'araignée";
            case COCOA -> "Cacao";
            case COMPOSTER -> "Composteur";

            case COPPER_BARS -> "Barres de cuivre";
            case COPPER_BULB -> "Ampoule en cuivre";
            case COPPER_CHAIN -> "Chaîne en cuivre";
            case COPPER_CHEST -> "Coffre en cuivre";
            case COPPER_DOOR -> "Porte en cuivre";
            case COPPER_GOLEM_STATUE -> "Statue de golem de cuivre";
            case COPPER_GRATE -> "Grille en cuivre";
            case COPPER_LANTERN -> "Lanterne en cuivre";
            case COPPER_ORE -> "Minerai de cuivre";
            case COPPER_TORCH -> "Torche en cuivre";
            case COPPER_TRAPDOOR -> "Trappe en cuivre";

            case CORNFLOWER -> "Bleuet";

            case CRACKED_DEEPSLATE_BRICKS -> "Briques de deepslate fissurées";
            case CRACKED_DEEPSLATE_TILES -> "Tuiles de deepslate fissurées";
            case CRACKED_NETHER_BRICKS -> "Briques du Nether fissurées";
            case CRACKED_POLISHED_BLACKSTONE_BRICKS -> "Briques de pierre noire polie fissurées";
            case CRACKED_STONE_BRICKS -> "Briques de pierre fissurées";

            case CRAFTER -> "Crafter";
            case CRAFTING_TABLE -> "Établi";

            case CREAKING_HEART -> "Cœur grinçant";

            case CRIMSON_BUTTON -> "Bouton carmin";
            case CRIMSON_DOOR -> "Porte carmin";
            case CRIMSON_FENCE -> "Barrière carmin";
            case CRIMSON_FENCE_GATE -> "Portillon carmin";
            case CRIMSON_FUNGUS -> "Champignon carmin";
            case CRIMSON_HANGING_SIGN -> "Panneau suspendu carmin";
            case CRIMSON_HYPHAE -> "Hyphes carmins";
            case CRIMSON_NYLIUM -> "Nylium carmin";
            case CRIMSON_PLANKS -> "Planches carmin";
            case CRIMSON_PRESSURE_PLATE -> "Plaque de pression carmin";
            case CRIMSON_ROOTS -> "Racines carmin";
            case CRIMSON_SHELF -> "Étagère carmin";
            case CRIMSON_SIGN -> "Panneau carmin";
            case CRIMSON_SLAB -> "Dalle carmin";
            case CRIMSON_STAIRS -> "Escaliers carmin";
            case CRIMSON_STEM -> "Tige carmin";
            case CRIMSON_TRAPDOOR -> "Trappe carmin";

            case CRYING_OBSIDIAN -> "Obsidienne pleureuse";

            case CUT_COPPER -> "Cuivre taillé";
            case CUT_COPPER_SLAB -> "Dalle en cuivre taillé";
            case CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé";

            case CUT_RED_SANDSTONE -> "Grès rouge taillé";
            case CUT_RED_SANDSTONE_SLAB -> "Dalle en grès rouge taillé";

            case CUT_SANDSTONE -> "Grès taillé";
            case CUT_SANDSTONE_SLAB -> "Dalle en grès taillé";

            case CYAN_BANNER -> "Bannière cyan";
            case CYAN_BED -> "Lit cyan";
            case CYAN_CANDLE -> "Bougie cyan";
            case CYAN_CARPET -> "Tapis cyan";
            case CYAN_CONCRETE -> "Béton cyan";
            case CYAN_CONCRETE_POWDER -> "Poudre de béton cyan";
            case CYAN_STAINED_GLASS -> "Verre teinté cyan";
            case CYAN_STAINED_GLASS_PANE -> "Vitre teintée cyan";
            case CYAN_TERRACOTTA -> "Terre cuite cyan";
            case CYAN_WOOL -> "Laine cyan";

            case DAMAGED_ANVIL -> "Enclume endommagée";

            case DANDELION -> "Pissenlit";

            case DARK_OAK_BUTTON -> "Bouton en chêne noir";
            case DARK_OAK_DOOR -> "Porte en chêne noir";
            case DARK_OAK_FENCE -> "Barrière en chêne noir";
            case DARK_OAK_FENCE_GATE -> "Portillon en chêne noir";
            case DARK_OAK_HANGING_SIGN -> "Panneau suspendu en chêne noir";
            case DARK_OAK_LEAVES -> "Feuilles de chêne noir";
            case DARK_OAK_LOG -> "Bûche de chêne noir";
            case DARK_OAK_PLANKS -> "Planches de chêne noir";
            case DARK_OAK_PRESSURE_PLATE -> "Plaque de pression en chêne noir";
            case DARK_OAK_SAPLING -> "Pousse de chêne noir";
            case DARK_OAK_SHELF -> "Étagère en chêne noir";
            case DARK_OAK_SIGN -> "Panneau en chêne noir";
            case DARK_OAK_SLAB -> "Dalle en chêne noir";
            case DARK_OAK_STAIRS -> "Escaliers en chêne noir";
            case DARK_OAK_TRAPDOOR -> "Trappe en chêne noir";
            case DARK_OAK_WOOD -> "Bois de chêne noir";

            case DARK_PRISMARINE -> "Prismarine sombre";
            case DARK_PRISMARINE_SLAB -> "Dalle de prismarine sombre";
            case DARK_PRISMARINE_STAIRS -> "Escaliers de prismarine sombre";

            case DAYLIGHT_DETECTOR -> "Détecteur de lumière";

            case DEAD_BUSH -> "Buisson mort";
            case DECORATED_POT -> "Pot décoré";

            case DEEPSLATE -> "Deepslate";

            case DEEPSLATE_BRICK_SLAB -> "Dalle en briques de deepslate";
            case DEEPSLATE_BRICK_STAIRS -> "Escaliers en briques de deepslate";
            case DEEPSLATE_BRICK_WALL -> "Mur en briques de deepslate";
            case DEEPSLATE_BRICKS -> "Briques de deepslate";

            case DEEPSLATE_COAL_ORE -> "Minerai de charbon des profondeurs";
            case DEEPSLATE_COPPER_ORE -> "Minerai de cuivre des profondeurs";
            case DEEPSLATE_DIAMOND_ORE -> "Minerai de diamant des profondeurs";
            case DEEPSLATE_EMERALD_ORE -> "Minerai d'émeraude des profondeurs";
            case DEEPSLATE_GOLD_ORE -> "Minerai d'or des profondeurs";
            case DEEPSLATE_IRON_ORE -> "Minerai de fer des profondeurs";
            case DEEPSLATE_LAPIS_ORE -> "Minerai de lapis des profondeurs";
            case DEEPSLATE_REDSTONE_ORE -> "Minerai de redstone des profondeurs";

            case DEEPSLATE_TILE_SLAB -> "Dalle en tuiles de deepslate";
            case DEEPSLATE_TILE_STAIRS -> "Escaliers en tuiles de deepslate";
            case DEEPSLATE_TILE_WALL -> "Mur en tuiles de deepslate";
            case DEEPSLATE_TILES -> "Tuiles de deepslate";

            case DETECTOR_RAIL -> "Rail détecteur";

            case DIAMOND_ORE -> "Minerai de diamant";

            case DIORITE -> "Diorite";
            case DIORITE_SLAB -> "Dalle en diorite";
            case DIORITE_STAIRS -> "Escaliers en diorite";
            case DIORITE_WALL -> "Mur en diorite";

            case DIRT -> "Terre";
            case DIRT_PATH -> "Chemin de terre";

            case DISPENSER -> "Distributeur";

            case DRIED_GHAST -> "Ghast séché";
            case DRIED_KELP_BLOCK -> "Bloc d'algues séchées";

            case DRIPSTONE_BLOCK -> "Bloc de dripstone";

            case DROPPER -> "Dropper";

            case EMERALD_ORE -> "Minerai d'émeraude";

            case ENCHANTING_TABLE -> "Table d'enchantement";

            case EXPOSED_CHISELED_COPPER -> "Cuivre sculpté exposé";
            case EXPOSED_COPPER -> "Cuivre exposé";
            case EXPOSED_COPPER_BARS -> "Barres de cuivre exposé";
            case EXPOSED_COPPER_BULB -> "Ampoule en cuivre exposé";
            case EXPOSED_COPPER_CHAIN -> "Chaîne en cuivre exposé";
            case EXPOSED_COPPER_CHEST -> "Coffre en cuivre exposé";
            case EXPOSED_COPPER_DOOR -> "Porte en cuivre exposé";
            case EXPOSED_COPPER_GOLEM_STATUE -> "Statue de golem de cuivre exposé";
            case EXPOSED_COPPER_GRATE -> "Grille en cuivre exposé";
            case EXPOSED_COPPER_LANTERN -> "Lanterne en cuivre exposé";
            case EXPOSED_COPPER_TRAPDOOR -> "Trappe en cuivre exposé";
            case EXPOSED_CUT_COPPER -> "Cuivre taillé exposé";
            case EXPOSED_CUT_COPPER_SLAB -> "Dalle en cuivre taillé exposé";
            case EXPOSED_CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé exposé";
            case EXPOSED_LIGHTNING_ROD -> "Paratonnerre exposé";

            case FARMLAND -> "Terre labourée";
            case FERN -> "Fougère";

            case FIRE_CORAL -> "Corail de feu";
            case FIRE_CORAL_BLOCK -> "Bloc de corail de feu";
            case FIRE_CORAL_FAN -> "Éventail de corail de feu";

            case FIREFLY_BUSH -> "Buisson à lucioles";

            case FLETCHING_TABLE -> "Table d'archerie";

            case FLOWER_POT -> "Pot de fleurs";

            case FLOWERING_AZALEA -> "Azalée fleurie";
            case FLOWERING_AZALEA_LEAVES -> "Feuilles d'azalée fleurie";

            case FROGSPAWN -> "Œufs de grenouille";

            case FROSTED_ICE -> "Glace givrée";

            case FURNACE -> "Four";

            case GILDED_BLACKSTONE -> "Pierre noire dorée";

            case GLASS -> "Verre";
            case GLASS_PANE -> "Vitre";

            case GLOW_ITEM_FRAME -> "Cadre lumineux";
            case GLOW_LICHEN -> "Lichen lumineux";
            case GLOWSTONE -> "Pierre lumineuse";

            case GOLD_ORE -> "Minerai d'or";

            case GRANITE -> "Granite";
            case GRANITE_SLAB -> "Dalle en granite";
            case GRANITE_STAIRS -> "Escaliers en granite";
            case GRANITE_WALL -> "Mur en granite";

            case GRASS_BLOCK -> "Bloc d'herbe";
            case GRAVEL -> "Gravier";

            case GRAY_BANNER -> "Bannière grise";
            case GRAY_BED -> "Lit gris";
            case GRAY_CANDLE -> "Bougie grise";
            case GRAY_CARPET -> "Tapis gris";
            case GRAY_CONCRETE -> "Béton gris";
            case GRAY_CONCRETE_POWDER -> "Poudre de béton grise";
            case GRAY_STAINED_GLASS -> "Verre teinté gris";
            case GRAY_STAINED_GLASS_PANE -> "Vitre teintée grise";
            case GRAY_TERRACOTTA -> "Terre cuite grise";
            case GRAY_WOOL -> "Laine grise";

            case GREEN_BANNER -> "Bannière verte";
            case GREEN_BED -> "Lit vert";
            case GREEN_CANDLE -> "Bougie verte";
            case GREEN_CARPET -> "Tapis vert";
            case GREEN_CONCRETE -> "Béton vert";
            case GREEN_CONCRETE_POWDER -> "Poudre de béton verte";
            case GREEN_STAINED_GLASS -> "Verre teinté vert";
            case GREEN_STAINED_GLASS_PANE -> "Vitre teintée verte";
            case GREEN_TERRACOTTA -> "Terre cuite verte";
            case GREEN_WOOL -> "Laine verte";

            case GRINDSTONE -> "Meule";

            case HANGING_ROOTS -> "Racines suspendues";

            case HAY_BLOCK -> "Botte de foin";

            case HEAVY_WEIGHTED_PRESSURE_PLATE -> "Plaque de pression lourde";

            case HONEY_BLOCK -> "Bloc de miel";
            case HONEYCOMB_BLOCK -> "Bloc de rayon de miel";

            case HOPPER -> "Entonnoir";

            case HORN_CORAL -> "Corail corne";
            case HORN_CORAL_BLOCK -> "Bloc de corail corne";
            case HORN_CORAL_FAN -> "Éventail de corail corne";

            case ICE -> "Glace";

            case ITEM_FRAME -> "Cadre";

            case IRON_BARS -> "Barreaux de fer";
            case IRON_CHAIN -> "Chaîne en fer";
            case IRON_DOOR -> "Porte en fer";
            case IRON_ORE -> "Minerai de fer";
            case IRON_TRAPDOOR -> "Trappe en fer";

            case JACK_O_LANTERN -> "Citrouille-lanterne";

            case JUKEBOX -> "Jukebox";

            case JUNGLE_BUTTON -> "Bouton de jungle";
            case JUNGLE_DOOR -> "Porte de jungle";
            case JUNGLE_FENCE -> "Barrière de jungle";
            case JUNGLE_FENCE_GATE -> "Portillon de jungle";
            case JUNGLE_HANGING_SIGN -> "Panneau suspendu de jungle";
            case JUNGLE_LEAVES -> "Feuilles de jungle";
            case JUNGLE_LOG -> "Bûche de jungle";
            case JUNGLE_PLANKS -> "Planches de jungle";
            case JUNGLE_PRESSURE_PLATE -> "Plaque de pression de jungle";
            case JUNGLE_SAPLING -> "Pousse de jungle";
            case JUNGLE_SHELF -> "Étagère de jungle";
            case JUNGLE_SIGN -> "Panneau de jungle";
            case JUNGLE_SLAB -> "Dalle de jungle";
            case JUNGLE_STAIRS -> "Escaliers de jungle";
            case JUNGLE_TRAPDOOR -> "Trappe de jungle";
            case JUNGLE_WOOD -> "Bois de jungle";

            case KELP -> "Algue";

            case LADDER -> "Échelle";

            case LANTERN -> "Lanterne";

            case LAPIS_ORE -> "Minerai de lapis-lazuli";

            case LARGE_FERN -> "Grande fougère";

            case LEAF_LITTER -> "Litière de feuilles";

            case LECTERN -> "Lutrin";

            case LEVER -> "Levier";

            case LIGHT_BLUE_BANNER -> "Bannière bleu clair";
            case LIGHT_BLUE_BED -> "Lit bleu clair";
            case LIGHT_BLUE_CANDLE -> "Bougie bleu clair";
            case LIGHT_BLUE_CARPET -> "Tapis bleu clair";
            case LIGHT_BLUE_CONCRETE -> "Béton bleu clair";
            case LIGHT_BLUE_CONCRETE_POWDER -> "Poudre de béton bleu clair";
            case LIGHT_BLUE_STAINED_GLASS -> "Verre teinté bleu clair";
            case LIGHT_BLUE_STAINED_GLASS_PANE -> "Vitre teintée bleu clair";
            case LIGHT_BLUE_TERRACOTTA -> "Terre cuite bleu clair";
            case LIGHT_BLUE_WOOL -> "Laine bleu clair";

            case LIGHT_GRAY_BANNER -> "Bannière gris clair";
            case LIGHT_GRAY_BED -> "Lit gris clair";
            case LIGHT_GRAY_CANDLE -> "Bougie gris clair";
            case LIGHT_GRAY_CARPET -> "Tapis gris clair";
            case LIGHT_GRAY_CONCRETE -> "Béton gris clair";
            case LIGHT_GRAY_CONCRETE_POWDER -> "Poudre de béton gris clair";
            case LIGHT_GRAY_STAINED_GLASS -> "Verre teinté gris clair";
            case LIGHT_GRAY_STAINED_GLASS_PANE -> "Vitre teintée gris clair";
            case LIGHT_GRAY_TERRACOTTA -> "Terre cuite gris clair";
            case LIGHT_GRAY_WOOL -> "Laine gris clair";

            case LIGHT_WEIGHTED_PRESSURE_PLATE -> "Plaque de pression légère";

            case LIGHTNING_ROD -> "Paratonnerre";

            case LILAC -> "Lilas";

            case LILY_OF_THE_VALLEY -> "Muguet";

            case LILY_PAD -> "Nénuphar";

            case LIME_BANNER -> "Bannière vert clair";
            case LIME_BED -> "Lit vert clair";
            case LIME_CANDLE -> "Bougie vert clair";
            case LIME_CARPET -> "Tapis vert clair";
            case LIME_CONCRETE -> "Béton vert clair";
            case LIME_CONCRETE_POWDER -> "Poudre de béton vert clair";
            case LIME_STAINED_GLASS -> "Verre teinté vert clair";
            case LIME_STAINED_GLASS_PANE -> "Vitre teintée vert clair";
            case LIME_TERRACOTTA -> "Terre cuite vert clair";
            case LIME_WOOL -> "Laine vert clair";

            case LODESTONE -> "Magnétite";

            case LOOM -> "Métier à tisser";

            case MAGENTA_BANNER -> "Bannière magenta";
            case MAGENTA_BED -> "Lit magenta";
            case MAGENTA_CANDLE -> "Bougie magenta";
            case MAGENTA_CARPET -> "Tapis magenta";
            case MAGENTA_CONCRETE -> "Béton magenta";
            case MAGENTA_CONCRETE_POWDER -> "Poudre de béton magenta";
            case MAGENTA_STAINED_GLASS -> "Verre teinté magenta";
            case MAGENTA_STAINED_GLASS_PANE -> "Vitre teintée magenta";
            case MAGENTA_TERRACOTTA -> "Terre cuite magenta";
            case MAGENTA_WOOL -> "Laine magenta";

            case MAGMA_BLOCK -> "Bloc de magma";

            case MANGROVE_BUTTON -> "Bouton en palétuvier";
            case MANGROVE_DOOR -> "Porte en palétuvier";
            case MANGROVE_FENCE -> "Barrière en palétuvier";
            case MANGROVE_FENCE_GATE -> "Portillon en palétuvier";
            case MANGROVE_HANGING_SIGN -> "Panneau suspendu en palétuvier";
            case MANGROVE_LEAVES -> "Feuilles de palétuvier";
            case MANGROVE_LOG -> "Bûche de palétuvier";
            case MANGROVE_PRESSURE_PLATE -> "Plaque de pression en palétuvier";
            case MANGROVE_PROPAGULE -> "Propagule de palétuvier";
            case MANGROVE_PLANKS -> "Planches de palétuvier";
            case MANGROVE_ROOTS -> "Racines de palétuvier";
            case MANGROVE_SHELF -> "Étagère en palétuvier";
            case MANGROVE_SIGN -> "Panneau en palétuvier";
            case MANGROVE_SLAB -> "Dalle en palétuvier";
            case MANGROVE_STAIRS -> "Escaliers en palétuvier";
            case MANGROVE_TRAPDOOR -> "Trappe en palétuvier";
            case MANGROVE_WOOD -> "Bois de palétuvier";

            case MELON -> "Pastèque";
            case MELON_STEM -> "Tige de pastèque";

            case MOSS_BLOCK -> "Bloc de mousse";
            case MOSS_CARPET -> "Tapis de mousse";

            case MOSSY_COBBLESTONE -> "Pierre taillée moussue";
            case MOSSY_COBBLESTONE_SLAB -> "Dalle de pierre taillée moussue";
            case MOSSY_COBBLESTONE_STAIRS -> "Escaliers de pierre taillée moussue";
            case MOSSY_COBBLESTONE_WALL -> "Mur de pierre taillée moussue";

            case MOSSY_STONE_BRICK_SLAB -> "Dalle en briques de pierre moussues";
            case MOSSY_STONE_BRICK_STAIRS -> "Escaliers en briques de pierre moussues";
            case MOSSY_STONE_BRICK_WALL -> "Mur en briques de pierre moussues";
            case MOSSY_STONE_BRICKS -> "Briques de pierre moussues";

            case MUD -> "Boue";

            case MUD_BRICK_SLAB -> "Dalle en briques de boue";
            case MUD_BRICK_STAIRS -> "Escaliers en briques de boue";
            case MUD_BRICK_WALL -> "Mur en briques de boue";
            case MUD_BRICKS -> "Briques de boue";

            case MUDDY_MANGROVE_ROOTS -> "Racines de palétuvier boueuses";

            case MUSHROOM_STEM -> "Pied de champignon";

            case NETHER_BRICK_FENCE -> "Barrière en briques du Nether";
            case NETHER_BRICK_SLAB -> "Dalle en briques du Nether";
            case NETHER_BRICK_STAIRS -> "Escaliers en briques du Nether";
            case NETHER_BRICK_WALL -> "Mur en briques du Nether";
            case NETHER_BRICKS -> "Briques du Nether";

            case NETHER_GOLD_ORE -> "Minerai d'or du Nether";
            case NETHER_QUARTZ_ORE -> "Minerai de quartz du Nether";

            case NETHER_SPROUTS -> "Pousses du Nether";
            case NETHER_WART -> "Verrue du Nether";
            case NETHER_WART_BLOCK -> "Bloc de verrues du Nether";

            case NETHERRACK -> "Netherrack";

            case NOTE_BLOCK -> "Bloc musical";

            case OAK_BUTTON -> "Bouton en chêne";
            case OAK_DOOR -> "Porte en chêne";
            case OAK_FENCE -> "Barrière en chêne";
            case OAK_FENCE_GATE -> "Portillon en chêne";
            case OAK_HANGING_SIGN -> "Panneau suspendu en chêne";
            case OAK_LEAVES -> "Feuilles de chêne";
            case OAK_LOG -> "Bûche de chêne";
            case OAK_PLANKS -> "Planches de chêne";
            case OAK_PRESSURE_PLATE -> "Plaque de pression en chêne";
            case OAK_SAPLING -> "Pousse de chêne";
            case OAK_SHELF -> "Étagère en chêne";
            case OAK_SIGN -> "Panneau en chêne";
            case OAK_SLAB -> "Dalle en chêne";
            case OAK_STAIRS -> "Escaliers en chêne";
            case OAK_TRAPDOOR -> "Trappe en chêne";
            case OAK_WOOD -> "Bois de chêne";

            case OBSERVER -> "Observateur";
            case OBSIDIAN -> "Obsidienne";

            case OPEN_EYEBLOSSOM -> "Œilfleur ouvert";

            case ORANGE_BANNER -> "Bannière orange";
            case ORANGE_BED -> "Lit orange";
            case ORANGE_CANDLE -> "Bougie orange";
            case ORANGE_CARPET -> "Tapis orange";
            case ORANGE_CONCRETE -> "Béton orange";
            case ORANGE_CONCRETE_POWDER -> "Poudre de béton orange";
            case ORANGE_STAINED_GLASS -> "Verre teinté orange";
            case ORANGE_STAINED_GLASS_PANE -> "Vitre teintée orange";
            case ORANGE_TERRACOTTA -> "Terre cuite orange";
            case ORANGE_TULIP -> "Tulipe orange";
            case ORANGE_WOOL -> "Laine orange";

            case OXEYE_DAISY -> "Marguerite";

            case OXIDIZED_CHISELED_COPPER -> "Cuivre sculpté oxydé";
            case OXIDIZED_COPPER -> "Cuivre oxydé";
            case OXIDIZED_COPPER_BARS -> "Barres de cuivre oxydé";
            case OXIDIZED_COPPER_BULB -> "Ampoule en cuivre oxydé";
            case OXIDIZED_COPPER_CHAIN -> "Chaîne en cuivre oxydé";
            case OXIDIZED_COPPER_CHEST -> "Coffre en cuivre oxydé";
            case OXIDIZED_COPPER_DOOR -> "Porte en cuivre oxydé";
            case OXIDIZED_COPPER_GOLEM_STATUE -> "Statue de golem de cuivre oxydé";
            case OXIDIZED_COPPER_GRATE -> "Grille en cuivre oxydé";
            case OXIDIZED_COPPER_LANTERN -> "Lanterne en cuivre oxydé";
            case OXIDIZED_COPPER_TRAPDOOR -> "Trappe en cuivre oxydé";
            case OXIDIZED_CUT_COPPER -> "Cuivre taillé oxydé";
            case OXIDIZED_CUT_COPPER_SLAB -> "Dalle en cuivre taillé oxydé";
            case OXIDIZED_CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé oxydé";
            case OXIDIZED_LIGHTNING_ROD -> "Paratonnerre oxydé";

            case PACKED_ICE -> "Glace compactée";
            case PACKED_MUD -> "Boue compactée";

            case PALE_HANGING_MOSS -> "Mousse pâle suspendue";
            case PALE_MOSS_BLOCK -> "Bloc de mousse pâle";
            case PALE_MOSS_CARPET -> "Tapis de mousse pâle";

            case PALE_OAK_BUTTON -> "Bouton en chêne pâle";
            case PALE_OAK_DOOR -> "Porte en chêne pâle";
            case PALE_OAK_FENCE -> "Barrière en chêne pâle";
            case PALE_OAK_FENCE_GATE -> "Portillon en chêne pâle";
            case PALE_OAK_HANGING_SIGN -> "Panneau suspendu en chêne pâle";
            case PALE_OAK_LEAVES -> "Feuilles de chêne pâle";
            case PALE_OAK_PLANKS -> "Planches de chêne pâle";
            case PALE_OAK_PRESSURE_PLATE -> "Plaque de pression en chêne pâle";
            case PALE_OAK_LOG -> "Bûche de chêne pâle";
            case PALE_OAK_SAPLING -> "Pousse de chêne pâle";
            case PALE_OAK_SHELF -> "Étagère en chêne pâle";
            case PALE_OAK_SIGN -> "Panneau en chêne pâle";
            case PALE_OAK_SLAB -> "Dalle en chêne pâle";
            case PALE_OAK_STAIRS -> "Escaliers en chêne pâle";
            case PALE_OAK_TRAPDOOR -> "Trappe en chêne pâle";
            case PALE_OAK_WOOD -> "Bois de chêne pâle";

            case PEONY -> "Pivoine";

            case PINK_BANNER -> "Bannière rose";
            case PINK_BED -> "Lit rose";
            case PINK_CANDLE -> "Bougie rose";
            case PINK_CARPET -> "Tapis rose";
            case PINK_CONCRETE -> "Béton rose";
            case PINK_CONCRETE_POWDER -> "Poudre de béton rose";
            case PINK_PETALS -> "Pétales roses";
            case PINK_STAINED_GLASS -> "Verre teinté rose";
            case PINK_STAINED_GLASS_PANE -> "Vitre teintée rose";
            case PINK_TERRACOTTA -> "Terre cuite rose";
            case PINK_TULIP -> "Tulipe rose";
            case PINK_WOOL -> "Laine rose";

            case PISTON -> "Piston";

            case PODZOL -> "Podzol";

            case POINTED_DRIPSTONE -> "Dripstone pointue";

            case POLISHED_ANDESITE -> "Andésite polie";
            case POLISHED_ANDESITE_SLAB -> "Dalle en andésite polie";
            case POLISHED_ANDESITE_STAIRS -> "Escaliers en andésite polie";

            case POLISHED_BASALT -> "Basalte poli";

            case POLISHED_BLACKSTONE -> "Pierre noire polie";
            case POLISHED_BLACKSTONE_BRICK_SLAB -> "Dalle en briques de pierre noire polie";
            case POLISHED_BLACKSTONE_BRICK_STAIRS -> "Escaliers en briques de pierre noire polie";
            case POLISHED_BLACKSTONE_BRICK_WALL -> "Mur en briques de pierre noire polie";
            case POLISHED_BLACKSTONE_BRICKS -> "Briques de pierre noire polie";
            case POLISHED_BLACKSTONE_BUTTON -> "Bouton en pierre noire polie";
            case POLISHED_BLACKSTONE_PRESSURE_PLATE -> "Plaque de pression en pierre noire polie";
            case POLISHED_BLACKSTONE_SLAB -> "Dalle en pierre noire polie";
            case POLISHED_BLACKSTONE_STAIRS -> "Escaliers en pierre noire polie";
            case POLISHED_BLACKSTONE_WALL -> "Mur en pierre noire polie";

            case POLISHED_DEEPSLATE -> "Deepslate polie";
            case POLISHED_DEEPSLATE_SLAB -> "Dalle en deepslate polie";
            case POLISHED_DEEPSLATE_STAIRS -> "Escaliers en deepslate polie";
            case POLISHED_DEEPSLATE_WALL -> "Mur en deepslate polie";

            case POLISHED_DIORITE -> "Diorite polie";
            case POLISHED_DIORITE_SLAB -> "Dalle en diorite polie";
            case POLISHED_DIORITE_STAIRS -> "Escaliers en diorite polie";

            case POLISHED_GRANITE -> "Granite poli";
            case POLISHED_GRANITE_SLAB -> "Dalle en granite poli";
            case POLISHED_GRANITE_STAIRS -> "Escaliers en granite poli";

            case POLISHED_TUFF -> "Tuf poli";
            case POLISHED_TUFF_SLAB -> "Dalle en tuf poli";
            case POLISHED_TUFF_STAIRS -> "Escaliers en tuf poli";
            case POLISHED_TUFF_WALL -> "Mur en tuf poli";

            case POPPY -> "Coquelicot";

            case POTATOES -> "Pommes de terre";

            case POWDER_SNOW -> "Neige poudreuse";

            case POWERED_RAIL -> "Rail de propulsion";

            case PRISMARINE -> "Prismarine";
            case PRISMARINE_BRICK_SLAB -> "Dalle en briques de prismarine";
            case PRISMARINE_BRICK_STAIRS -> "Escaliers en briques de prismarine";
            case PRISMARINE_BRICKS -> "Briques de prismarine";
            case PRISMARINE_SLAB -> "Dalle de prismarine";
            case PRISMARINE_STAIRS -> "Escaliers de prismarine";
            case PRISMARINE_WALL -> "Mur de prismarine";

            case PUMPKIN -> "Citrouille";
            case PUMPKIN_STEM -> "Tige de citrouille";

            case PURPLE_BANNER -> "Bannière violette";
            case PURPLE_BED -> "Lit violet";
            case PURPLE_CANDLE -> "Bougie violette";
            case PURPLE_CARPET -> "Tapis violet";
            case PURPLE_CONCRETE -> "Béton violet";
            case PURPLE_CONCRETE_POWDER -> "Poudre de béton violette";
            case PURPLE_STAINED_GLASS -> "Verre teinté violet";
            case PURPLE_STAINED_GLASS_PANE -> "Vitre teintée violette";
            case PURPLE_TERRACOTTA -> "Terre cuite violette";
            case PURPLE_WOOL -> "Laine violette";

            case PURPUR_BLOCK -> "Bloc de purpur";
            case PURPUR_PILLAR -> "Pilier de purpur";
            case PURPUR_SLAB -> "Dalle de purpur";
            case PURPUR_STAIRS -> "Escaliers de purpur";

            case QUARTZ_BRICKS -> "Briques de quartz";
            case QUARTZ_PILLAR -> "Pilier de quartz";
            case QUARTZ_SLAB -> "Dalle de quartz";
            case QUARTZ_STAIRS -> "Escaliers de quartz";

            case RAIL -> "Rail";

            case RED_BANNER -> "Bannière rouge";
            case RED_BED -> "Lit rouge";
            case RED_CANDLE -> "Bougie rouge";
            case RED_CARPET -> "Tapis rouge";
            case RED_CONCRETE -> "Béton rouge";
            case RED_CONCRETE_POWDER -> "Poudre de béton rouge";
            case RED_MUSHROOM -> "Champignon rouge";
            case RED_MUSHROOM_BLOCK -> "Bloc de champignon rouge";
            case RED_NETHER_BRICK_SLAB -> "Dalle en briques rouges du Nether";
            case RED_NETHER_BRICK_STAIRS -> "Escaliers en briques rouges du Nether";
            case RED_NETHER_BRICK_WALL -> "Mur en briques rouges du Nether";
            case RED_NETHER_BRICKS -> "Briques rouges du Nether";
            case RED_SAND -> "Sable rouge";
            case RED_SANDSTONE -> "Grès rouge";
            case RED_SANDSTONE_SLAB -> "Dalle en grès rouge";
            case RED_SANDSTONE_STAIRS -> "Escaliers en grès rouge";
            case RED_SANDSTONE_WALL -> "Mur en grès rouge";
            case RED_STAINED_GLASS -> "Verre teinté rouge";
            case RED_STAINED_GLASS_PANE -> "Vitre teintée rouge";
            case RED_TERRACOTTA -> "Terre cuite rouge";
            case RED_TULIP -> "Tulipe rouge";
            case RED_WOOL -> "Laine rouge";

            case COMPARATOR -> "Comparateur de redstone";
            case REDSTONE_LAMP -> "Lampe à redstone";
            case REDSTONE_ORE -> "Minerai de redstone";
            case REPEATER -> "Répéteur de redstone";
            case REDSTONE_TORCH -> "Torche de redstone";
            case REDSTONE_WIRE -> "Poussière de redstone";

            case RESIN_BRICK_SLAB -> "Dalle en briques de résine";
            case RESIN_BRICK_STAIRS -> "Escaliers en briques de résine";
            case RESIN_BRICK_WALL -> "Mur en briques de résine";
            case RESIN_BRICKS -> "Briques de résine";
            case RESIN_CLUMP -> "Amas de résine";

            case ROOTED_DIRT -> "Terre enracinée";

            case ROSE_BUSH -> "Rosier";

            case SAND -> "Sable";
            case SANDSTONE -> "Grès";
            case SANDSTONE_SLAB -> "Dalle en grès";
            case SANDSTONE_STAIRS -> "Escaliers en grès";
            case SANDSTONE_WALL -> "Mur en grès";

            case SCAFFOLDING -> "Échafaudage";

            case SCULK -> "Sculk";
            case SCULK_CATALYST -> "Catalyseur sculk";
            case SCULK_SENSOR -> "Capteur sculk";
            case SCULK_SHRIEKER -> "Hurleur sculk";
            case SCULK_VEIN -> "Veines de sculk";

            case SEA_LANTERN -> "Lanterne aquatique";
            case SEA_PICKLE -> "Cornichon de mer";
            case SEAGRASS -> "Herbes marines";

            case SHORT_DRY_GRASS -> "Herbe sèche courte";
            case SHORT_GRASS -> "Herbe courte";

            case SHROOMLIGHT -> "Champilampe";

            case SKELETON_SKULL -> "Crâne de squelette";

            case SLIME_BLOCK -> "Bloc de slime";

            case SMALL_AMETHYST_BUD -> "Petit bourgeon d'améthyste";

            case SMALL_DRIPLEAF -> "Petite dripleaf";

            case SMITHING_TABLE -> "Table de forge";
            case SMOKER -> "Fumoir";

            case SMOOTH_BASALT -> "Basalte lisse";

            case SMOOTH_QUARTZ -> "Quartz lisse";
            case SMOOTH_QUARTZ_SLAB -> "Dalle de quartz lisse";
            case SMOOTH_QUARTZ_STAIRS -> "Escaliers de quartz lisse";

            case SMOOTH_RED_SANDSTONE -> "Grès rouge lisse";
            case SMOOTH_RED_SANDSTONE_SLAB -> "Dalle de grès rouge lisse";
            case SMOOTH_RED_SANDSTONE_STAIRS -> "Escaliers de grès rouge lisse";

            case SMOOTH_SANDSTONE -> "Grès lisse";
            case SMOOTH_SANDSTONE_SLAB -> "Dalle de grès lisse";
            case SMOOTH_SANDSTONE_STAIRS -> "Escaliers de grès lisse";

            case SMOOTH_STONE -> "Pierre lisse";
            case SMOOTH_STONE_SLAB -> "Dalle de pierre lisse";

            case SNOW -> "Neige";
            case SNOW_BLOCK -> "Bloc de neige";

            case SOUL_CAMPFIRE -> "Feu de camp des âmes";
            case SOUL_FIRE -> "Feu des âmes";
            case SOUL_LANTERN -> "Lanterne des âmes";
            case SOUL_SAND -> "Sable des âmes";
            case SOUL_SOIL -> "Terre des âmes";
            case SOUL_TORCH -> "Torche des âmes";

            case SPONGE -> "Éponge";

            case SPORE_BLOSSOM -> "Fleur sporée";

            case SPRUCE_BUTTON -> "Bouton en sapin";
            case SPRUCE_DOOR -> "Porte en sapin";
            case SPRUCE_FENCE -> "Barrière en sapin";
            case SPRUCE_FENCE_GATE -> "Portillon en sapin";
            case SPRUCE_HANGING_SIGN -> "Panneau suspendu en sapin";
            case SPRUCE_LEAVES -> "Feuilles de sapin";
            case SPRUCE_LOG -> "Bûche de sapin";
            case SPRUCE_PLANKS -> "Planches de sapin";
            case SPRUCE_PRESSURE_PLATE -> "Plaque de pression en sapin";
            case SPRUCE_SAPLING -> "Pousse de sapin";
            case SPRUCE_SHELF -> "Étagère en sapin";
            case SPRUCE_SIGN -> "Panneau en sapin";
            case SPRUCE_SLAB -> "Dalle en sapin";
            case SPRUCE_STAIRS -> "Escaliers en sapin";
            case SPRUCE_TRAPDOOR -> "Trappe en sapin";
            case SPRUCE_WOOD -> "Bois de sapin";

            case STICKY_PISTON -> "Piston collant";

            case STONE -> "Pierre";

            case STONE_BRICK_SLAB -> "Dalle en briques de pierre";
            case STONE_BRICK_STAIRS -> "Escaliers en briques de pierre";
            case STONE_BRICK_WALL -> "Mur en briques de pierre";
            case STONE_BRICKS -> "Briques de pierre";

            case STONE_BUTTON -> "Bouton en pierre";
            case STONE_PRESSURE_PLATE -> "Plaque de pression en pierre";
            case STONE_SLAB -> "Dalle en pierre";
            case STONE_STAIRS -> "Escaliers en pierre";

            case STONECUTTER -> "Tailleur de pierre";

            case STRIPPED_ACACIA_LOG -> "Bûche d'acacia écorcée";
            case STRIPPED_ACACIA_WOOD -> "Bois d'acacia écorcé";

            case STRIPPED_BIRCH_LOG -> "Bûche de bouleau écorcée";
            case STRIPPED_BIRCH_WOOD -> "Bois de bouleau écorcé";

            case STRIPPED_CHERRY_LOG -> "Bûche de cerisier écorcée";
            case STRIPPED_CHERRY_WOOD -> "Bois de cerisier écorcé";

            case STRIPPED_CRIMSON_HYPHAE -> "Hyphes carmins écorcés";
            case STRIPPED_CRIMSON_STEM -> "Tige carmin écorcée";

            case STRIPPED_DARK_OAK_LOG -> "Bûche de chêne noir écorcée";
            case STRIPPED_DARK_OAK_WOOD -> "Bois de chêne noir écorcé";

            case STRIPPED_JUNGLE_LOG -> "Bûche de jungle écorcée";
            case STRIPPED_JUNGLE_WOOD -> "Bois de jungle écorcé";

            case STRIPPED_MANGROVE_LOG -> "Bûche de palétuvier écorcée";
            case STRIPPED_MANGROVE_WOOD -> "Bois de palétuvier écorcé";

            case STRIPPED_OAK_LOG -> "Bûche de chêne écorcée";
            case STRIPPED_OAK_WOOD -> "Bois de chêne écorcé";

            case STRIPPED_PALE_OAK_LOG -> "Bûche de chêne pâle écorcée";
            case STRIPPED_PALE_OAK_WOOD -> "Bois de chêne pâle écorcé";

            case STRIPPED_SPRUCE_LOG -> "Bûche de sapin écorcée";
            case STRIPPED_SPRUCE_WOOD -> "Bois de sapin écorcé";

            case STRIPPED_WARPED_HYPHAE -> "Hyphes biscornus écorcés";
            case STRIPPED_WARPED_STEM -> "Tige biscornue écorcée";

            case SUGAR_CANE -> "Canne à sucre";

            case SUNFLOWER -> "Tournesol";

            case SUSPICIOUS_GRAVEL -> "Gravier suspect";
            case SUSPICIOUS_SAND -> "Sable suspect";

            case SWEET_BERRY_BUSH -> "Buisson à baies sucrées";

            case TALL_DRY_GRASS -> "Grande herbe sèche";
            case TALL_GRASS -> "Grande herbe";
            case TALL_SEAGRASS -> "Grandes herbes marines";

            case TARGET -> "Cible";

            case TERRACOTTA -> "Terre cuite";

            case TINTED_GLASS -> "Verre teinté assombri";

            case TNT -> "TNT";

            case TORCH -> "Torche";

            case TRAPPED_CHEST -> "Coffre piégé";

            case TRIPWIRE -> "Fil de déclenchement";
            case TRIPWIRE_HOOK -> "Crochet de déclenchement";

            case TUBE_CORAL -> "Corail tube";
            case TUBE_CORAL_BLOCK -> "Bloc de corail tube";
            case TUBE_CORAL_FAN -> "Éventail de corail tube";

            case TUFF -> "Tuf";

            case TUFF_BRICK_SLAB -> "Dalle en briques de tuf";
            case TUFF_BRICK_STAIRS -> "Escaliers en briques de tuf";
            case TUFF_BRICK_WALL -> "Mur en briques de tuf";
            case TUFF_BRICKS -> "Briques de tuf";

            case TUFF_SLAB -> "Dalle en tuf";
            case TUFF_STAIRS -> "Escaliers en tuf";
            case TUFF_WALL -> "Mur en tuf";

            case TURTLE_EGG -> "Œuf de tortue";

            case TWISTING_VINES -> "Lianes tortueuses";

            case VAULT -> "Coffre-fort";

            case VERDANT_FROGLIGHT -> "Froglight verdoyante";

            case VINE -> "Lianes";

            case WARPED_BUTTON -> "Bouton biscornu";
            case WARPED_DOOR -> "Porte biscornue";
            case WARPED_FENCE -> "Barrière biscornue";
            case WARPED_FENCE_GATE -> "Portillon biscornu";
            case WARPED_FUNGUS -> "Champignon biscornu";
            case WARPED_HANGING_SIGN -> "Panneau suspendu biscornu";
            case WARPED_HYPHAE -> "Hyphes biscornus";
            case WARPED_NYLIUM -> "Nylium biscornu";
            case WARPED_PLANKS -> "Planches biscornues";
            case WARPED_PRESSURE_PLATE -> "Plaque de pression biscornue";
            case WARPED_ROOTS -> "Racines biscornues";
            case WARPED_SHELF -> "Étagère biscornue";
            case WARPED_SIGN -> "Panneau biscornu";
            case WARPED_SLAB -> "Dalle biscornue";
            case WARPED_STAIRS -> "Escaliers biscornus";
            case WARPED_STEM -> "Tige biscornue";
            case WARPED_TRAPDOOR -> "Trappe biscornue";
            case WARPED_WART_BLOCK -> "Bloc de verrues biscornues";

            case WAXED_COPPER_BLOCK -> "Bloc de cuivre ciré";
            case WAXED_CHISELED_COPPER -> "Cuivre sculpté ciré";
            case WAXED_COPPER_BARS -> "Barres de cuivre ciré";
            case WAXED_COPPER_BULB -> "Ampoule en cuivre ciré";
            case WAXED_COPPER_CHAIN -> "Chaîne en cuivre ciré";
            case WAXED_COPPER_CHEST -> "Coffre en cuivre ciré";
            case WAXED_COPPER_DOOR -> "Porte en cuivre ciré";
            case WAXED_COPPER_GOLEM_STATUE -> "Statue de golem de cuivre ciré";
            case WAXED_COPPER_GRATE -> "Grille en cuivre ciré";
            case WAXED_COPPER_LANTERN -> "Lanterne en cuivre ciré";
            case WAXED_COPPER_TRAPDOOR -> "Trappe en cuivre ciré";
            case WAXED_CUT_COPPER -> "Cuivre taillé ciré";
            case WAXED_CUT_COPPER_SLAB -> "Dalle en cuivre taillé ciré";
            case WAXED_CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé ciré";

            case WAXED_EXPOSED_CHISELED_COPPER -> "Cuivre sculpté exposé ciré";
            case WAXED_EXPOSED_COPPER -> "Cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_BARS -> "Barres de cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_BULB -> "Ampoule en cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_CHAIN -> "Chaîne en cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_CHEST -> "Coffre en cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_DOOR -> "Porte en cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_GOLEM_STATUE -> "Statue de golem de cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_GRATE -> "Grille en cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_LANTERN -> "Lanterne en cuivre exposé ciré";
            case WAXED_EXPOSED_COPPER_TRAPDOOR -> "Trappe en cuivre exposé ciré";
            case WAXED_EXPOSED_CUT_COPPER -> "Cuivre taillé exposé ciré";
            case WAXED_EXPOSED_CUT_COPPER_SLAB -> "Dalle en cuivre taillé exposé ciré";
            case WAXED_EXPOSED_CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé exposé ciré";
            case WAXED_EXPOSED_LIGHTNING_ROD -> "Paratonnerre exposé ciré";

            case WAXED_LIGHTNING_ROD -> "Paratonnerre ciré";

            case WAXED_OXIDIZED_CHISELED_COPPER -> "Cuivre sculpté oxydé ciré";
            case WAXED_OXIDIZED_COPPER -> "Cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_BARS -> "Barres de cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_BULB -> "Ampoule en cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_CHAIN -> "Chaîne en cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_CHEST -> "Coffre en cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_DOOR -> "Porte en cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_GOLEM_STATUE -> "Statue de golem de cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_GRATE -> "Grille en cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_LANTERN -> "Lanterne en cuivre oxydé ciré";
            case WAXED_OXIDIZED_COPPER_TRAPDOOR -> "Trappe en cuivre oxydé ciré";
            case WAXED_OXIDIZED_CUT_COPPER -> "Cuivre taillé oxydé ciré";
            case WAXED_OXIDIZED_CUT_COPPER_SLAB -> "Dalle en cuivre taillé oxydé ciré";
            case WAXED_OXIDIZED_CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé oxydé ciré";
            case WAXED_OXIDIZED_LIGHTNING_ROD -> "Paratonnerre oxydé ciré";

            case WAXED_WEATHERED_CHISELED_COPPER -> "Cuivre sculpté altéré ciré";
            case WAXED_WEATHERED_COPPER -> "Cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_BARS -> "Barres de cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_BULB -> "Ampoule en cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_CHAIN -> "Chaîne en cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_CHEST -> "Coffre en cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_DOOR -> "Porte en cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_GOLEM_STATUE -> "Statue de golem de cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_GRATE -> "Grille en cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_LANTERN -> "Lanterne en cuivre altéré ciré";
            case WAXED_WEATHERED_COPPER_TRAPDOOR -> "Trappe en cuivre altéré ciré";
            case WAXED_WEATHERED_CUT_COPPER -> "Cuivre taillé altéré ciré";
            case WAXED_WEATHERED_CUT_COPPER_SLAB -> "Dalle en cuivre taillé altéré ciré";
            case WAXED_WEATHERED_CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé altéré ciré";
            case WAXED_WEATHERED_LIGHTNING_ROD -> "Paratonnerre altéré ciré";

            case WEATHERED_CHISELED_COPPER -> "Cuivre sculpté altéré";
            case WEATHERED_COPPER -> "Cuivre altéré";
            case WEATHERED_COPPER_BARS -> "Barres de cuivre altéré";
            case WEATHERED_COPPER_BULB -> "Ampoule en cuivre altéré";
            case WEATHERED_COPPER_CHAIN -> "Chaîne en cuivre altéré";
            case WEATHERED_COPPER_CHEST -> "Coffre en cuivre altéré";
            case WEATHERED_COPPER_DOOR -> "Porte en cuivre altéré";
            case WEATHERED_COPPER_GOLEM_STATUE -> "Statue de golem de cuivre altéré";
            case WEATHERED_COPPER_GRATE -> "Grille en cuivre altéré";
            case WEATHERED_COPPER_LANTERN -> "Lanterne en cuivre altéré";
            case WEATHERED_COPPER_TRAPDOOR -> "Trappe en cuivre altéré";
            case WEATHERED_CUT_COPPER -> "Cuivre taillé altéré";
            case WEATHERED_CUT_COPPER_SLAB -> "Dalle en cuivre taillé altéré";
            case WEATHERED_CUT_COPPER_STAIRS -> "Escaliers en cuivre taillé altéré";
            case WEATHERED_LIGHTNING_ROD -> "Paratonnerre altéré";

            case WEEPING_VINES -> "Lianes pleureuses";

            case WET_SPONGE -> "Éponge mouillée";

            case WHEAT -> "Blé";

            case WHITE_BANNER -> "Bannière blanche";
            case WHITE_BED -> "Lit blanc";
            case WHITE_CANDLE -> "Bougie blanche";
            case WHITE_CARPET -> "Tapis blanc";
            case WHITE_CONCRETE -> "Béton blanc";
            case WHITE_CONCRETE_POWDER -> "Poudre de béton blanche";
            case WHITE_STAINED_GLASS -> "Verre teinté blanc";
            case WHITE_STAINED_GLASS_PANE -> "Vitre teintée blanche";
            case WHITE_TERRACOTTA -> "Terre cuite blanche";
            case WHITE_TULIP -> "Tulipe blanche";
            case WHITE_WOOL -> "Laine blanche";

            case WILDFLOWERS -> "Fleurs sauvages";

            case YELLOW_BANNER -> "Bannière jaune";
            case YELLOW_BED -> "Lit jaune";
            case YELLOW_CANDLE -> "Bougie jaune";
            case YELLOW_CARPET -> "Tapis jaune";
            case YELLOW_CONCRETE -> "Béton jaune";
            case YELLOW_CONCRETE_POWDER -> "Poudre de béton jaune";
            case YELLOW_STAINED_GLASS -> "Verre teinté jaune";
            case YELLOW_STAINED_GLASS_PANE -> "Vitre teintée jaune";
            case YELLOW_TERRACOTTA -> "Terre cuite jaune";
            case YELLOW_WOOL -> "Laine jaune";

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