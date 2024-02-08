package com.books.book.service;

import com.books.book.Dto.BookMapper;
import com.books.book.Dto.BookResponseDto;
import com.books.book.model.Book;
import com.books.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.books.book.model.BookDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<BookResponseDto> findAllBook() {
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        bookRepository.findAllBook().forEach(book -> bookResponseDtos.add(BookMapper.bookToBookResponseDto((Book) book)));
        return bookResponseDtos;
    }

    @Override
    public BookResponseDto findBookById(Long idBook) {
        Optional<Book> optionalBook = bookRepository.findBookById(idBook);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return BookMapper.bookToBookResponseDto(book);
        } else {
            // Puedes manejar la situación en la que no se encuentra el libro.
            // Por ejemplo, puedes lanzar una excepción o devolver un valor predeterminado.
            return null; // O lanza una excepción o devuelve un valor predeterminado.
        }
    }

    @Override
    public BookResponseDto create(BookDto bookDto) {
        return BookMapper.bookToBookResponseDto(bookRepository.create(BookMapper.bookDtoToBook(bookDto)));
    }

    @Override
    public Boolean update(Long idBook, BookDto bookDto) {
        return bookRepository.update(idBook, BookMapper.bookDtoToBook(bookDto));
    }

    @Override
    public Boolean delete(Long idBook) {
        return bookRepository.delete(idBook);
    }
}
