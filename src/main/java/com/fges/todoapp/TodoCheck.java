package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.io.IOException;
import java.nio.file.Paths;
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

    public static void listTodos(String fileName, String fileContent) throws IOException {
        if (fileName.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(fileContent);
            if (actualObj instanceof MissingNode) {
                actualObj = JsonNodeFactory.instance.arrayNode();
            }

            if (actualObj instanceof ArrayNode arrayNode) {
                arrayNode.forEach(node -> System.out.println("- " + node.toString()));
            }
        } else if (fileName.endsWith(".csv")) {
            System.out.println(Arrays.stream(fileContent.split("\n"))
                    .map(todo -> "- " + todo)
                    .collect(Collectors.joining("\n"))
            );
        }
    }
}
