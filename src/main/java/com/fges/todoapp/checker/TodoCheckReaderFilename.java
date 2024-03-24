package com.fges.todoapp.checker;

import com.fges.todoapp.csv.CsvTodoReader;
import com.fges.todoapp.json.JsonTodoReader;
import com.fges.todoapp.inter.TodoReader;

public class TodoCheckReaderFilename {
    public TodoReader createTodoReader(String fileName) {
        if (fileName.endsWith("csv")) {
            return new CsvTodoReader();
        } else if (fileName.endsWith("json")) {
            return new JsonTodoReader();
        }
        else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }

}
