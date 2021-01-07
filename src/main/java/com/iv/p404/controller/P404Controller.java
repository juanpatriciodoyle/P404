package com.iv.p404.controller;

import com.iv.p404.model.Book;
import com.iv.p404.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Log
@RestController
@RequiredArgsConstructor
public class P404Controller implements P404ControllerApi {

    private final BookService bookService;

    /** Creates and returns the new Book requested **/
    @Override
    public ResponseEntity<Book> savePermission(Book book) {
        Optional<Book> savedBook = bookService.save(book);
        if (savedBook.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(savedBook.get(), HttpStatus.ACCEPTED);
    }
}
