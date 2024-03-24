package com.fges.todoapp.other;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public static String readFile(String fileName) throws IOException {
        Path filePath = Path.of(fileName);
        if (Files.exists(filePath)) {
            return Files.readString(filePath);
        } else {
            return ""; // ou lancer une exception si le fichier n'est pas trouvé
        }
    }

    public static void writeFile(String fileName, String content) throws IOException {
        Path filePath = Path.of(fileName);
        Files.writeString(filePath, content);
    }
}
