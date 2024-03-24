package com.fges.todoapp;


import com.fges.todoapp.checker.CommandChecker;
import com.fges.todoapp.inter.Command;
import com.fges.todoapp.other.CommandeParser;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    /**
     * Do not change this method
     */
    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException {
        CommandLine cmd;
        try {
            cmd = CommandeParser.parse(args);
        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException("Erreur lors de l'analyse des arguments en ligne de commande.", e);
        }
        String fileName = cmd.getOptionValue("s");
        List<String> positionalArgs = cmd.getArgList();
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return 1;
        }

        Path filePath = Paths.get(fileName);

        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                return 1;
            }
        }
        String commandName = positionalArgs.get(0);
        Command command = CommandChecker.createCommand(commandName);
        command.execute(cmd);
        System.err.println("Done.");
        return 0;

    }
}
