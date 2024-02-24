package com.fges.todoapp;

import com.fges.todoapp.CsvFileManager;
import com.fges.todoapp.Todo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvTodoWriter {
    private final CsvFileManager csvFileManager = new CsvFileManager();

    public void writeTodo(String fileName, Todo todo) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

            writer.write(todo.getText() + "," + todo.isDone());
            writer.newLine();
        }
    }
}
