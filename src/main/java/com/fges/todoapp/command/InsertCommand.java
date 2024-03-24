package com.fges.todoapp.command;

import com.fges.todoapp.inter.Command;
import com.fges.todoapp.Todo;
import com.fges.todoapp.checker.TodoCheckFilename;
import com.fges.todoapp.inter.TodoInterfaceStorage;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;

public class InsertCommand implements Command {

    private final TodoCheckFilename todoCheckFilename = new TodoCheckFilename();

    @Override
    public void execute(CommandLine cmd) {
        String fileName = cmd.getOptionValue("s");

        // Vérification du nom de fichier et création du stockage correspondant
        TodoInterfaceStorage todoStorage = todoCheckFilename.createTodoStorage(fileName);

        if (cmd.getArgList().size() < 2) {
            System.err.println("Missing TODO name");
            return;
        }

        String todoName = cmd.getArgList().get(1);
        boolean isDone = cmd.hasOption("d");
        Todo todo = new Todo(todoName, isDone);
        if (isDone) {
            todo.setText("Done: " + todoName);
        }

        try {
            todoStorage.insertTodo(fileName, todo);
        } catch (IOException e) {
            System.err.println("Error inserting TODO: " + e.getMessage());
        }
    }
}
