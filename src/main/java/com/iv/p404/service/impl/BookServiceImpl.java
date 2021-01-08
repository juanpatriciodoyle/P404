package com.iv.p404.service.impl;

import com.iv.p404.model.Book;
import com.iv.p404.model.BookType;
import com.iv.p404.repository.BookRepository;
import com.iv.p404.service.BookService;
import com.iv.p404.to.ReturnTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * Process that saves in a db a Book
     */
    @Override
    public Optional<Book> save(Book book) {
        Book bookSaved = bookRepository.save(book);
        return Optional.of(bookSaved);
    }

    /**
     * Process that looks up the Book in the db by id and brings it
     *
     * @param id -> id of Book
     * @return Empty when there is no book or not quantity of it
     * The book when is available and decrees the quantity by 1
     */
    @Override
    public Optional<Book> rent(Integer id) {
        Optional<Book> bookSaved = bookRepository.getAvailableBookById(id);
        if (bookSaved.isEmpty()) return Optional.empty();
        bookSaved.get().setQuantity(bookSaved.get().getQuantity() - 1);
        save(bookSaved.get());
        return bookSaved;

    }

    /**
     * Process that looks up the Book in the db by id and add 1 to the quantity before saving it
     *
     * @param id -> id of Book
     * @return ReturnTO with the error if there is any
     */
    @Override
    public ReturnTO returnBook(Integer id) {
        Optional<Book> bookSaved = bookRepository.getBookById(id);
        if (bookSaved.isPresent()) {
            bookSaved.get().setQuantity(bookSaved.get().getQuantity() + 1);
            save(bookSaved.get());
        } else {
            return ReturnTO.builder().error("Book not found").build();
        }
        return ReturnTO.builder().build();
    }

    /**
     * Process that takes 1 unit of quality to each book in db
     */
    @Override
    public void degradeBooks() {
        bookRepository.degrade(BookType.Standard.ordinal(),1);
        bookRepository.degrade(BookType.Comics.ordinal(),2);
        bookRepository.deleteOldBooks();
    }

}
