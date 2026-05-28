package me.simon.speedrunchallenges.records;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class RecordManager {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Fichier records
    private final File recordsFile;

    // Config YAML
    private final YamlConfiguration config;

    public RecordManager(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;

        /*
         * Fichier records.yml
         */
        this.recordsFile =
                new File(
                        plugin.getDataFolder(),
                        "records.yml"
                );

        /*
         * Création si absent.
         */
        if (!recordsFile.exists()) {

            try {

                recordsFile.createNewFile();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        /*
         * Chargement config.
         */
        this.config =
                YamlConfiguration.loadConfiguration(
                        recordsFile
                );
    }

    /*
     * Sauvegarde record.
     */
    public void saveRecord(
            String challengeKey,
            String playerName,
            int time
    ) {

        /*
         * Record actuel.
         */
        int bestTime =
                config.getInt(
                        challengeKey + ".time",
                        Integer.MAX_VALUE
                );

        /*
         * Vérifie meilleur temps.
         */
        if (time >= bestTime) {
            return;
        }

        /*
         * Nouveau record.
         */
        config.set(
                challengeKey + ".player",
                playerName
        );

        config.set(
                challengeKey + ".time",
                time
        );

        /*
         * Sauvegarde fichier.
         */
        try {

            config.save(recordsFile);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /*
     * Retourne record.
     */
    public ChallengeRecord getRecord(
            String challengeKey
    ) {

        /*
         * Vérifie existence.
         */
        if (!config.contains(
                challengeKey
        )) {

            return null;
        }

        String player =
                config.getString(
                        challengeKey + ".player"
                );

        int time =
                config.getInt(
                        challengeKey + ".time"
                );

        return new ChallengeRecord(
                player,
                time
        );
    }

    /*
     * Retourne tous les records.
     */
    public YamlConfiguration getConfig() {

        return config;
    }
}