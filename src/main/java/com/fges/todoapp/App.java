package com.fges.todoapp;


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

        String command = positionalArgs.get(0);

        Path filePath = Paths.get(fileName);
        String fileContent = FileClass.readFileContent(fileName);

        TodoInterfaceStorage todoChecker = TodoCheckFilename.createTodoChecker(fileName);

        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                return 1;
            }
        }

        if (command.equals("insert")) {
            if (positionalArgs.size() < 2) {
                System.err.println("Missing TODO name");
                return 1;
            }
            Todo todoObject = new Todo(positionalArgs.get(1), Boolean.valueOf(cmd.hasOption("d")));
            if (cmd.hasOption("d")) {
                todoObject.setText("Done: " + todoObject.getText());
            }
            todoChecker.insertTodo(fileName, todoObject);
        }

        if (command.equals("list")) {
            boolean doneOnly = cmd.hasOption("d");
            todoChecker.listTodos(fileName, doneOnly);
        }

        System.err.println("Done.");
        return 0;

    }
}
