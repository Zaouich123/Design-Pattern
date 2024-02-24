package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public interface TodoInterfaceStorage {
    void listTodos(String fileName,  boolean doneOnly) throws IOException;

    void insertTodo(String fileName, Todo todo) throws IOException;
}
