package com.books.book.model;

import com.books.book.model.Genre;

import java.util.Date;

public class BookDto {
    private String nameBook;
    private String author;
    private Date yearPublication;
    private Genre genre;
    private String linkAccess;

    public BookDto(String nameBook, String author, Date yearPublication, Genre genre, String linkAccess) {
        this.nameBook = nameBook;
        this.author = author;
        this.yearPublication = yearPublication;
        this.genre = genre;
        this.linkAccess = linkAccess;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(Date yearPublication) {
        this.yearPublication = yearPublication;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getLinkAccess() {
        return linkAccess;
    }

    public void setLinkAccess(String linkAccess) {
        this.linkAccess = linkAccess;
    }
}
