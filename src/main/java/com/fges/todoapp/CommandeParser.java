package com.fges.todoapp;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.text.ParseException;

public class CommandeParser {
    public static CommandLine parse(String[] args) throws ParseException {
        Options cliOptions = new Options();
        cliOptions.addRequiredOption("s", "source", true, "Fichier contenant les todos");

        try {
            CommandLineParser parser = new DefaultParser();
            return parser.parse(cliOptions, args);
        }  catch (org.apache.commons.cli.ParseException e) {
        throw new IllegalArgumentException("Erreur lors de l'analyse des arguments en ligne de commande.", e);
        }
    }
}
