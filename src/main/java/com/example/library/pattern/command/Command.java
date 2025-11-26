package com.example.library.pattern.command;

public interface Command {
    void execute();
    void undo();
}