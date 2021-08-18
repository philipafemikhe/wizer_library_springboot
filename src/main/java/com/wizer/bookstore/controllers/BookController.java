package com.wizer.bookstore.controllers;

import com.wizer.bookstore.Models.Book;
import com.wizer.bookstore.Models.Category;
import com.wizer.bookstore.Models.Favorite;
import com.wizer.bookstore.Repository.BookRepository;
import com.wizer.bookstore.Repository.CategoryRepository;
import com.wizer.bookstore.services.BookService;
import com.wizer.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/book")
public class BookController {
    int sn;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Book> index(){
        return this.bookService.findAll();
    }

    @PostMapping()
    public Book addBook(@RequestBody Book book){
       return this.bookService.save(book);
    }
    @GetMapping("/id")
    public Book getBook(@PathVariable Long id){
        return this.bookService.getById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        Book thisBook = this.bookService.getById(id);
        if(book != null){
            thisBook.setAuthor(book.getAuthor());
            thisBook.setTitle(book.getTitle());
            thisBook.setDescription(book.getDescription());
            return this.bookService.save(thisBook);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        Book book = this.bookService.getById(id);
        if(book != null) this.bookService.delete(book);
        return "Book Deleted";
    }

    @PutMapping("/{bookId}/{categoryId}")
    public Book addBookToCategory(@PathVariable Long bookId, @PathVariable Long categoryId){
        Category category = this.categoryService.getCategoryById(categoryId);
        System.out.println(category.toString());
        Book book = this.bookService.getById(bookId);
        System.out.println(book.toString());

        if((category != null) && (book != null)){
            book.setCategory(category);
        }
        return book != null ? book : null;
    }

    @GetMapping("/categorize/{categoryId}")
    public List<Book> setCategory(@RequestBody List<Book> books, @PathVariable Long categoryId){
        Category category = this.categoryService.getCategoryById(categoryId);
        List<Book> updatedBooks = new ArrayList<>();
        if(category != null){
            for (Book book1: books) {
                Book book = this.bookService.getById(book1.getId());
                book.setCategory(category);
                updatedBooks.add(book);
                this.bookService.save(book);
            }
        }
       return updatedBooks;
    }
}
