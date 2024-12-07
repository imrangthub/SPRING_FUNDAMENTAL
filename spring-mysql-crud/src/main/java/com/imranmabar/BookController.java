package com.imranmabar;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping("/book")
	public List getBookList() {
		return bookRepository.findAll();
	}

	@GetMapping("/find-by-id")
	public Optional<BookEntity> getBookList(@RequestParam Long id) {
		return bookRepository.findById(id);
	}
	
	  // Save a new book or update an existing one using GET request
    @GetMapping("/save")
    public BookEntity saveOrUpdateBook(@RequestParam(required = false) Long id,
                                       @RequestParam String name,
                                       @RequestParam String type) {
        BookEntity bookEntity;

        if (id != null) {
            // Update the existing book if ID is provided
            bookEntity = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
            bookEntity.setName(name);
            bookEntity.setType(type);
        } else {
            // Save a new book if no ID is provided
            bookEntity = new BookEntity();
            bookEntity.setName(name);
            bookEntity.setType(type);
        }

        return bookRepository.save(bookEntity);
    }
	
	@PostMapping("/save1")
    public BookEntity saveOrUpdateBook(BookEntity bookEntity) {
        // Check if the book has an ID (if yes, it means it's an update)
        if (bookEntity.getId() > 0) {
            // Update the existing book, it will automatically update because of JPA's merging behavior
            return bookRepository.save(bookEntity);
        } else {
            // Save new book
            return bookRepository.save(bookEntity);
        }
    }

}
