package com.fges.todoapp;

import java.io.IOException;
import java.util.Arrays;

public class CsvTodoCheck implements TodoInterfaceCheck{


    public void insertTodo(String fileName, String fileContent, Todo todo) throws IOException{
        if (fileName.endsWith(".csv")) {
            if (!fileContent.endsWith("\n") && !fileContent.isEmpty()) {
                fileContent += "\n";
            }
            fileContent += todo.toString();

            FileClass.writeFileContent(fileName, fileContent);
        }


    }
    public void listTodos(String fileName, String fileContent, boolean doneOnly) throws IOException{
    if (fileName.endsWith(".csv")) {
        Arrays.stream(fileContent.split("\n"))
                .map(line -> {
                    String[] fields = line.split(",");
                    if (fields.length > 0) {
                        return new Todo(fields[0]);
                    } else {
                        return null; // Ignorer les lignes sans données
                    }
                })
                .filter(todo -> !doneOnly || todo.isDone()) // Utilisation de la méthode isDone() pour vérifier si la tâche est terminée
                .map(todo -> "- " + todo.toString())
                .forEach(System.out::println);
        }
    }
}
