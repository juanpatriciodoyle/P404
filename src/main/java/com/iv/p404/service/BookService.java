package com.iv.p404.service;

import com.iv.p404.model.Book;
import java.util.Optional;

public interface BookService {
    Optional<Book> save(Book book);
}
