package com.fges.todoapp;

import com.fges.todoapp.JsonTodoReader;
import com.fges.todoapp.JsonTodoWriter;
import com.fges.todoapp.Todo;
import com.fges.todoapp.TodoInterfaceStorage;

import java.io.IOException;
import java.util.List;

public class JsonTodoStorage implements TodoInterfaceStorage {
    private final JsonTodoReader jsonTodoReader = new JsonTodoReader();
    private final JsonTodoWriter jsonTodoWriter = new JsonTodoWriter();

    @Override
    public void insertTodo(String fileName,  Todo todo) throws IOException {
        jsonTodoWriter.writeTodo(fileName, todo);
    }

    @Override
    public void listTodos(String fileName, boolean doneOnly) throws IOException {
        List<Todo> todos = jsonTodoReader.readTodos(fileName);
        for (Todo todo : todos) {
            if (!doneOnly || todo.isDone()) {
                System.out.println("- " + todo.getText());
            }
        }
    }
}
