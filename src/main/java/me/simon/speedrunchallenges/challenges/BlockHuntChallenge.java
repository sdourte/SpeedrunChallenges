package me.simon.speedrunchallenges.challenges;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.boss.BossBar;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class BlockHuntChallenge implements Challenge {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Bloc cible
    private Material targetBlock;

    // Random
    private final Random random;

    public BlockHuntChallenge(SpeedrunChallenges plugin) {

        this.plugin = plugin;

        this.random = new Random();
    }

    @Override
    public String getName() {

        return "Block Hunt";
    }

    @Override
    public String getObjective() {

        return "Cassez un bloc aléatoire";
    }

    @Override
    public void start() {

        /*
         * Liste des blocs possibles.
         */
        List<Material> possibleBlocks = List.of(

                Material.OAK_LOG,
                Material.STONE,
                Material.COBBLESTONE,

                Material.COAL_ORE,
                Material.IRON_ORE,
                Material.GOLD_ORE,
                Material.REDSTONE_ORE,
                Material.LAPIS_ORE,
                Material.DIAMOND_ORE,
                Material.EMERALD_ORE,

                Material.OBSIDIAN,

                Material.GLASS,
                Material.BOOKSHELF,

                Material.HAY_BLOCK,

                Material.TNT,

                Material.NETHERRACK,
                Material.SOUL_SAND,

                Material.ANCIENT_DEBRIS
        );

        /*
         * Choix aléatoire.
         */
        targetBlock = possibleBlocks.get(
                random.nextInt(possibleBlocks.size())
        );

        Bukkit.broadcastMessage(
                "§eBloc à casser :"
        );

        Bukkit.broadcastMessage(
                "§f"
                        + plugin.getTranslationManager()
                        .getBlockName(targetBlock)
        );
    }

    @Override
    public void stop() {

        Bukkit.broadcastMessage(
                "§cLe Block Hunt est terminé."
        );
    }

    @Override
    public void win(Player player) {

        Bukkit.broadcastMessage(
                "§a"
                        + player.getName()
                        + " a gagné le Block Hunt !"
        );

        plugin.getGameManager().endGame(player);

        stop();
    }

    @Override
    public void setupBossBar(BossBar bossBar) {

        bossBar.setTitle(
                "§eCassez : §f"
                        + plugin.getTranslationManager()
                        .getBlockName(targetBlock)
        );

        bossBar.setProgress(1.0);
    }

    /*
     * Getter du bloc cible.
     */
    public Material getTargetBlock() {

        return targetBlock;
    }
}