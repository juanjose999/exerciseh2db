package com.books.book.service;

import com.books.book.Dto.BookResponseDto;

import java.util.List;

import com.books.book.model.BookDto;

public interface BookService {
    List <BookResponseDto> findAllBook();
    BookResponseDto findBookById(Long idBook);
    BookResponseDto create(BookDto book);
    Boolean update(Long idBook, BookDto bookDto);
    Boolean delete(Long idBook);
}
