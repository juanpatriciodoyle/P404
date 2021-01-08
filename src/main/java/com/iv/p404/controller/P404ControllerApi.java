package com.iv.p404.controller;

import com.iv.p404.model.Book;
import com.iv.p404.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/bookToHome")
public interface P404ControllerApi {


    @RequestMapping(value = "/book",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Book> saveBook(@RequestBody Book permission);

    @RequestMapping(value = "/customer",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer);

    @RequestMapping(value = "/rent",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<String> rent(@RequestParam(name = "customer") Integer customerId, @RequestParam(name = "book") Integer bookId);

    @RequestMapping(value = "/returnBook",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<String> returnBook(@RequestParam(name = "customer") Integer customerId, @RequestParam(name = "book") Integer bookId);







}
