package com.books.book.repository.h2;

import com.books.book.model.Book;
import com.books.book.repository.BookRepository;
import com.books.book.repository.BookRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryH2 implements BookRepository {
    @Autowired
    private BookRepositoryJpa bookRepository;
    @Override
    public List findAllBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long idBook) {
        return bookRepository.findById(idBook);
    }

    @Override
    public Book create(Book book) {
        return (Book) bookRepository.save(book);
    }

    @Override
    public Boolean update(Long idBook, Book book) {
        Optional<Book> bookUpdate =  findBookById(idBook);
        if(bookUpdate.isPresent()){
            Book existingBook = bookUpdate.get();

            existingBook.setNameBook(book.getNameBook());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setYearPublication(book.getYearPublication());
            existingBook.setGenre(book.getGenre());
            existingBook.setLinkAccess(book.getLinkAccess());
            existingBook.setCreate(book.getCreate());
            existingBook.setUpdate(LocalDateTime.now());

            bookRepository.save(existingBook);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Long idBook) {
        if (bookRepository.existsById(idBook)){
            bookRepository.deleteById(idBook);
            return  true;
        }
        return false;
    }
}
