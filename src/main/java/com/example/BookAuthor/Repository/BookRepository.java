package com.example.BookAuthor.Repository;


import com.example.BookAuthor.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByName(String name);

}