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
                    -> "Âge de pierre";

            case "minecraft:story/upgrade_tools"
                    -> "Une meilleure pioche";

            case "minecraft:story/smelt_iron"
                    -> "Acquisition de matériel";

            case "minecraft:story/obtain_armor"
                    -> "Protégez-vous";

            case "minecraft:story/lava_bucket"
                    -> "Chaud devant";

            case "minecraft:story/iron_tools"
                    -> "Ça coupe";

            case "minecraft:story/deflect_arrow"
                    -> "Pas aujourd'hui, merci";

            // Diamants / progression
            case "minecraft:story/mine_diamond"
                    -> "Diamants !";

            case "minecraft:story/shiny_gear"
                    -> "Couvert de diamants";

            case "minecraft:story/enchant_item"
                    -> "Enchanteur";

            // Nether
            case "minecraft:story/enter_the_nether"
                    -> "Direction le Nether";

            case "minecraft:nether/obtain_blaze_rod"
                    -> "Dans le feu";

            case "minecraft:nether/find_fortress"
                    -> "Une terrible forteresse";

            case "minecraft:nether/ride_strider"
                    -> "Promenade infernale";

            case "minecraft:nether/loot_bastion"
                    -> "Ces vestiges étaient les nôtres";

            // Exploration
            case "minecraft:adventure/sleep_in_bed"
                    -> "Bonne nuit";

            case "minecraft:adventure/trade"
                    -> "Commerce";

            case "minecraft:adventure/shoot_arrow"
                    -> "Tir de précision";

            case "minecraft:adventure/kill_a_mob"
                    -> "Monstre chasseur";

            // Farming / nourriture
            case "minecraft:husbandry/plant_seed"
                    -> "Un monde en croissance";

            case "minecraft:husbandry/breed_an_animal"
                    -> "Les perroquets et les chauves-souris";

            case "minecraft:husbandry/fishy_business"
                    -> "Poisson frais";

            case "minecraft:husbandry/tame_an_animal"
                    -> "Meilleur ami de l'homme";

            // Fun / variés
            case "minecraft:adventure/fall_from_world_height"
                    -> "Tomber de très haut";

            case "minecraft:adventure/honey_block_slide"
                    -> "Glissade sucrée";

            case "minecraft:adventure/root"
                    -> "L'aventure commence";

            // Spyglass
            case "minecraft:adventure/spyglass_at_parrot"
                    -> "Joli perroquet";

            case "minecraft:adventure/spyglass_at_ghast"
                    -> "Vision infernale";

            // Village
            case "minecraft:adventure/hero_of_the_village"
                    -> "Héros du village";

            // Cuisine / glow
            case "minecraft:husbandry/make_a_sign_glow"
                    -> "Signal lumineux";

            // Trident / orage
            case "minecraft:adventure/throw_trident"
                    -> "Lanceur de trident";

            case "minecraft:adventure/very_very_frightening"
                    -> "Très très effrayant";

            // Copper / lightning
            case "minecraft:adventure/lightning_rod_with_villager_no_fire"
                    -> "Protection contre la foudre";

            // Nether fun
            case "minecraft:nether/distract_piglin"
                    -> "Brillante distraction";

            // Powder snow
            case "minecraft:adventure/walk_on_powder_snow_with_leather_boots"
                    -> "Randonnée hivernale";

            default -> key;
        };
    }
}