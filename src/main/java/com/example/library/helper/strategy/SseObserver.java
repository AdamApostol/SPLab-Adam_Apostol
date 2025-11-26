package com.example.library.helper.strategy;

import com.example.library.entity.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SseObserver implements Observer {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (Exception ignored) {
        }
    }
}
