package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public class MigrateJsonToJson implements MigrationInterface{
    private final JsonTodoReader jsonTodoReader = new JsonTodoReader();
    private final JsonTodoWriter jsonTodoWriter = new JsonTodoWriter();

    public void migrate(String sourceFileName, String outputFileName) throws IOException {
        List<Todo> todos = jsonTodoReader.readTodos(sourceFileName);

        for (Todo todo : todos) {
            jsonTodoWriter.writeTodo(outputFileName, todo);
        }
    }
}
