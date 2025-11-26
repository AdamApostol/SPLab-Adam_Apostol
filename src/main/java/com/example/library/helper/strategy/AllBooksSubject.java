package com.example.library.helper.strategy;

import com.example.library.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class AllBooksSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private final List<Book> items = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void add(Book book) {
        items.add(book);
        notifyObservers(book);
    }

    private void notifyObservers(Book book) {
        for (Observer o : observers) {
            o.update(book);
        }
    }
}
