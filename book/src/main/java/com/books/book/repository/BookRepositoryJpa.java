package com.books.book.repository;import org.springframework.data.jpa.repository.JpaRepository;
import com.books.book.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoryJpa extends JpaRepository <Book, Long>{
}
