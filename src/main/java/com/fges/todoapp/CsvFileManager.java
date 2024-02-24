package com.fges.todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileManager {
    public List<String> readCsvFile(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName));
    }

    public void writeCsvFile(String fileName, String content) throws IOException {
        Files.writeString(Path.of(fileName), content);
    }
}
