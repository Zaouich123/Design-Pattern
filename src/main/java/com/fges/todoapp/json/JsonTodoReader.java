package com.fges.todoapp.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fges.todoapp.other.FileHandler;
import com.fges.todoapp.Todo;
import com.fges.todoapp.inter.TodoReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTodoReader implements TodoReader {
    private final FileHandler fileHandler = new FileHandler();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Todo> readTodos(String fileName) throws IOException {
        List<Todo> todos = new ArrayList<>();

        String fileContent = fileHandler.readFile(fileName);

            JsonNode actualObj = objectMapper.readTree(fileContent);
            for (JsonNode node : actualObj) {
                String text = node.get("text").asText();
                boolean done = node.get("done").asBoolean();
                Todo todo = new Todo(text, done);
                todos.add(todo);
            }


        return todos;
    }
}
