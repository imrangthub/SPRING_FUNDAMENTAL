package com.imranmabar;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
