package com.fges.todoapp.csv;

import com.fges.todoapp.other.FileHandler;
import com.fges.todoapp.Todo;
import com.fges.todoapp.inter.TodoReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvTodoReader implements TodoReader {
    private final FileHandler fileHandler = new FileHandler();


    public List<Todo> readTodos(String fileName) throws IOException {
        List<Todo> todos = new ArrayList<>();

        String fileContent = fileHandler.readFile(fileName);
        String[] lines = fileContent.split("\n");

        for (String line : lines) {
            // Ignore les lignes vides
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split(",@@@"); // Utilisation de ",@@@" comme séparateur

            if (parts.length == 2) {
                String task = parts[0].trim();
                boolean completed = Boolean.parseBoolean(parts[1].trim());

                Todo todo = new Todo(task, completed);
                todos.add(todo);
            }
        }

        return todos;
    }


}
