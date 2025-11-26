package com.example.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.library.helper.strategy.RenderContext;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Transient
    private List<Element> elements = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @Transient
    private TableOfContents tableOfContents = new TableOfContents("Cuprins auto-generat");

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element e) {
        elements.add(e);
    }

    public void removeContent(Element e) {
        elements.remove(e);
    }

    public Element getContent(int index) {
        return elements.get(index);
    }

    @Transient
    public void print(RenderContext context) {
        context.println("Book: " + title);
        context.println("Authors:");
        RenderContext authorCtx = context.withIndent("  ");
        for (Author a : authors) {
            authorCtx.println("- " + a.getName() + " " + a.getSurname());
        }

        context.println("Contents:");
        RenderContext childCtx = context.withIndent("  ");
        for (Element e : elements) {
            e.print(childCtx);
        }
    }
}
