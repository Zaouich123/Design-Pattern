package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public class CsvTodoStorage implements TodoInterfaceStorage {
    private final CsvTodoReader csvTodoReader = new CsvTodoReader();
    private final CsvTodoWriter csvTodoWriter = new CsvTodoWriter();

    @Override
    public void insertTodo(String fileName, Todo todo) throws IOException {
        csvTodoWriter.writeTodo(fileName, todo);
    }

    @Override
    public void listTodos(String fileName, boolean doneOnly) throws IOException {
        List<Todo> todos = csvTodoReader.readTodos(fileName);
        for (Todo todo : todos) {
            if (!doneOnly || todo.isDone()) {
                System.out.println("- " + todo.getText());
            }
        }
    }
}
