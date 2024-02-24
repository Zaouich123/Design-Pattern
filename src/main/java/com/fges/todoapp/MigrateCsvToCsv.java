package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public class MigrateCsvToCsv implements MigrationInterface {
    private final CsvTodoReader csvTodoReader = new CsvTodoReader();
    private final CsvTodoWriter csvTodoWriter = new CsvTodoWriter();

    public void migrate(String sourceFileName, String outputFileName) throws IOException {
        List<Todo> todos = csvTodoReader.readTodos(sourceFileName);

        for (Todo todo : todos) {
            csvTodoWriter.writeTodo(outputFileName, todo);
        }
    }
}
