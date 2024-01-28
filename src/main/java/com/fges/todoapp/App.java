package com.fges.todoapp;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        if (command.equals("insert")) {
            if (positionalArgs.size() < 2) {
                System.err.println("Missing TODO name");
                return 1;
            }
            String todo = positionalArgs.get(1);

            TodoCheck.insertTodo(fileName, fileContent, todo);
        }

        if (command.equals("list")) {
            TodoCheck.listTodos(fileName, fileContent);
        }

        System.err.println("Done.");
        return 0;
    }
}
