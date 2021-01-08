package com.iv.p404.service.impl;

import com.iv.p404.model.Book;
import com.iv.p404.model.Customer;
import com.iv.p404.repository.BookRepository;
import com.iv.p404.repository.CustomerRepository;
import com.iv.p404.service.CustomerService;
import com.iv.p404.to.ReturnTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Process that saves in a db a Customer
     */
    @Override
    public Optional<Customer> save(Customer customer) {
        Customer customerSaved = customerRepository.save(customer);
        return Optional.of(customerSaved);
    }

    /**
     * Process that looks up the customer in the db by id and brings it
     *
     * @param customerId -> id of Customer
     * @param book       -> Book
     * @return Empty when it didn't find the customer in db
     * The Customer when is available and assigns the book to the list of rented books of this customer
     */
    @Override
    public ReturnTO rent(Integer customerId, Book book) {
        Optional<Customer> customerSaved = customerRepository.getCustomerById(customerId);
        if (customerSaved.isEmpty()) return ReturnTO.builder().error("Customer not found").build();
        customerSaved.get().getBookList().add(book);
        save(customerSaved.get());
        return ReturnTO.builder()
                .customer(customerSaved.get())
                .book(book)
                .build();
    }

    /**
     * Process that looks up the customer in the db by id and takes out the desired book from its list
     *
     * @param customerId -> id of Customer
     * @param bookId     -> id of Book
     * @return ReturnTO with the error if there is any
     */
    @Override
    public ReturnTO returnBook(Integer customerId, Integer bookId) {
        Optional<Customer> customerSaved = customerRepository.getCustomerById(customerId);
        if (customerSaved.isEmpty()) return ReturnTO.builder().error("Customer not found").build();
        List<Book> bookList = customerSaved.get().getBookList().stream().filter(book -> !book.getId().equals(bookId)).collect(Collectors.toList());
        customerSaved.get().setBookList(bookList);
        save(customerSaved.get());
        return ReturnTO.builder().build();
    }

}
