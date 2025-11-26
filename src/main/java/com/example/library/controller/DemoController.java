package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final BookService bookService;

    @Autowired
    public DemoController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Demo endpoint to show Chain of Responsibility and Command patterns in action
     */
    @PostMapping("/pattern-demo")
    public ResponseEntity<Map<String, String>> demonstratePatterns() {
        Map<String, String> response = new HashMap<>();

        Book book1 = new Book();
        book1.setTitle("Design Patterns");
        Book created = bookService.createBook(book1);
        response.put("step1", "Book created with ID: " + created.getId());

        created.setTitle("Design Patterns - Updated");
        bookService.updateBook(created.getId(), created);
        response.put("step2", "Book updated");

        bookService.undoLastCommand();
        response.put("step3", "Last command undone");

        Book retrieved = bookService.getBookById(created.getId());
        response.put("step4", "Book retrieved: " + (retrieved != null ? retrieved.getTitle() : "Not found"));

        response.put("message", "Check console for Chain of Responsibility and Command pattern logs");

        return ResponseEntity.ok(response);
    }

    /**
     * Undo the last command
     */
    @PostMapping("/undo")
    public ResponseEntity<Map<String, String>> undoLastCommand() {
        bookService.undoLastCommand();
        Map<String, String> response = new HashMap<>();
        response.put("message", "Last command undone successfully");
        return ResponseEntity.ok(response);
    }
}

