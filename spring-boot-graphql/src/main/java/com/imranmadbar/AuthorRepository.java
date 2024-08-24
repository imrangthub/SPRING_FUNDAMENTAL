package com.imranmadbar;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

   public List<Author> authors = Arrays.asList(
        new Author("author-1", "Joanne", "Rowling"),
        new Author("author-2", "Herman", "Melville"),
        new Author("author-3", "Anne", "Rice")
    );

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
}