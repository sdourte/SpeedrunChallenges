package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class OreChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Minerai cible
    private Material targetOre;

    // Random
    private final Random random;

    public OreChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {

        return "Ore Challenge";
    }

    @Override
    public String getObjective() {

        return "Minez un minerai aléatoire";
    }

    @Override
    public void start() {

        /*
         * Liste des minerais possibles.
         */
        List<Material> possibleOres = List.of(

                Material.COAL_ORE,

                Material.IRON_ORE,

                Material.COPPER_ORE,

                Material.GOLD_ORE,

                Material.REDSTONE_ORE,

                Material.LAPIS_ORE,

                Material.DIAMOND_ORE,

                Material.EMERALD_ORE,

                Material.NETHER_GOLD_ORE,

                Material.NETHER_QUARTZ_ORE
        );

        /*
         * Choix aléatoire.
         */
        targetOre = possibleOres.get(
                random.nextInt(possibleOres.size())
        );

        Bukkit.broadcastMessage(
                "§eMinerai à miner :"
        );

        Bukkit.broadcastMessage(
                "§f"
                        + plugin.getTranslationManager()
                        .getBlockName(targetOre)
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe Ore Challenge est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le Ore Challenge !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§6Minez : §f"
                        + plugin.getTranslationManager()
                        .getBlockName(targetOre)
        );

        bossBar.setProgress(1.0);
    }

    /*
     * Getter minerai cible.
     */
    public Material getTargetOre() {

        return targetOre;
    }
}