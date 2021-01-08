package com.iv.p404.controller;

import com.iv.p404.model.Book;
import com.iv.p404.model.BookType;
import com.iv.p404.model.Customer;
import com.iv.p404.service.BookService;
import com.iv.p404.service.CustomerService;
import com.iv.p404.to.ReturnTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log
@RestController
@RequiredArgsConstructor
@EnableScheduling
public class P404Controller implements P404ControllerApi {

    private final BookService bookService;
    private final CustomerService customerService;

    /**
     * Creates and returns the new Book requested
     **/
    @Override
    public ResponseEntity<Book> saveBook(Book book) {
        Optional<Book> savedBook = bookService.save(book);
        if (savedBook.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(savedBook.get(), HttpStatus.ACCEPTED);
    }

    /**
     * Creates and returns a new Customer
     * */
    @Override
    public ResponseEntity<Customer> saveCustomer(Customer customer) {
        Optional<Customer> savedBook = customerService.save(customer);
        if (savedBook.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(savedBook.get(), HttpStatus.ACCEPTED);
    }

    /**
     * Function that represents the operation of renting a book by a specific customer
     * */
    @Override
    public ResponseEntity<String> rent(Integer customerId, Integer bookId) {
        Optional<Book> bookRented = bookService.rent(bookId);
        if (bookRented.isEmpty()) return new ResponseEntity<>("Book unavailable", HttpStatus.BAD_REQUEST);

        ReturnTO returnTO = customerService.rent(customerId, bookRented.get());
        if (returnTO.getError() != null) return new ResponseEntity<>(returnTO.getError(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(bookRented.get().getTitle() + " rented to " + returnTO.getCustomer().getName(), HttpStatus.ACCEPTED);

    }

    /**
     * Function that represents the operation of returning a book by a certain customer
     * */
    @Override
    public ResponseEntity<String> returnBook(Integer customerId, Integer bookId) {
        ReturnTO returnCustomer = customerService.returnBook(customerId, bookId);
        if (returnCustomer.getError() != null)
            return new ResponseEntity<>(returnCustomer.getError(), HttpStatus.BAD_REQUEST);

        ReturnTO returnBook = bookService.returnBook(bookId);
        if (returnBook.getError() != null) return new ResponseEntity<>(returnBook.getError(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>("Book returned", HttpStatus.ACCEPTED);
    }

    /**
     * Returns books that are in minimum stock
     * */
    @Override
    public ResponseEntity<List<Book>> minimumStock() {
        List<Book> bookList = bookService.minimumStock();
        if (bookList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(bookList, HttpStatus.ACCEPTED);
    }

    /**
     * Degrade Standard books
     * */
    @Scheduled(fixedDelay = 86400000)
    private void standardDegrade() {
        bookService.degrade(BookType.Standard);
    }

    /**
     * Degrade Comic books
     * */
    @Scheduled(fixedDelay = 43200000)
    private void comicDegrade() {
        bookService.degrade(BookType.Comics);
    }

    /**
     * Enhance Collector's Edition books
     * */
    @Scheduled(fixedDelay = 86400000)
    private void enhance() {
        bookService.enhance(BookType.CollectorEdition);
    }
}
