package com.fges.todoapp;

import com.fges.todoapp.CsvFileManager;
import com.fges.todoapp.Todo;

import java.io.IOException;

public class CsvTodoWriter {
    private final CsvFileManager csvFileManager = new CsvFileManager();

    public void writeTodo(String fileName, Todo todo) throws IOException {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(todo.getText()).append(",").append(todo.isDone()).append("\n");
        csvFileManager.writeCsvFile(fileName, csvContent.toString());
    }
}
