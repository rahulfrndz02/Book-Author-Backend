package com.example.BookAuthor.Controller;


import ch.qos.logback.core.model.Model;
import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Repository.BookRepository;
import com.example.BookAuthor.Updates.UpdateBookPages;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.example.BookAuthor.RequestDto.BookRequestDto;
import com.example.BookAuthor.ResponseDto.AuthorResponseDto;
import com.example.BookAuthor.ResponseDto.BookResponseDto;
import com.example.BookAuthor.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    //adding new book
    @PostMapping("/add")
    public String createBook(@RequestBody() BookRequestDto bookRequestDto){
        return bookService.createBook(bookRequestDto);
    }

    //finding books
    @GetMapping("/get_book/{id}")
    public BookResponseDto getBook(@PathVariable Integer id){
        try {
            return bookService.getBookById(id);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //updating books pages
    @PutMapping("/update_pages")
    public void updateBookPages(@RequestBody UpdateBookPages updateBookPages) {
        bookService.updateBookPages(updateBookPages);
    }

    //deleting book
    @DeleteMapping("/delete/{id}")   //delete/id
    public void deleteBook(@PathVariable("id") Integer id) {
        try {
            bookService.deleteBookById(id);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
