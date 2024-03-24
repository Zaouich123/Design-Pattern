package com.fges.todoapp.checker;

import com.fges.todoapp.csv.CsvTodoWriter;
import com.fges.todoapp.json.JsonTodoWriter;
import com.fges.todoapp.inter.TodoWriter;

public class TodoCheckWriterFilename {
    public TodoWriter createTodoWriter(String fileName) {
        if (fileName.endsWith("csv")) {
            return new CsvTodoWriter();
        } else if (fileName.endsWith("json")) {
            return new JsonTodoWriter();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }
}
