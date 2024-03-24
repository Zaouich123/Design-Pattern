package com.fges.todoapp.other;

import com.fges.todoapp.Todo;
import com.fges.todoapp.checker.TodoCheckReaderFilename;
import com.fges.todoapp.checker.TodoCheckWriterFilename;
import com.fges.todoapp.inter.TodoReader;
import com.fges.todoapp.inter.TodoWriter;

import java.io.IOException;
import java.util.List;

public class TodoMigrator {
    private static TodoCheckReaderFilename readerChecker = new TodoCheckReaderFilename();
    private static TodoCheckWriterFilename writerChecker = new TodoCheckWriterFilename();



    public static void migrate(String sourceFileName, String destinationFileName) throws IOException {
        TodoWriter writer = writerChecker.createTodoWriter(destinationFileName);
        TodoReader reader = readerChecker.createTodoReader(sourceFileName);

        // Vérifie que les objets TodoWriter et TodoReader sont correctement initialisés
        System.err.println("Writer: " + writer);
        System.err.println("Reader: " + reader);
        List<Todo> todos = reader.readTodos(sourceFileName);

        // Vérifie s'il y a des todos à migrer
        if (todos.isEmpty()) {
            System.err.println("Il n'y a pas de todos à migrer dans le fichier source.");
            return; // Termine l'exécution de la méthode
        }
        // Écrit les todos dans le fichier de sortie
        for (Todo todo : todos) {
            System.err.println("Writing todo: " + todo);
            writer.writeTodo(destinationFileName, todo);

    }
}}
