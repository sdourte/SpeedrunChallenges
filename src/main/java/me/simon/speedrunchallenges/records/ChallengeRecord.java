package me.simon.speedrunchallenges.records;

public class ChallengeRecord {

    // Joueur
    private final String playerName;

    // Temps en secondes
    private final int time;

    public ChallengeRecord(
            String playerName,
            int time
    ) {

        this.playerName = playerName;
        this.time = time;
    }

    public String getPlayerName() {

        return playerName;
    }

    public int getTime() {

        return time;
    }
}