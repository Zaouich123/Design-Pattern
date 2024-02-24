package com.fges.todoapp;

public class TodoCheckFilename {
    public static TodoInterfaceStorage createTodoChecker(String fileName) {
        if (fileName.endsWith("csv")) {
            return new CsvTodoStorage();
        } else if (fileName.endsWith("json")) {
            return new JsonTodoStorage();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }
}
