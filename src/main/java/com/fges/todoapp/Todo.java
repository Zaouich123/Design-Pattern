package com.fges.todoapp;

public class    Todo {
    private String text;

    private boolean done;

    public Todo(String text, Boolean done) {
        this.text = text;
        this.done = done;
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
