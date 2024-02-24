package com.fges.todoapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fges.todoapp.JsonFileManager;
import com.fges.todoapp.Todo;

import java.io.IOException;
import java.nio.file.Path;

public class JsonTodoWriter {
    private final JsonFileManager jsonFileManager = new JsonFileManager();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void writeTodo(String fileName, Todo todo) throws IOException {
        ObjectNode todoNode = objectMapper.createObjectNode();
        todoNode.put("text", todo.getText());
        todoNode.put("done", todo.isDone());
        jsonFileManager.writeJsonFile(Path.of(fileName), todoNode);
    }
}
