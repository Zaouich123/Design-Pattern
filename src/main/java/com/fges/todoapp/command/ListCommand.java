package com.fges.todoapp.command;

import com.fges.todoapp.inter.Command;
import com.fges.todoapp.checker.TodoCheckFilename;
import com.fges.todoapp.inter.TodoInterfaceStorage;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;

public class ListCommand implements Command {

    private final TodoCheckFilename todoCheckFilename = new TodoCheckFilename();

    @Override
    public void execute(CommandLine cmd) {
        String fileName = cmd.getOptionValue("s");

        // Création du stockage correspondant en fonction du nom de fichier
        TodoInterfaceStorage todoStorage = todoCheckFilename.createTodoStorage(fileName);

        boolean doneOnly = cmd.hasOption("d");

        try {
            todoStorage.listTodos(fileName, doneOnly);
        } catch (IOException e) {
            System.err.println("Error listing TODOs: " + e.getMessage());
        }
    }
}
