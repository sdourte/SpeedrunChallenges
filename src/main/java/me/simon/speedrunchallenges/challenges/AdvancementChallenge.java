package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;

import org.bukkit.advancement.Advancement;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvancementChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Advancement cible
    private Advancement targetAdvancement;

    // Random
    private final Random random;

    public AdvancementChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {
        return "Advancement Challenge";
    }

    @Override
    public String getObjective() {

        if (targetAdvancement == null) {
            return "Aucun advancement";
        }

        return getAdvancementName();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§eAvancement : §f"
                        + getAdvancementName()
        );

        bossBar.setProgress(1.0);
    }

    @Override
    public void start() {

        /*
         * Liste des advancements possibles.
         */
        List<String> advancements = List.of(

                // Début de jeu
                "minecraft:story/mine_stone",
                "minecraft:story/upgrade_tools",
                "minecraft:story/smelt_iron",
                "minecraft:story/obtain_armor",
                "minecraft:story/lava_bucket",
                "minecraft:story/iron_tools",
                "minecraft:story/deflect_arrow",

                // Diamants / progression
                "minecraft:story/mine_diamond",
                "minecraft:story/shiny_gear",
                "minecraft:story/enchant_item",

                // Nether
                "minecraft:story/enter_the_nether",
                "minecraft:nether/obtain_blaze_rod",
                "minecraft:nether/find_fortress",
                "minecraft:nether/ride_strider",
                "minecraft:nether/loot_bastion",

                // Exploration
                "minecraft:adventure/sleep_in_bed",
                "minecraft:adventure/trade",
                "minecraft:adventure/shoot_arrow",
                "minecraft:adventure/kill_a_mob",

                // Farming / nourriture
                "minecraft:husbandry/plant_seed",
                "minecraft:husbandry/breed_an_animal",
                "minecraft:husbandry/fishy_business",
                "minecraft:husbandry/tame_an_animal",

                // Fun / variés
                "minecraft:adventure/fall_from_world_height",
                "minecraft:adventure/honey_block_slide",
                "minecraft:adventure/root",

                // Divers
                "minecraft:adventure/spyglass_at_parrot",
                "minecraft:adventure/spyglass_at_ghast",

                // Village
                "minecraft:adventure/hero_of_the_village",

                // Cuisine
                "minecraft:husbandry/make_a_sign_glow",

                // Utilisation objets
                "minecraft:adventure/throw_trident",
                "minecraft:adventure/very_very_frightening",

                // Copper / récent
                "minecraft:adventure/lightning_rod_with_villager_no_fire",

                // Nether fun
                "minecraft:nether/distract_piglin",

                // Divers exploration
                "minecraft:adventure/walk_on_powder_snow_with_leather_boots"
        );
        /*
         * Choix aléatoire.
         */
        String chosen = advancements.get(
                random.nextInt(advancements.size())
        );

        /*
         * Récupération advancement Bukkit.
         */
        targetAdvancement = Bukkit.getAdvancement(
                org.bukkit.NamespacedKey.fromString(chosen)
        );

        Bukkit.broadcastMessage(
                "§ePremier à obtenir l'avancement :"
        );

        Bukkit.broadcastMessage(
                "§f" + getAdvancementName()
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
                        + " a gagné le Advancement Challenge !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    /*
     * Getter advancement cible.
     */
    public Advancement getTargetAdvancement() {
        return targetAdvancement;
    }

    /*
     * Nom affichable de l'advancement.
     */
    private String getAdvancementName() {

        if (targetAdvancement == null) {
            return "Inconnu";
        }

        /*
         * Simplification du nom.
         */
        String key = targetAdvancement.getKey().toString();

        return switch (key) {

            // Début de jeu
            case "minecraft:story/mine_stone"
                    -> "Cassez de la pierre avec une pioche";

            case "minecraft:story/upgrade_tools"
                    -> "Fabriquez une pioche en pierre";

            case "minecraft:story/smelt_iron"
                    -> "Faites fondre du fer";

            case "minecraft:story/obtain_armor"
                    -> "Équipez une armure en fer";

            case "minecraft:story/lava_bucket"
                    -> "Remplissez un seau de lave";

            case "minecraft:story/iron_tools"
                    -> "Fabriquez un outil en fer";

            case "minecraft:story/deflect_arrow"
                    -> "Bloquez une flèche avec un bouclier";

            // Diamants / progression
            case "minecraft:story/mine_diamond"
                    -> "Obtenez un diamant";

            case "minecraft:story/shiny_gear"
                    -> "Équipez une armure en diamant";

            case "minecraft:story/enchant_item"
                    -> "Enchantez un objet";

            // Nether
            case "minecraft:story/enter_the_nether"
                    -> "Entrez dans le Nether";

            case "minecraft:nether/obtain_blaze_rod"
                    -> "Obtenez un bâton de blaze";

            case "minecraft:nether/find_fortress"
                    -> "Trouvez une forteresse du Nether";

            case "minecraft:nether/ride_strider"
                    -> "Montez un strider";

            case "minecraft:nether/loot_bastion"
                    -> "Ouvrez un coffre de bastion";

            // Exploration
            case "minecraft:adventure/sleep_in_bed"
                    -> "Dormez dans un lit";

            case "minecraft:adventure/trade"
                    -> "Faites un échange avec un villageois";

            case "minecraft:adventure/shoot_arrow"
                    -> "Tirez une flèche";

            case "minecraft:adventure/kill_a_mob"
                    -> "Tuez une créature hostile";

            // Farming / nourriture
            case "minecraft:husbandry/plant_seed"
                    -> "Plantez une graine";

            case "minecraft:husbandry/breed_an_animal"
                    -> "Faites se reproduire deux animaux";

            case "minecraft:husbandry/fishy_business"
                    -> "Attrapez un poisson";

            case "minecraft:husbandry/tame_an_animal"
                    -> "Apprivoisez un animal";

            // Fun / variés
            case "minecraft:adventure/fall_from_world_height"
                    -> "Tombez depuis une très grande hauteur";

            case "minecraft:adventure/honey_block_slide"
                    -> "Glissez sur un bloc de miel";

            case "minecraft:adventure/root"
                    -> "Entrez dans l'onglet aventure";

            // Spyglass
            case "minecraft:adventure/spyglass_at_parrot"
                    -> "Regardez un perroquet avec une longue-vue";

            case "minecraft:adventure/spyglass_at_ghast"
                    -> "Regardez un ghast avec une longue-vue";

            // Village
            case "minecraft:adventure/hero_of_the_village"
                    -> "Obtenez l'effet Héros du village";

            // Cuisine / glow
            case "minecraft:husbandry/make_a_sign_glow"
                    -> "Utilisez une poche d'encre lumineuse sur un panneau";

            // Trident / orage
            case "minecraft:adventure/throw_trident"
                    -> "Lancez un trident";

            case "minecraft:adventure/very_very_frightening"
                    -> "Frappez un villageois avec la foudre";

            // Copper / lightning
            case "minecraft:adventure/lightning_rod_with_villager_no_fire"
                    -> "Protégez un villageois avec un paratonnerre";

            // Nether fun
            case "minecraft:nether/distract_piglin"
                    -> "Distrayez un piglin avec de l'or";

            // Powder snow
            case "minecraft:adventure/walk_on_powder_snow_with_leather_boots"
                    -> "Marchez sur de la neige poudreuse avec des bottes en cuir";

            default -> key;
        };
    }
}