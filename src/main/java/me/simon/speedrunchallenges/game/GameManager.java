package me.simon.speedrunchallenges.game;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.challenges.Challenge;

import me.simon.speedrunchallenges.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;

import org.bukkit.scheduler.BukkitRunnable;

public class GameManager {

    // Référence vers le plugin principal
    private final SpeedrunChallenges plugin;

    // Etat actuel du jeu
    private GameState gameState;

    // Spawnpoint de chaque joueur
    private final Map<UUID, Location> playerSpawnLocations = new HashMap<>();

    /*
     * Définit le spawnpoint
     * personnel d'un joueur.
     */
    public void setPlayerSpawn(
            Player player,
            Location location
    ) {

        playerSpawnLocations.put(
                player.getUniqueId(),
                location
        );
    }

    /*
     * Retourne le spawnpoint
     * personnel du joueur.
     */
    public Location getPlayerSpawn(
            Player player
    ) {

        return playerSpawnLocations.get(
                player.getUniqueId()
        );
    }

    // BossBar du challenge
    private BossBar bossBar;

    // Getter BossBar
    public BossBar getBossBar() {
        return bossBar;
    }

    // Temps écoulé pendant la partie
    private int gameTime;

    // Challenge actuellement sélectionné
    private Challenge activeChallenge;

    // Nombre de morts des joueurs
    private final Map<Player, Integer> playerDeaths = new HashMap<>();

    // Getter de morts
    public int getPlayerDeaths(Player player) {

        return playerDeaths.getOrDefault(player, 0);
    }

    // Ajouter une mort
    public void addDeath(Player player) {

        playerDeaths.put(
                player,
                getPlayerDeaths(player) + 1
        );
    }

    // Constructeur
    public GameManager(SpeedrunChallenges plugin) {

        // Sauvegarde du plugin
        this.plugin = plugin;

        // Etat initial du jeu
        this.gameState = GameState.WAITING;

        // Temps initial
        this.gameTime = 0;

        // Aucun challenge sélectionné au départ
        this.activeChallenge = null;
    }

    /*
     * Getter de l'état du jeu
     */
    public GameState getGameState() {
        return gameState;
    }

    /*
     * Setter de l'état du jeu
     */
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    /*
     * Getter du challenge actif
     */
    public Challenge getActiveChallenge() {
        return activeChallenge;
    }

    /*
     * Setter du challenge actif
     */
    public void setActiveChallenge(Challenge challenge) {
        this.activeChallenge = challenge;
    }

    /*
     * Getter du temps de partie
     */
    public int getGameTime() {
        return gameTime;
    }

    /*
     * Lance le countdown avant le début de partie
     */
    public void startCountdown() {

        // Passage en phase STARTING
        this.gameState = GameState.STARTING;

        // Téléportation aléatoire des joueurs avec le compte à rebours
        for (Player player : Bukkit.getOnlinePlayers()) {

            plugin.getTeleportManager()
                    .teleportRandom(player);
        }

        /*
         * Reset des joueurs
         * avant la partie.
         * --> On le place ici pour éviter qu'un joueur ne drop un item durant le countdown pour le récupérer après
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            // Vide inventaire
            player.getInventory().clear();

            // Retire armure
            player.getInventory().setArmorContents(null);

            // Vie max
            player.setHealth(20.0);

            // Nourriture max
            player.setFoodLevel(20);

            // Saturation
            player.setSaturation(10);

            // Expérience reset
            player.setExp(0);

            player.setLevel(0);

            // Enlève les effets
            player.getActivePotionEffects()
                    .forEach(effect ->
                            player.removePotionEffect(
                                    effect.getType()
                            )
                    );

            // Éteint le feu
            player.setFireTicks(0);
        }

        // Compte à rebours à 15 secondes
        final int[] countdown = {15};

        new BukkitRunnable() {

            @Override
            public void run() {

                /*
                 * Affichage du countdown
                 * au centre de l'écran.
                 */
                for (Player player : Bukkit.getOnlinePlayers()) {

                    player.sendTitle(
                            "§e" + countdown[0],
                            "",
                            0,
                            20,
                            0
                    );
                }

                /*
                 * Quand le countdown arrive à 0
                 */
                if (countdown[0] <= 0) {

                    // Stop du runnable countdown
                    cancel();

                    /*
                     * Attend 1 seconde avant
                     * de lancer la partie.
                     */
                    new BukkitRunnable() {

                        @Override
                        public void run() {

                            startGame();
                        }

                    }.runTaskLater(plugin, 20L);

                    return;
                }

                // Réduction du countdown
                countdown[0]--;
            }

        }.runTaskTimer(plugin, 20L, 20L);
    }

    /*
     * Lance réellement la partie
     */
    public void startGame() {

        // Passage en RUNNING
        this.gameState = GameState.RUNNING;

        // Reset du timer
        this.gameTime = 0;

        /*
         * Reset environnement.
         */
        if (!Bukkit.getWorlds().isEmpty()) {

            var world = Bukkit.getWorlds().getFirst();

            // Début de journée
            world.setTime(1000);

            // Beau temps
            world.setStorm(false);

            world.setThundering(false);

            // Durée météo clear
            world.setWeatherDuration(999999);
        }

        /*
         * Reset des advancements
         * des joueurs.
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            resetPlayerAdvancements(player);
        }

        Bukkit.broadcastMessage(
                "§aLa partie commence !"
        );

        /*
         * Lance le challenge choisi
         */
        activeChallenge.start();

        /*
         * Affiche l'objectif du challenge
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            player.sendTitle(
                    "§b" + activeChallenge.getName(),
                    "§f" + activeChallenge.getObjective(),
                    10,
                    60,
                    20
            );
        }

        /*
         * Création BossBar vide.
         */
        bossBar = Bukkit.createBossBar(
                "",
                BarColor.BLUE,
                BarStyle.SOLID
        );

        /*
         * Configuration par le challenge.
         */
        activeChallenge.setupBossBar(bossBar);

        /*
         * Ajout des joueurs.
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            bossBar.addPlayer(player);
        }

        /*
         * Runnable principal du jeu.
         *
         * Met à jour :
         * - le timer
         * - les scoreboards
         */
        new BukkitRunnable() {

            @Override
            public void run() {

                /*
                 * Stop automatique
                 * si la partie n'est plus active.
                 */
                if (gameState != GameState.RUNNING) {
                    cancel();
                    return;
                }

                // Incrémentation du temps
                gameTime++;

                /*
                 * Mise à jour des scoreboards
                 */
                for (Player player : Bukkit.getOnlinePlayers()) {

                    plugin.getScoreboardManager()
                            .updateScoreboard(player);
                }
            }

        }.runTaskTimer(plugin, 20L, 20L);
    }

    /*
     * Termine proprement une partie
     */
    public void endGame(Player winner) {

        // Passage en FINISHED
        this.gameState = GameState.FINISHED;

        /*
         * Affichage victoire / défaite
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            // Joueur gagnant
            if (player.equals(winner)) {

                player.sendTitle(
                        "§aVICTOIRE !",
                        "§fTu as gagné la partie",
                        10,
                        60,
                        20
                );
            }

            // Joueurs perdants
            else {

                player.sendTitle(
                        "§cDÉFAITE !",
                        "§f" + winner.getName() + " a gagné",
                        10,
                        60,
                        20
                );
            }
        }

        // Message pour garder une trace du temps réalisé
        Bukkit.broadcastMessage(
                "§e" + winner.getName()
                        + " a réussi le challenge en "
                        + TimeUtils.formatTime(plugin.getGameManager().getGameTime())
        );

        /*
         * Petit délai avant reset.
         */
        new BukkitRunnable() {

            @Override
            public void run() {

                resetGame();
            }

        }.runTaskLater(plugin, 100L);
    }

    /*
     * Réinitialise complètement la partie
     */
    public void resetGame() {

        // Retour en attente
        this.gameState = GameState.WAITING;

        // Reset timer
        this.gameTime = 0;

        /*
         * IMPORTANT :
         * on garde le challenge actif.
         *
         * Sinon :
         * - risques de null
         * - scoreboard cassé
         * - menus incohérents
         */

        /*
         * Retour des joueurs au lobby
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            plugin.getLobbyManager()
                    .teleportToLobby(player);
        }

        /*
         * Mise à jour des scoreboards
         * après reset.
         */
        for (Player player : Bukkit.getOnlinePlayers()) {

            plugin.getScoreboardManager()
                    .updateScoreboard(player);

            /*
             * Reset joueur pour éviter tout avantage possible
             */
            player.getInventory().clear();

            player.setHealth(20);

            player.setFoodLevel(20);

            player.setFireTicks(0);

            player.setFallDistance(0);
        }

        /*
         * Suppression BossBar.
         */
        if (bossBar != null) {

            bossBar.removeAll();

            bossBar = null;
        }

        // Reset du compteur de morts
        playerDeaths.clear();
    }

    /*
     * Stop manuellement la partie.
     */
    public void stopGame() {

        Bukkit.broadcastMessage(
                "§cLa partie a été arrêtée."
        );

        /*
         * Stop du challenge actif.
         */
        if (activeChallenge != null) {

            activeChallenge.stop();
        }

        /*
         * Reset complet du jeu.
         */
        resetGame();
    }

    /*
     * Reset tous les advancements
     * d'un joueur.
     */
    private void resetPlayerAdvancements(Player player) {

        Bukkit.advancementIterator().forEachRemaining(advancement -> {

            var progress =
                    player.getAdvancementProgress(advancement);

            /*
             * Retire tous les critères validés.
             */
            for (String criteria
                    : progress.getAwardedCriteria()) {

                progress.revokeCriteria(criteria);
            }
        });
    }
}