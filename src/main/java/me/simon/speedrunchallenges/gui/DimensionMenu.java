package me.simon.speedrunchallenges.gui;

import org.bukkit.Bukkit;

import org.bukkit.Material;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.meta.ItemMeta;

public class DimensionMenu {

    /*
     * Création menu dimensions.
     */
    public static Inventory createMenu() {

        Inventory inventory = Bukkit.createInventory(
                null,
                9,
                "Choix dimension"
        );

        /*
         * Nether.
         */
        ItemStack netherItem =
                new ItemStack(Material.NETHERRACK);

        ItemMeta netherMeta =
                netherItem.getItemMeta();

        netherMeta.setDisplayName(
                "§cNether"
        );

        netherItem.setItemMeta(netherMeta);

        inventory.setItem(2, netherItem);

        /*
         * End.
         */
        ItemStack endItem =
                new ItemStack(Material.ENDER_EYE);

        ItemMeta endMeta =
                endItem.getItemMeta();

        endMeta.setDisplayName(
                "§5End"
        );

        endItem.setItemMeta(endMeta);

        inventory.setItem(4, endItem);

        /*
         * Random.
         */
        ItemStack randomItem =
                new ItemStack(Material.AMETHYST_SHARD);

        ItemMeta randomMeta =
                randomItem.getItemMeta();

        randomMeta.setDisplayName(
                "§bRandom"
        );

        randomItem.setItemMeta(randomMeta);

        inventory.setItem(6, randomItem);

        return inventory;
    }
}