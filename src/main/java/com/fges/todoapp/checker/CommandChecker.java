package com.fges.todoapp.checker;

import com.fges.todoapp.inter.Command;
import com.fges.todoapp.command.InsertCommand;
import com.fges.todoapp.command.ListCommand;
import com.fges.todoapp.command.MigrateCommand;

public class CommandChecker {
    public static Command createCommand(String commandName) {
        if (commandName.equals("insert")) {
            return new InsertCommand();
        } else if (commandName.equals("migrate")) {
            return new MigrateCommand();
        } else if (commandName.equals("list")) {
            return new ListCommand();
        } else {
            throw new IllegalArgumentException("Unknown command: " + commandName);
        }
    }
}
