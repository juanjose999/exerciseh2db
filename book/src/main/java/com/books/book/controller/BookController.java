package com.books.book.controller;

import com.books.book.Dto.BookResponseDto;
import com.books.book.model.BookDto;
import com.books.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponseDto>>findAllUser() {
        List<BookResponseDto> bookList = bookService.findAllBook();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> findBookById(@PathVariable Long idBook){
        try {
            return new ResponseEntity<>(bookService.findBookById(idBook), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity("El libro " + idBook + " no fue encontrado en la base de datos.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> create(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.create(bookDto), HttpStatus.CREATED);
    }

    @PutMapping("/{idBook}")
    public ResponseEntity<Boolean> update(@PathVariable Long idBook, @RequestBody BookDto bookDto){
        try{
            Boolean updateBook = bookService.update(idBook, bookDto);
            if(updateBook){
                return new ResponseEntity("The book update ok.", HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("The book not exist in data base.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idBook}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idBook){
        return new ResponseEntity<>(bookService.delete(idBook), HttpStatus.OK);
    }
}
