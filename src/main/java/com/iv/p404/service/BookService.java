package com.iv.p404.service;

import com.iv.p404.model.Book;
import com.iv.p404.model.BookType;
import com.iv.p404.to.ReturnTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> save(Book book);
    Optional<Book> rent(Integer id);
    ReturnTO returnBook(Integer id);
    void degrade(BookType bookType);
    void enhance(BookType bookType);
    List<Book> minimumStock();
}
