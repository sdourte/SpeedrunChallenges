package me.simon.speedrunchallenges.commands;

import me.simon.speedrunchallenges.SpeedrunChallenges;

import me.simon.speedrunchallenges.records.ChallengeRecord;

import me.simon.speedrunchallenges.utils.TimeUtils;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class RecordsCommand
        implements CommandExecutor {

    // Référence plugin
    private final SpeedrunChallenges plugin;

    // Records par page
    private static final int RECORDS_PER_PAGE = 10;

    public RecordsCommand(
            SpeedrunChallenges plugin
    ) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {

        ConfigurationSection section =
                plugin.getRecordManager()
                        .getConfig()
                        .getRoot();

        /*
         * Vérifie records.
         */
        if (section == null) {

            sender.sendMessage(
                    "§cAucun record."
            );

            return true;
        }

        /*
         * Paramètres.
         */
        String filter = null;

        int page = 1;

        /*
         * Lecture arguments.
         */
        if (args.length >= 1) {

            /*
             * Vérifie si page.
             */
            if (isInteger(args[0])) {

                page =
                        Integer.parseInt(args[0]);
            }

            /*
             * Sinon filtre.
             */
            else {

                filter =
                        args[0].toLowerCase();
            }
        }

        /*
         * Deuxième argument :
         * page.
         */
        if (args.length >= 2) {

            if (isInteger(args[1])) {

                page =
                        Integer.parseInt(args[1]);
            }
        }

        /*
         * Liste records filtrés.
         */
        List<String> matchingKeys =
                new ArrayList<>();

        for (String key
                : section.getKeys(false)) {

            /*
             * Filtre challenge.
             */
            if (filter != null
                    && !key.toLowerCase()
                    .startsWith(filter)) {

                continue;
            }

            matchingKeys.add(key);
        }

        /*
         * Vérifie résultats.
         */
        if (matchingKeys.isEmpty()) {

            sender.sendMessage(
                    "§cAucun record trouvé."
            );

            return true;
        }

        /*
         * Pagination.
         */
        int totalPages =
                (int) Math.ceil(
                        (double) matchingKeys.size()
                                / RECORDS_PER_PAGE
                );

        /*
         * Clamp page.
         */
        if (page < 1) {
            page = 1;
        }

        if (page > totalPages) {
            page = totalPages;
        }

        int start =
                (page - 1)
                        * RECORDS_PER_PAGE;

        int end =
                Math.min(
                        start + RECORDS_PER_PAGE,
                        matchingKeys.size()
                );

        /*
         * Header.
         */
        sender.sendMessage(
                ChatColor.GOLD
                        + "=== RECORDS ["
                        + page
                        + "/"
                        + totalPages
                        + "] ==="
        );

        /*
         * Affichage records.
         */
        for (int i = start;
             i < end;
             i++) {

            String key =
                    matchingKeys.get(i);

            ChallengeRecord record =
                    plugin.getRecordManager()
                            .getRecord(key);

            /*
             * Sécurité.
             */
            if (record == null) {
                continue;
            }

            sender.sendMessage(
                    "§e" + key
            );

            sender.sendMessage(
                    " §7→ §f"
                            + record.getPlayerName()
                            + " §7- §a"
                            + TimeUtils.formatTime(
                            record.getTime()
                    )
            );
        }

        /*
         * Footer aide.
         */
        sender.sendMessage(
                "§8Utilisez §7/records <challenge> <page>"
        );

        return true;
    }

    /*
     * Vérifie entier.
     */
    private boolean isInteger(
            String text
    ) {

        try {

            Integer.parseInt(text);

            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }
}