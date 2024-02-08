package com.books.book.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "books library")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;
    @Column(name = "name_book")
    private String nameBook;
    @Column(name = "author")
    private String author;
    @Column(name = "year_publication")
    private Date yearPublication;
    @Column(name = "genre_book")
    private Genre genre;
    @Column(name = "link_to_access")
    private String linkAccess;
    private LocalDateTime create;
    private LocalDateTime update;
    public Book(){

    }
//contructor sin id por que este se genera automaticmante

    public Book(String nameBook, String author, Date yearPublication, Genre genre, String linkAccess) {
        this.nameBook = nameBook;
        this.author = author;
        this.yearPublication = yearPublication;
        this.genre = genre;
        this.linkAccess = linkAccess;
        this.create = LocalDateTime.now();
        this.update = null;
    }

    public Long getIdBook() {
        return idBook;
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

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public LocalDateTime getUpdate() {
        return update;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }
}
