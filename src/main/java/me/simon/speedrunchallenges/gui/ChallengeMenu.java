package me.simon.speedrunchallenges.gui;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.entity.Player;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChallengeMenu {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public ChallengeMenu(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    /*
     * Ouvre le menu des challenges.
     */
    public void open(Player player) {

        /*
         * Création de l'inventaire.
         *
         * 9 = 1 ligne
         */
        Inventory inventory = Bukkit.createInventory(
                null,
                18,
                "Choix du challenge"
        );

        /*
         * Item Diamond Challenge
         */
        ItemStack diamondItem = new ItemStack(Material.DIAMOND);

        /*
         * Récupère les métadonnées de l'item
         */
        ItemMeta diamondMeta = diamondItem.getItemMeta();

        /*
         * Vérifie que les métadonnées existent
         */
        if (diamondMeta != null) {

            // Nom affiché dans la GUI
            diamondMeta.setDisplayName("§aDiamond Challenge");

            // Applique les modifications
            diamondItem.setItemMeta(diamondMeta);
        }

        /*
         * Item Mob Kill Challenge
         */
        ItemStack mobKillItem = new ItemStack(Material.IRON_SWORD);

        ItemMeta mobMeta = mobKillItem.getItemMeta();

        if (mobMeta != null) {

            mobMeta.setDisplayName("§bMob Kill Challenge");

            mobKillItem.setItemMeta(mobMeta);
        }

        /*
         * Item Mob Kill Challenge
         */
        ItemStack anyMobItem = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta anymobMeta = anyMobItem.getItemMeta();

        if (anymobMeta != null) {

            anymobMeta.setDisplayName("§cAny Mob Kill Challenge");

            anyMobItem.setItemMeta(anymobMeta);
        }

        /*
         * Advancement Challenge
         */
        ItemStack advancementItem = new ItemStack(Material.BOOK);

        ItemMeta advancementMeta = advancementItem.getItemMeta();

        if (advancementMeta != null) {

            advancementMeta.setDisplayName("§dAdvancement Challenge");

            advancementItem.setItemMeta(advancementMeta);
        }

        /*
         * Death Swap
         */
        ItemStack deathSwapItem = new ItemStack(Material.ENDER_PEARL);

        ItemMeta deathSwapMeta = deathSwapItem.getItemMeta();

        if (deathSwapMeta != null) {

            deathSwapMeta.setDisplayName("§eDeath Swap Challenge");

            deathSwapItem.setItemMeta(deathSwapMeta);
        }

        /*
         * Death Challenge
         */
        ItemStack deathChallengeItem = new ItemStack(Material.SKELETON_SKULL);

        ItemMeta deathChallengeMeta = deathChallengeItem.getItemMeta();

        if (deathChallengeMeta != null) {

            deathChallengeMeta.setDisplayName("§fDeath Challenge");

            deathChallengeItem.setItemMeta(deathChallengeMeta);
        }

        /*
         * Block Hunt Challenge
         */
        ItemStack blockHuntItem = new ItemStack(Material.DIRT);

        ItemMeta blockHuntMeta = blockHuntItem.getItemMeta();

        if (blockHuntMeta != null) {

            blockHuntMeta.setDisplayName("§aBlock Hunt Challenge");

            blockHuntItem.setItemMeta(blockHuntMeta);
        }

        /*
         * Ore Challenge
         */
        ItemStack oreChallengeItem = new ItemStack(Material.DIAMOND_ORE);

        ItemMeta oreChallengeMeta = oreChallengeItem.getItemMeta();

        if (oreChallengeMeta != null) {

            oreChallengeMeta.setDisplayName("§bOre Challenge");

            oreChallengeItem.setItemMeta(oreChallengeMeta);
        }

        /*
         * Random Item Challenge
         */
        ItemStack randomItemChallengeItem = new ItemStack(Material.STICK);

        ItemMeta randomItemChallengeMeta = randomItemChallengeItem.getItemMeta();

        if (randomItemChallengeMeta != null) {

            randomItemChallengeMeta.setDisplayName("§cRandom Item Challenge");

            randomItemChallengeItem.setItemMeta(randomItemChallengeMeta);
        }

        /*
         * XP Challenge
         */
        ItemStack xpChallengeItem = new ItemStack(Material.EXPERIENCE_BOTTLE);

        ItemMeta xpChallengeMeta = xpChallengeItem.getItemMeta();

        if (xpChallengeMeta != null) {

            xpChallengeMeta.setDisplayName("§dXP Challenge");

            xpChallengeItem.setItemMeta(xpChallengeMeta);
        }

        /*
         * Placement des items
         */
        inventory.setItem(0, diamondItem);
        inventory.setItem(1, mobKillItem);
        inventory.setItem(2, anyMobItem);
        inventory.setItem(3, advancementItem);
        inventory.setItem(4, deathSwapItem);
        inventory.setItem(5, deathChallengeItem);
        inventory.setItem(6, blockHuntItem);
        inventory.setItem(7, oreChallengeItem);
        inventory.setItem(8, randomItemChallengeItem);
        inventory.setItem(9, xpChallengeItem);

        /*
         * Ouvre le menu au joueur
         */
        player.openInventory(inventory);
    }
}