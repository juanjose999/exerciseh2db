package com.books.book.Dto;
import com.books.book.model.Book;
import com.books.book.model.BookDto;

public class BookMapper {
    public static BookResponseDto bookToBookResponseDto(Book book) {
        return new BookResponseDto(
                book.getIdBook(),
                book.getNameBook(),
                book.getAuthor(),
                book.getYearPublication(),
                book.getGenre(),
                book.getLinkAccess()
        );
    }

    public static Book bookDtoToBook(BookDto bookDto){
        return new Book(
                bookDto.getNameBook(),
                bookDto.getAuthor(),
                bookDto.getYearPublication(),
                bookDto.getGenre(),
                bookDto.getLinkAccess()
        );
    }
}
