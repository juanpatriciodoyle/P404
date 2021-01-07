package com.iv.p404.service.impl;

import com.iv.p404.model.Book;
import com.iv.p404.service.BookService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {


    @Override
    public Optional<Book> save(Book book) {
        /*
        *Process that saves in a db
        */
        return Optional.of(book);
    }
}
