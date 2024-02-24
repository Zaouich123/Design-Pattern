package com.fges.todoapp;
import java.io.IOException;
public interface MigrationInterface {
    void migrate(String sourceFileName, String outputFileName) throws IOException;
}
