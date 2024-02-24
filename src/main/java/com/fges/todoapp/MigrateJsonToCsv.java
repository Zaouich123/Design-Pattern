package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public class MigrateJsonToCsv implements MigrationInterface{
    private final JsonTodoReader jsonTodoReader = new JsonTodoReader();
    private final CsvTodoWriter csvTodoWriter = new CsvTodoWriter();

    public void migrate(String sourceFileName, String outputFileName) throws IOException {
        List<Todo> todos = jsonTodoReader.readTodos(sourceFileName);

        for (Todo todo : todos) {
            csvTodoWriter.writeTodo(outputFileName, todo);
        }
    }
}
