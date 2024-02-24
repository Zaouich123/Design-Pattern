package com.fges.todoapp;

import com.fges.todoapp.CsvFileManager;
import com.fges.todoapp.Todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvTodoReader {
    private final CsvFileManager csvFileManager = new CsvFileManager();

    public List<Todo> readTodos(String fileName) throws IOException {
        List<Todo> todos = new ArrayList<>();

        if (fileName.endsWith(".csv")) {
            List<String> lines = csvFileManager.readCsvFile(fileName);
            for (String line : lines) {
                String[] parts = line.split(",");
                String text = parts[0];
                boolean done = Boolean.parseBoolean(parts[1]);
                Todo todo = new Todo(text, done);
                todos.add(todo);
            }
        }

        return todos;
    }
}
