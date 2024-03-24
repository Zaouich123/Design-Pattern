package com.fges.todoapp.other;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.text.ParseException;

public class CommandeParser {
    public static CommandLine parse(String[] args) throws ParseException {
        Options cliOptions = new Options();
        cliOptions.addRequiredOption("s", "source", true, "Fichier contenant les todos");
        cliOptions.addOption("d", "done",false, "Liste seulement les todos terminés");
        cliOptions.addOption("o", "output", true, "Fichier de sortie pour la migration");
        try {
            CommandLineParser parser = new DefaultParser();
            return parser.parse(cliOptions, args);
        }  catch (org.apache.commons.cli.ParseException e) {
        throw new IllegalArgumentException("Erreur lors de l'analyse des arguments en ligne de commande.", e);
        }
    }
}
