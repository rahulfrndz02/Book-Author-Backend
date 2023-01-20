package com.example.BookAuthor.Controller;

import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Repository.AuthorRepository;
import com.example.BookAuthor.RequestDto.AuthorRequestDto;
import com.example.BookAuthor.ResponseDto.AuthorResponseDto;
import com.example.BookAuthor.Service.AuthorService;
import com.example.BookAuthor.Updates.UpdateAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @Autowired
    private AuthorRepository authorRepository;

    //adding author
    @PostMapping("/add")
    public String createAuthor(@RequestBody() AuthorRequestDto authorRequestDto){
        return authorService.createAuthor(authorRequestDto);
    }

    //finding author
    @GetMapping("/find/{name}") //author/findBy/Sumit
    public List<AuthorResponseDto> findByName(@PathVariable() String name){
        return authorService.findAuthorByName(name);
    }

    //update author details
    @PutMapping("/update")
    public void updateAuthor(@RequestBody UpdateAuthor updateAuthor){
        authorService.updateAuthor(updateAuthor);
    }

    //delete author
    @DeleteMapping("/delete")  //author/delete?id=6
    public void deleteAuthorById(@RequestParam("id") int id){
        authorService.deleteAuthorById(id);
    }
}
