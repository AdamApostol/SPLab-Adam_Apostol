package com.example.library.pattern.chain;

import com.example.library.entity.Book;
import com.example.library.repo.BookRepository;

import java.util.Map;

public class PersistenceHandler extends BookRequestHandler {

    private final BookRepository repository;

    public PersistenceHandler(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Object handle(Map<String, Object> request) {
        String operation = (String) request.get("operation");
        System.out.println("PersistenceHandler: Handling " + operation + " operation");

        switch (operation) {
            case "GET":
                Long id = (Long) request.get("id");
                return repository.findById(id).orElse(null);

            case "CREATE":
                Book created = (Book) request.get("book");
                System.out.println("PersistenceHandler: CREATE handled for ID " + created.getId());
                return created;

            case "UPDATE":
                Book updated = (Book) request.get("book");
                System.out.println("PersistenceHandler: UPDATE handled for ID " + updated.getId());
                return updated;

            case "DELETE":
                Long deleteId = (Long) request.get("id");
                System.out.println("PersistenceHandler: DELETE handled for ID " + deleteId);
                return true;

            default:
                System.out.println("PersistenceHandler: Unknown operation");
                return passToNext(request);
        }
    }
}
