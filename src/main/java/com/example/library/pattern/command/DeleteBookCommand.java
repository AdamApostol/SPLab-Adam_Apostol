package com.example.library.pattern.command;

import com.example.library.entity.Book;
import com.example.library.repo.BookRepository;

public class DeleteBookCommand implements Command {

    private final BookRepository repository;
    private final Long id;
    private Book deletedBook;

    public DeleteBookCommand(BookRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }

    @Override
    public void execute() {
        deletedBook = repository.findById(id).orElse(null);
        if (deletedBook != null) {
            repository.deleteById(id);
            System.out.println("Command: Book deleted with ID " + id);
        } else {
            System.out.println("Command: Book with ID " + id + " not found");
        }
    }

    @Override
    public void undo() {
        if (deletedBook != null) {
            repository.save(deletedBook);
            System.out.println("Command: Book deletion undone for ID " + id);
        }
    }
}
