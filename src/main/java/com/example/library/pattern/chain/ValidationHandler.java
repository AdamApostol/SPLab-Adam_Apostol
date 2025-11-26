package com.example.library.pattern.chain;

import com.example.library.entity.Book;
import com.example.library.pattern.chain.BookRequestHandler;
import java.util.Map;

public class ValidationHandler extends BookRequestHandler {

    @Override
    public Object handle(Map<String, Object> request) {
        String operation = (String) request.get("operation");
        System.out.println("ValidationHandler: Validating " + operation + " request");

        if ("CREATE".equals(operation) || "UPDATE".equals(operation)) {
            Book book = (Book) request.get("book");
            if (book == null || book.getTitle() == null || book.getTitle().isEmpty()) {
                System.out.println("ValidationHandler: Validation failed - Book or title is null");
                return null;
            }
        }

        System.out.println("ValidationHandler: Validation passed");
        return passToNext(request);
    }
}
