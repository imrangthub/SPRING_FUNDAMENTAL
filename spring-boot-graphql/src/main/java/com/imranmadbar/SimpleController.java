package com.imranmadbar;


import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SimpleController {

    private final BookRepository bookRepository;
    
    private final AuthorRepository authorRepository;

    public SimpleController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository=authorRepository;
    }

    
    @QueryMapping
    public Book getFirstBook() {
        return bookRepository.getFirstBook();
    }

    
  
    
    // Query to fetch a book by its ID
    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookRepository.getById(id).orElse(null);
    }

    // Query to fetch all books
    @QueryMapping
    public List<Book> allBooks() {
        return bookRepository.getAllBooks();
    }
    
   
   
    
    

	/*
	 * // Mutation to delete a book by its ID
	 * 
	 * @MutationMapping public boolean deleteBookById(@Argument String id) { return
	 * bookRepository.deleteById(id); }
	 */
    
    
    @SchemaMapping
    public Author author(Book book) {
        return authorRepository.getById(book.getAuthorId());  // Assuming AuthorRepository is available
    }
    
    
    
    
    
}