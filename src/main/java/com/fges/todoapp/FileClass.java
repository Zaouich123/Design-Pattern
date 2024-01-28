package com.fges.todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileClass{
    public static String readFileContent(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        if (Files.exists(filePath)) {
            return Files.readString(filePath);
        }
        return "";
    }

    public static void writeFileContent(String fileName, String content) throws IOException {
        Files.writeString(Paths.get(fileName), content);
    }
}
