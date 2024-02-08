package com.books.book.repository;

import com.books.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List <List<Book>> findAllBook();
    Optional<Book> findBookById(Long idBook);
    Book create(Book book);
    Boolean update(Long idBook, Book book);
    Boolean delete(Long idBook);
}
