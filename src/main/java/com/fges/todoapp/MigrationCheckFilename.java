package com.fges.todoapp.migration;

import com.fges.todoapp.*;

public class MigrationCheckFilename {
    public static MigrationInterface createMigration(String sourceFileName, String outputFileName) {
        if (sourceFileName.endsWith(".csv") && outputFileName.endsWith(".csv")) {
            return new MigrateCsvToCsv();
        } else if (sourceFileName.endsWith(".csv") && outputFileName.endsWith(".json")) {
            return new MigrateCsvToJson();
        } else if (sourceFileName.endsWith(".json") && outputFileName.endsWith(".json")) {
            return new MigrateJsonToJson();
        } else if (sourceFileName.endsWith(".json") && outputFileName.endsWith(".csv")) {
            return new MigrateJsonToCsv();
        } else {
            throw new IllegalArgumentException("Unsupported migration: source and/or output file format not supported");
        }
    }
}
