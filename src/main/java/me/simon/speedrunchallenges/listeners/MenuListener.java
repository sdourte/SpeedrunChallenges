package me.simon.speedrunchallenges.listeners;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.*;

import me.simon.speedrunchallenges.game.GameState;

import me.simon.speedrunchallenges.gui.DimensionMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    public MenuListener(SpeedrunChallenges plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        /*
         * Vérifie les menus gérés.
         */
        if (!event.getView().getTitle().equals("Choix du challenge")
                // Pour Race Dimension
                && !event.getView().getTitle().equals("Choix dimension")) {

            return;
        }

        /*
         * Empêche de déplacer les items
         */
        event.setCancelled(true);

        /*
         * Vérifie qu'un item existe
         */
        if (event.getCurrentItem() == null) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        /*
         * Empêche de changer de challenge
         * pendant une partie.
         */
        if (plugin.getGameManager().getGameState() != GameState.WAITING) {

            player.sendMessage(
                    "§cImpossible de changer de challenge pendant une partie."
            );

            player.closeInventory();

            return;
        }

        /*
         * Diamond Challenge
         */
        if (event.getCurrentItem().getType() == Material.DIAMOND) {

            plugin.getGameManager().setActiveChallenge(
                    new DiamondChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aDiamond Challenge sélectionné !"
            );
        }

        /*
         * Mob Kill Challenge
         */
        else if (event.getCurrentItem().getType() == Material.IRON_SWORD) {

            plugin.getGameManager().setActiveChallenge(
                    new MobKillChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aMob Kill Challenge sélectionné !"
            );
        }

        /*
         * Any Mob Kill Challenge
         */
        else if (event.getCurrentItem().getType() == Material.DIAMOND_SWORD) {

            plugin.getGameManager().setActiveChallenge(
                    new AnyMobChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aAny Mob Kill Challenge sélectionné !"
            );
        }

        /*
         * Advancement Challenge
         */
        else if (event.getCurrentItem().getType() == Material.BOOK) {

            plugin.getGameManager().setActiveChallenge(
                    new AdvancementChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aAdvancement Challenge sélectionné !"
            );
        }

        /*
         * Death Swap
         */
        else if (event.getCurrentItem().getType() == Material.ENDER_PEARL) {

            /*
             * DeathSwap nécessite exactement 2 joueurs.
             */
            if (Bukkit.getOnlinePlayers().size() != 2) {

                player.sendMessage(
                        "§cLe DeathSwap nécessite exactement 2 joueurs."
                );

                player.closeInventory();

                return;
            }

            plugin.getGameManager().setActiveChallenge(
                    new DeathSwapChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aDeath Swap Challenge sélectionné !"
            );
        }

        /*
         * Death Challenge
         */
        else if (event.getCurrentItem().getType() == Material.SKELETON_SKULL) {

            plugin.getGameManager().setActiveChallenge(
                    new DeathChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aDeath Challenge sélectionné !"
            );
        }

        /*
         * Block Hunt Challenge
         */
        else if (event.getCurrentItem().getType() == Material.DIRT) {

            plugin.getGameManager().setActiveChallenge(
                    new BlockHuntChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aBlock Hunt Challenge sélectionné !"
            );
        }

        /*
         * Ore Challenge
         */
        else if (event.getCurrentItem().getType() == Material.DIAMOND_ORE) {

            plugin.getGameManager().setActiveChallenge(
                    new OreChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aOre Challenge sélectionné !"
            );
        }

        /*
         * Random Item Challenge
         */
        else if (event.getCurrentItem().getType() == Material.STICK) {

            plugin.getGameManager().setActiveChallenge(
                    new RandomItemChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aRandom Item Challenge sélectionné !"
            );
        }

        /*
         * XP Challenge
         */
        else if (event.getCurrentItem().getType() == Material.EXPERIENCE_BOTTLE) {

            plugin.getGameManager().setActiveChallenge(
                    new XPChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aXP Challenge sélectionné !"
            );
        }

        /*
         * Dimension Race Challenge
         */
        else if (event.getCurrentItem().getType()
                == Material.OBSIDIAN) {

            /*
             * Ouvre le sous-menu
             * de sélection dimension.
             */
            player.openInventory(
                    DimensionMenu.createMenu()
            );

            return;
        }

        /*
         * Menu dimensions (Dimension Race Challenge)
         */
        if (event.getView().getTitle()
                .equals("Choix dimension")) {

            event.setCancelled(true);

            if (event.getCurrentItem() == null) {
                return;
            }

            /*
             * Nether.
             */
            if (event.getCurrentItem().getType()
                    == Material.NETHERRACK) {

                plugin.getGameManager().setActiveChallenge(
                        new DimensionRaceChallenge(
                                plugin,
                                DimensionMode.NETHER
                        )
                );
            }

            /*
             * End.
             */
            else if (event.getCurrentItem().getType()
                    == Material.ENDER_EYE) {

                plugin.getGameManager().setActiveChallenge(
                        new DimensionRaceChallenge(
                                plugin,
                                DimensionMode.END
                        )
                );
            }

            /*
             * Random.
             */
            else if (event.getCurrentItem().getType()
                    == Material.AMETHYST_SHARD) {

                plugin.getGameManager().setActiveChallenge(
                        new DimensionRaceChallenge(
                                plugin,
                                DimensionMode.RANDOM
                        )
                );
            }

            player.closeInventory();

            plugin.getGameManager().startCountdown();

            return;
        }

        /*
         * Damage Challenge
         */
        else if (event.getCurrentItem().getType() == Material.CACTUS) {

            plugin.getGameManager().setActiveChallenge(
                    new DamageChallenge(plugin)
            );

            Bukkit.broadcastMessage(
                    "§aDamage Challenge sélectionné !"
            );
        }

        /*
         * Ferme le menu
         */
        player.closeInventory();

        /*
         * Lance la partie
         */
        // On vérifie qu'il y a au moins 1 joueur pour lancer le jeu
        if (!Bukkit.getOnlinePlayers().isEmpty()
                && plugin.getGameManager().getGameState() == GameState.WAITING) {

            plugin.getGameManager().startCountdown();
        }
    }
}