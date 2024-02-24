package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fges.todoapp.JsonFileManager;
import com.fges.todoapp.Todo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonTodoReader {
    private final JsonFileManager jsonFileManager = new JsonFileManager();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Todo> readTodos(String fileName) throws IOException {
        List<Todo> todos = new ArrayList<>();

        if (fileName.endsWith(".json")) {
            JsonNode actualObj = jsonFileManager.readJsonFile(Path.of(fileName));
            if (actualObj.isArray()) {
                for (JsonNode node : actualObj) {
                    String text = node.get("text").asText();
                    boolean done = node.get("done").asBoolean();
                    Todo todo = new Todo(text, done);
                    todos.add(todo);
                }
            }
        }

        return todos;
    }
}
