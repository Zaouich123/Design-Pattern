package com.fges.todoapp.inter;

import com.fges.todoapp.Todo;

import java.io.IOException;

public interface TodoWriter {
    void writeTodo(String fileName, Todo todo) throws IOException;
}
