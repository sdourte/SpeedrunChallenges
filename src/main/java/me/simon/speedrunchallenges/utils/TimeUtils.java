package me.simon.speedrunchallenges.utils;

public class TimeUtils {

    /*
     * Convertit des secondes
     * en format mm:ss.
     */
    public static String formatTime(int seconds) {

        int minutes = seconds / 60;

        int remainingSeconds = seconds % 60;

        /*
         * Exemple :
         * 3:05
         */
        return String.format(
                "%02d:%02d",
                minutes,
                remainingSeconds
        );
    }
}