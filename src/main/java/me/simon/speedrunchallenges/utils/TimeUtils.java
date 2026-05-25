package me.simon.speedrunchallenges.utils;

public class TimeUtils {

    /*
     * Convertit des secondes
     * en format hh:mm:ss.
     */
    public static String formatTime(
            int seconds
    ) {

        /*
         * Heures.
         */
        int hours =
                seconds / 3600;

        /*
         * Minutes restantes.
         */
        int minutes =
                (seconds % 3600) / 60;

        /*
         * Secondes restantes.
         */
        int remainingSeconds =
                seconds % 60;

        return String.format(
                "%02d:%02d:%02d",
                hours,
                minutes,
                remainingSeconds
        );
    }
}