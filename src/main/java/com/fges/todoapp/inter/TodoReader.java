package com.fges.todoapp.inter;

import com.fges.todoapp.Todo;

import java.io.IOException;
import java.util.List;

public interface TodoReader {
    List<Todo> readTodos(String fileName) throws IOException;
}
