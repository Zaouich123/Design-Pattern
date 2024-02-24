package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileManager {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode readJsonFile(Path filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(filePath);
        return objectMapper.readTree(fileBytes);
    }

    public void writeJsonFile(Path filePath, JsonNode jsonNode) throws IOException {
        Files.write(filePath, objectMapper.writeValueAsBytes(jsonNode));
    }
}
