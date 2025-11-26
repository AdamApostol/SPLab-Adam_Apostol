package com.example.library.pattern.chain;

import com.example.library.pattern.chain.BookRequestHandler;
import java.time.LocalDateTime;
import java.util.Map;

public class LoggingHandler extends BookRequestHandler {

    @Override
    public Object handle(Map<String, Object> request) {
        String operation = (String) request.get("operation");
        Long id = (Long) request.get("id");

        System.out.println("LoggingHandler: [" + LocalDateTime.now() + "] " +
                "Operation: " + operation +
                (id != null ? ", Book ID: " + id : ""));

        return passToNext(request);
    }
}
