package com.fges.todoapp.inter;

import org.apache.commons.cli.CommandLine;
import java.io.IOException;

public interface Command {
    void execute(CommandLine cmd) throws IOException;
}
