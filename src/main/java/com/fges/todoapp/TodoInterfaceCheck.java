package com.fges.todoapp;

import java.io.IOException;

public interface TodoInterfaceCheck {
    void listTodos(String fileName, String fileContent, boolean doneOnly) throws IOException;

    void insertTodo(String fileName, String fileContent, Todo todo) throws IOException;
}
