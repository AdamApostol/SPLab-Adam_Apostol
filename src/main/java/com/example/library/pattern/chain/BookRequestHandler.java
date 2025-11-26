package com.example.library.pattern.chain;

import java.util.Map;

public abstract class BookRequestHandler {
    protected BookRequestHandler nextHandler;

    public void setNext(BookRequestHandler handler) {
        this.nextHandler = handler;
    }

    public abstract Object handle(Map<String, Object> request);

    protected Object passToNext(Map<String, Object> request) {
        if (nextHandler != null) {
            return nextHandler.handle(request);
        }
        return null;
    }
}