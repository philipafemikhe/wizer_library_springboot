package com.wizer.bookstore.services;

import com.wizer.bookstore.Models.Book;
import com.wizer.bookstore.Models.Favorite;
import com.wizer.bookstore.Repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorite addBookToFavorite(Book book){
        Favorite favorite =  new Favorite();
        favorite.setBook(book);
        this.favoriteRepository.save(favorite);
        return favorite;
    }

    public List<Favorite> getAll() {
        return this.favoriteRepository.findAll();
    }
}
