package com.fges.todoapp.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fges.todoapp.other.FileHandler;
import com.fges.todoapp.Todo;
import com.fges.todoapp.inter.TodoWriter;

import java.io.IOException;

public class JsonTodoWriter implements TodoWriter {
    private final FileHandler fileHandler = new FileHandler();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void writeTodo(String fileName, Todo todo) throws IOException {
        // Lire les tâches existantes à partir du fichier JSON
        String fileContent = fileHandler.readFile(fileName);
        ArrayNode todosNode;
        if (!fileContent.isEmpty()) {
            todosNode = objectMapper.readValue(fileContent, ArrayNode.class);
        } else {
            todosNode = objectMapper.createArrayNode();
        }

        // Ajouter la nouvelle tâche à la liste
        ObjectNode todoNode = objectMapper.createObjectNode();
        todoNode.put("text", todo.getText());
        todoNode.put("done", todo.isDone());
        todosNode.add(todoNode);

        // Écrire la liste mise à jour dans le fichier
        String todoJson = objectMapper.writeValueAsString(todosNode);
        fileHandler.writeFile(fileName, todoJson);
    }
}
