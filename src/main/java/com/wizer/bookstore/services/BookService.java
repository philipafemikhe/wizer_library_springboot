package com.wizer.bookstore.services;

import com.wizer.bookstore.Models.Book;
import com.wizer.bookstore.Models.Category;
import com.wizer.bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book save(Book thisBook) {
        return this.bookRepository.save(thisBook);
    }

    public Book getById(Long id) {
        return this.bookRepository.findById(id).get();
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    public void delete(Book book) {
        this.bookRepository.delete(book);
    }
}
