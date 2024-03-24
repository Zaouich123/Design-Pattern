package com.fges.todoapp.command;

import com.fges.todoapp.other.TodoMigrator;
import com.fges.todoapp.inter.Command;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;

public class MigrateCommand implements Command {



    @Override
    public void execute(CommandLine cmd) {
        String sourceFileName = cmd.getOptionValue("s");
        String destinationFileName = cmd.getOptionValue("o");

        try {
            // Migration des TODO du fichier source vers le fichier de destination
            TodoMigrator.migrate(sourceFileName, destinationFileName);
        } catch (IOException e) {
            System.err.println("Error migrating TODOs: " + e.getMessage());
        }
    }
}
