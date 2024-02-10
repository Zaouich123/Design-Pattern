package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Arrays;

public class JsonTodoCheck implements TodoInterfaceCheck{
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
        }
    }
}
