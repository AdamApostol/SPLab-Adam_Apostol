package com.example.library.helper.strategy;

import com.example.library.entity.Book;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void add(Book book);
}
