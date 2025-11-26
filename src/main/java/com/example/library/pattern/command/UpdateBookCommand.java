package com.example.library.pattern.command;

import com.example.library.entity.Book;
import com.example.library.repo.BookRepository;

public class UpdateBookCommand implements Command {

    private final BookRepository repository;
    private final Long id;
    private final Book newBook;
    private Book oldBook;

    public UpdateBookCommand(BookRepository repository, Long id, Book newBook) {
        this.repository = repository;
        this.id = id;
        this.newBook = newBook;
    }

    @Override
    public void execute() {
        oldBook = repository.findById(id).orElse(null);
        if (oldBook != null) {
            newBook.setId(id);
            repository.save(newBook);
            System.out.println("Command: Book updated with ID " + id);
        } else {
            System.out.println("Command: Book with ID " + id + " not found");
        }
    }

    @Override
    public void undo() {
        if (oldBook != null) {
            repository.save(oldBook);
            System.out.println("Command: Book update undone for ID " + id);
        }
    }
}
