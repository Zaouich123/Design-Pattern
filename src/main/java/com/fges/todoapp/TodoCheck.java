package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TodoCheck {
    public static void insertTodo(String fileName, String fileContent, String todo) throws IOException {
        if (fileName.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(fileContent);
            if (actualObj instanceof MissingNode) {
                actualObj = JsonNodeFactory.instance.arrayNode();
            }

            if (actualObj instanceof ArrayNode arrayNode) {
                arrayNode.add(todo);
            }

            FileClass.writeFileContent(fileName, actualObj.toString());
        } else if (fileName.endsWith(".csv")) {
            if (!fileContent.endsWith("\n") && !fileContent.isEmpty()) {
                fileContent += "\n";
            }
            fileContent += todo;

            FileClass.writeFileContent(fileName, fileContent);
        }
    }

    public static void listTodos(String fileName, String fileContent, boolean doneOnly) throws IOException {
        if (fileName.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(fileContent);
            if (actualObj instanceof MissingNode) {
                actualObj = JsonNodeFactory.instance.arrayNode();
            }

            if (actualObj instanceof ArrayNode arrayNode) {
                arrayNode.forEach(node -> {
                    String todoText = node.toString();
                    if (!doneOnly || todoText.startsWith("\"Done: ")) {
                        System.out.println("- " + todoText);
                    }
                });
            }
        } else if (fileName.endsWith(".csv")) {
            Arrays.stream(fileContent.split("\n"))
                    .filter(todo -> !doneOnly || todo.startsWith("Done: "))
                    .map(todo -> "- " + todo)
                    .forEach(System.out::println);
        }
    }
}
