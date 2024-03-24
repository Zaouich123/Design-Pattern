package com.fges.todoapp.checker;

import com.fges.todoapp.csv.CsvTodoStorage;
import com.fges.todoapp.json.JsonTodoStorage;
import com.fges.todoapp.inter.TodoInterfaceStorage;

public class TodoCheckFilename  {
    public TodoInterfaceStorage createTodoStorage(String fileName) {
        if (fileName.endsWith("csv")) {
            return new CsvTodoStorage();
        } else if (fileName.endsWith("json")) {
            return new JsonTodoStorage();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }
}
