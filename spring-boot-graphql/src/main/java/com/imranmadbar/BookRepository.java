package com.imranmadbar;

import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private final List<Book> books = Arrays.asList(
        new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
        new Book("book-2", "Moby Dick", 635, "author-2"),
        new Book("book-3", "Interview with the Vampire", 371, "author-3")
    );

    // Method to get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Method to get a book by ID
    public Optional<Book> getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }
    
    // Method to get a book by ID
    public Book getFirstBook() {
        return books.get(0);
    }
}