package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TodoCheck implements TodoInterfaceCheck{
    public void insertTodo(String fileName, String fileContent, Todo todo) throws IOException {
        if (fileName.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(fileContent);
            if (actualObj instanceof MissingNode) {
                actualObj = JsonNodeFactory.instance.arrayNode();
            }

            if (actualObj instanceof ArrayNode arrayNode) {
                ObjectNode todoNode = mapper.valueToTree(todo);
                arrayNode.add(todoNode);
            }

            FileClass.writeFileContent(fileName, actualObj.toString());
        } else if (fileName.endsWith(".csv")) {
            if (!fileContent.endsWith("\n") && !fileContent.isEmpty()) {
                fileContent += "\n";
            }
            fileContent += todo.toString();

            FileClass.writeFileContent(fileName, fileContent);
        }
    }

    public void listTodos(String fileName, String fileContent, boolean doneOnly) throws IOException {
        if (fileName.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(fileContent);
            if (actualObj instanceof MissingNode) {
                actualObj = JsonNodeFactory.instance.arrayNode();
            }

            if (actualObj instanceof ArrayNode arrayNode) {
                arrayNode.forEach(node -> {
                    Todo todo = mapper.convertValue(node, Todo.class);
                    if (!doneOnly || todo.isDone()) {
                        System.out.println("- " + todo.toString());
                    }
                });
            }
        } else if (fileName.endsWith(".csv")) {
            Arrays.stream(fileContent.split("\n"))
                    .map(line -> {
                        String[] fields = line.split(",");
                        if (fields.length > 0) {
                            return new Todo(fields[0]);
                        } else {
                            return null; // Ignorer les lignes sans données
                        }
                    })
                    .filter(todo -> !doneOnly || todo.isDone()) // Utilisation de la méthode isDone() pour vérifier si la tâche est terminée
                    .map(todo -> "- " + todo.toString())
                    .forEach(System.out::println);
        }
    }
}
