package com.fges.todoapp.csv;

import com.fges.todoapp.Todo;
import com.fges.todoapp.inter.TodoWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvTodoWriter implements TodoWriter {


    public void writeTodo(String fileName, Todo todo) throws IOException {
        String text = todo.getText();
        boolean done = todo.isDone();

        // Vérifier si la chaîne de texte n'est pas vide
        if (!text.isEmpty()) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                writer.write(text + ",@@@" + done);
                writer.newLine();
            }
        }
    }
}
