package com.example.library.helper.strategy;

import com.example.library.entity.Book;

public interface Observer {
    void update(Book book);
}

