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
    public String getRecordKey() {

        return "advancement:"
                + targetAdvancement.getKey().toString();
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

                // Story
                "minecraft:story/mine_stone",
                "minecraft:story/upgrade_tools",
                "minecraft:story/smelt_iron",
                "minecraft:story/obtain_armor",
                "minecraft:story/lava_bucket",
                "minecraft:story/iron_tools",
                "minecraft:story/deflect_arrow",
                "minecraft:story/form_obsidian",
                "minecraft:story/mine_diamond",
                "minecraft:story/shiny_gear",
                "minecraft:story/enchant_item",
                "minecraft:story/cure_zombie_villager",
                "minecraft:story/enter_the_nether",

                // Nether
                "minecraft:nether/return_to_sender",
                "minecraft:nether/obtain_blaze_rod",
                "minecraft:nether/find_fortress",
                "minecraft:nether/ride_strider",
                "minecraft:nether/loot_bastion",
                "minecraft:nether/obtain_crying_obsidian",
                "minecraft:nether/distract_piglin",

                // Adventure
                "minecraft:adventure/sleep_in_bed",
                "minecraft:adventure/trade",
                "minecraft:adventure/shoot_arrow",
                "minecraft:adventure/kill_a_mob",
                "minecraft:adventure/fall_from_world_height",
                "minecraft:adventure/honey_block_slide",
                "minecraft:adventure/voluntary_exile",
                "minecraft:adventure/spyglass_at_parrot",
                "minecraft:adventure/spyglass_at_ghast",
                "minecraft:adventure/throw_trident",
                "minecraft:adventure/walk_on_powder_snow_with_leather_boots",
                "minecraft:adventure/use_lodestone",
                "minecraft:adventure/read_power_of_chiseled_bookshelf",
                "minecraft:adventure/trim_with_any_armor_pattern",
                "minecraft:adventure/ol_betsy",
                "minecraft:adventure/salvage_sherd",
                "minecraft:adventure/avoid_vibration",
                "minecraft:adventure/kill_mob_near_sculk_catalyst",
                "minecraft:adventure/spear_many_mobs",
                "minecraft:adventure/summon_iron_golem",
                "minecraft:adventure/trade_at_world_height",
                "minecraft:adventure/whos_the_pillager_now",
                "minecraft:adventure/sniper_duel",
                "minecraft:adventure/bullseye",
                "minecraft:adventure/minecraft_trials_edition",
                "minecraft:adventure/crafters_crafting_crafters",
                "minecraft:adventure/brush_armadillo",

                // Husbandry
                "minecraft:husbandry/plant_seed",
                "minecraft:husbandry/breed_an_animal",
                "minecraft:husbandry/fishy_business",
                "minecraft:husbandry/tame_an_animal",
                "minecraft:husbandry/make_a_sign_glow",
                "minecraft:husbandry/play_jukebox_in_meadows",
                "minecraft:husbandry/place_dried_ghast_in_water",
                "minecraft:husbandry/safely_harvest_honey",
                "minecraft:husbandry/ride_a_boat_with_a_goat",
                "minecraft:husbandry/wax_on",
                "minecraft:husbandry/tactical_fishing",
                "minecraft:husbandry/wax_off",
                "minecraft:husbandry/axolotl_in_a_bucket",
                "minecraft:husbandry/repair_wolf_armor",
                "minecraft:husbandry/remove_wolf_armor"
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

            // Story
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

            case "minecraft:story/form_obsidian"
                    -> "Obtenez de l'obsidienne";

            case "minecraft:story/mine_diamond"
                    -> "Obtenez un diamant";

            case "minecraft:story/shiny_gear"
                    -> "Équipez une armure en diamant";

            case "minecraft:story/enchant_item"
                    -> "Enchantez un objet";

            case "minecraft:story/cure_zombie_villager"
                    -> "Soignez un zombie villageois";

            case "minecraft:story/enter_the_nether"
                    -> "Entrez dans le Nether";

            // Nether
            case "minecraft:nether/return_to_sender"
                    -> "Renvoyez une boule de feu à un ghast";

            case "minecraft:nether/obtain_blaze_rod"
                    -> "Obtenez un bâton de blaze";

            case "minecraft:nether/find_fortress"
                    -> "Trouvez une forteresse du Nether";

            case "minecraft:nether/ride_strider"
                    -> "Montez un strider";

            case "minecraft:nether/loot_bastion"
                    -> "Ouvrez un coffre de bastion";

            case "minecraft:nether/obtain_crying_obsidian"
                    -> "Obtenez de l'obsidienne pleureuse";

            case "minecraft:nether/distract_piglin"
                    -> "Distrayez un piglin avec de l'or";

            // Adventure
            case "minecraft:adventure/sleep_in_bed"
                    -> "Dormez dans un lit";

            case "minecraft:adventure/trade"
                    -> "Faites un échange avec un villageois";

            case "minecraft:adventure/shoot_arrow"
                    -> "Tirez une flèche";

            case "minecraft:adventure/kill_a_mob"
                    -> "Tuez une créature hostile";

            case "minecraft:adventure/fall_from_world_height"
                    -> "Tombez depuis une très grande hauteur";

            case "minecraft:adventure/honey_block_slide"
                    -> "Glissez sur un bloc de miel";

            case "minecraft:adventure/voluntary_exile"
                    -> "Tuez un capitaine pillard";

            case "minecraft:adventure/spyglass_at_parrot"
                    -> "Regardez un perroquet avec une longue-vue";

            case "minecraft:adventure/spyglass_at_ghast"
                    -> "Regardez un ghast avec une longue-vue";

            case "minecraft:adventure/throw_trident"
                    -> "Lancez un trident";

            case "minecraft:adventure/walk_on_powder_snow_with_leather_boots"
                    -> "Marchez sur de la neige poudreuse avec des bottes en cuir";

            case "minecraft:adventure/use_lodestone"
                    -> "Utilisez une pierre de magnétite";

            case "minecraft:adventure/read_power_of_chiseled_bookshelf"
                    -> "Lisez un comparateur sur une bibliothèque sculptée";

            case "minecraft:adventure/trim_with_any_armor_pattern"
                    -> "Personnalisez une armure avec un modèle";

            case "minecraft:adventure/ol_betsy"
                    -> "Tirez avec une arbalète";

            case "minecraft:adventure/salvage_sherd"
                    -> "Obtenez un tesson de poterie";

            case "minecraft:adventure/avoid_vibration"
                    -> "Évitez de déclencher un capteur sculk";

            case "minecraft:adventure/kill_mob_near_sculk_catalyst"
                    -> "Tuez une créature près d'un catalyseur sculk";

            case "minecraft:adventure/spear_many_mobs"
                    -> "Transpercez plusieurs créatures avec un trident";

            case "minecraft:adventure/summon_iron_golem"
                    -> "Invoquez un golem de fer";

            case "minecraft:adventure/trade_at_world_height"
                    -> "Échangez avec un villageois à la hauteur maximale";

            case "minecraft:adventure/whos_the_pillager_now"
                    -> "Désarmez un pillard avec une arbalète";

            case "minecraft:adventure/sniper_duel"
                    -> "Tuez un squelette à grande distance";

            case "minecraft:adventure/bullseye"
                    -> "Touchez le centre d'une cible";

            case "minecraft:adventure/minecraft_trials_edition"
                    -> "Terminez une chambre des épreuves";

            case "minecraft:adventure/crafters_crafting_crafters"
                    -> "Fabriquez un crafter avec un crafter";

            case "minecraft:adventure/brush_armadillo"
                    -> "Brossez un tatou";

            // Husbandry
            case "minecraft:husbandry/plant_seed"
                    -> "Plantez une graine";

            case "minecraft:husbandry/breed_an_animal"
                    -> "Faites se reproduire deux animaux";

            case "minecraft:husbandry/fishy_business"
                    -> "Attrapez un poisson";

            case "minecraft:husbandry/tame_an_animal"
                    -> "Apprivoisez un animal";

            case "minecraft:husbandry/make_a_sign_glow"
                    -> "Utilisez une poche d'encre lumineuse sur un panneau";

            case "minecraft:husbandry/play_jukebox_in_meadows"
                    -> "Faites jouer un jukebox dans une prairie";

            case "minecraft:husbandry/place_dried_ghast_in_water"
                    -> "Placez un ghast séché dans l'eau";

            case "minecraft:husbandry/safely_harvest_honey"
                    -> "Récoltez du miel sans énerver les abeilles";

            case "minecraft:husbandry/ride_a_boat_with_a_goat"
                    -> "Naviguez avec une chèvre dans un bateau";

            case "minecraft:husbandry/wax_on"
                    -> "Appliquez de la cire sur du cuivre";

            case "minecraft:husbandry/tactical_fishing"
                    -> "Attrapez un poisson avec un seau";

            case "minecraft:husbandry/wax_off"
                    -> "Retirez la cire d'un bloc de cuivre";

            case "minecraft:husbandry/axolotl_in_a_bucket"
                    -> "Capturez un axolotl dans un seau";

            case "minecraft:husbandry/repair_wolf_armor"
                    -> "Réparez une armure de loup";

            case "minecraft:husbandry/remove_wolf_armor"
                    -> "Retirez une armure de loup";

            default -> key;
        };
    }
}