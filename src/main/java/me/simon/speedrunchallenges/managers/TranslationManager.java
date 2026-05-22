package me.simon.speedrunchallenges.managers;

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
}