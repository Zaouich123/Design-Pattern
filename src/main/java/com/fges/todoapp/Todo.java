package com.fges.todoapp;

public class Todo {
    private String text;

    public Todo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return text.startsWith("Done: ");
    }

    @Override
    public String toString() {
        return text;
    }
}
