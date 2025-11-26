package com.example.library.controller;

import com.example.library.helper.strategy.AllBooksSubject;
import com.example.library.helper.strategy.SseObserver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {

    private final AllBooksSubject subject;

    public BooksSseController(AllBooksSubject subject) {
        this.subject = subject;
    }

    @RequestMapping("/books-sse")
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(0L);
        subject.attach(new SseObserver(emitter));
        return emitter;
    }
}
