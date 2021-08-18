package com.wizer.bookstore.controllers;

import com.wizer.bookstore.Models.Book;
import com.wizer.bookstore.Models.Favorite;
import com.wizer.bookstore.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public Favorite addToFavorite(@RequestBody Book book){
        Favorite favorite = this.favoriteService.addBookToFavorite(book);
        return  favorite;
    }

    @GetMapping("/list")
    public List<Favorite> getFavorites(){
        return this.favoriteService.getAll();
    }
}
