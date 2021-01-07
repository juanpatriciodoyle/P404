package com.iv.p404.controller;

import com.iv.p404.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path = "/bookToHome")
public interface P404ControllerApi {


    @RequestMapping(value = "/book",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Book> savePermission(@RequestBody Book permission);
}
