package me.simon.speedrunchallenges;

import me.simon.speedrunchallenges.commands.*;
import me.simon.speedrunchallenges.game.GameManager;
import me.simon.speedrunchallenges.listeners.*;
import me.simon.speedrunchallenges.managers.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpeedrunChallenges extends JavaPlugin {

    // Gestionnaire principal du jeu
    private GameManager gameManager;

    // Getter
    public GameManager getGameManager() {
        return gameManager;
    }

    // Gestion des traductions
    private TranslationManager translationManager;

    // Getter des traductions
    public TranslationManager getTranslationManager() {
        return translationManager;
    }

    // Gestion de la téléportation aléatoire
    private TeleportManager teleportManager;

    // Getter de la téléportation
    public TeleportManager getTeleportManager() {
        return teleportManager;
    }

    // Lobby
    private LobbyManager lobbyManager;

    // Getter du lobby
    public LobbyManager getLobbyManager() {
        return lobbyManager;
    }

    // Scoreboard
    private ScoreboardManager scoreboardManager;

    // Getter du Scoreboard
    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    @Override
    public void onEnable() {

        // Création du GameManager
        this.gameManager = new GameManager(this);

        getLogger().info("Plugin activé !");

        // Création des traductions fr
        this.translationManager = new TranslationManager();

        // Création d'une téléportation random
        this.teleportManager = new TeleportManager(this);

        // Création d'un lobby
        this.lobbyManager = new LobbyManager(this);

        // Création du Scoreboard
        this.scoreboardManager = new ScoreboardManager(this);

        // Ajout des listeners
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new DiamondListener(this), this);
        getServer().getPluginManager().registerEvents(new MobKillListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
        getServer().getPluginManager().registerEvents(new LobbyProtectionListener(this), this);
        getServer().getPluginManager().registerEvents(new MoveListener(this), this);
        getServer().getPluginManager().registerEvents(new AnyMobListener(this), this);
        getServer().getPluginManager().registerEvents(new AdvancementListener(this), this);
        getServer().getPluginManager().registerEvents(new DeathSwapListener(this), this);
        getServer().getPluginManager().registerEvents(new DeathChallengeListener(this),this);
        getServer().getPluginManager().registerEvents(new PlayerDeathCountListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockHuntListener(this), this);
        getServer().getPluginManager().registerEvents(new OreChallengeListener(this), this);

        // Ajout des commandes
        getCommand("challenge").setExecutor(new ChallengeCommand(this));
        getCommand("setlobby").setExecutor(new SetLobbyCommand(this));
        getCommand("removelobby").setExecutor(new RemoveLobbyCommand(this));
        getCommand("stopchallenge").setExecutor(new StopChallengeCommand(this));
    }


    @Override
    public void onDisable() {

        getLogger().info("Plugin désactivé !");
    }

}