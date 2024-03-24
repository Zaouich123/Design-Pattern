package com.fges.todoapp.csv;

import com.fges.todoapp.Todo;
import com.fges.todoapp.inter.TodoInterfaceStorage;

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
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            if (!doneOnly || todo.isDone()) {
                output.append("- ").append(todo.getText());
                // Ajouter une virgule sauf pour la dernière tâche
                if (i < todos.size() - 1) {
                    output.append(", ");
                }
            }
        }

        System.out.println(output.toString());
    }


}
