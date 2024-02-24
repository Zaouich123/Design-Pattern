package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public class MigrateCsvToJson implements MigrationInterface{
    private final CsvTodoReader csvTodoReader = new CsvTodoReader();
    private final JsonTodoWriter jsonTodoWriter = new JsonTodoWriter();

    public void migrate(String sourceFileName, String outputFileName) throws IOException {
        List<Todo> todos = csvTodoReader.readTodos(sourceFileName);

        for (Todo todo : todos) {
            jsonTodoWriter.writeTodo(outputFileName, todo);
        }
    }
}
