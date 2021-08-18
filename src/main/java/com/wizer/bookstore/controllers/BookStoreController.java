package com.wizer.bookstore.controllers;

import com.wizer.bookstore.Models.Book;
import com.wizer.bookstore.services.BookService;
import com.wizer.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("")
public class BookStoreController
{

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    private String welcome(){
        return "Welcome";
    }
    @GetMapping("/bookstore")
    public List<Book> index(){
    return  null;
    }
}
