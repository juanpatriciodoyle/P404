package com.iv.p404.service;

import com.iv.p404.model.Book;
import com.iv.p404.model.Customer;
import com.iv.p404.to.ReturnTO;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> save(Customer customer);
    ReturnTO rent(Integer customerId, Book book);
    ReturnTO returnBook(Integer customerId, Integer bookId);
}