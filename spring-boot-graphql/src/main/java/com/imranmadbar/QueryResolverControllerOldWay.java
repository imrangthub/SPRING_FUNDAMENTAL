//
//package com.imranmadbar;
//
//
//
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class QueryResolverControllerOldWay implements GraphQLQueryResolver {
//
//    private final BookRepository bookRepository;
//    private final AuthorRepository authorRepository;
//
//    public QueryResolverControllerOldWay(BookRepository bookRepository, AuthorRepository authorRepository) {
//        this.bookRepository = bookRepository;
//        this.authorRepository = authorRepository;
//    }
//
//    public Book getFirstBook() {
//        return bookRepository.getFirstBook();
//    }
//
//    public Book bookById(String id) {
//        return bookRepository.getById(id).orElse(null);
//    }
//
//    public List<Book> allBooks() {
//        return bookRepository.getAllBooks();
//    }
//
//    public Author author(Book book) {
//        return authorRepository.getById(book.getAuthorId()).orElse(null);
//    }
//}



