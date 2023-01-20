package com.example.BookAuthor.Service;


import com.example.BookAuthor.Convertors.AuthorConvertor;
import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Repository.AuthorRepository;
import com.example.BookAuthor.Repository.BookRepository;
import com.example.BookAuthor.RequestDto.AuthorRequestDto;
import com.example.BookAuthor.ResponseDto.AuthorResponseDto;
import com.example.BookAuthor.RequestDto.BookRequestDto;
import com.example.BookAuthor.ResponseDto.BookResponseDto;
import com.example.BookAuthor.Updates.UpdateAuthor;
import com.example.BookAuthor.Updates.UpdateBookPages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String createAuthor(AuthorRequestDto authorRequestDto){

        try {
            Author author = AuthorConvertor.convertDtoToEntity(authorRequestDto);
            authorRepository.save(author);
        }catch (Exception e){
            log.info("createAuthor has caused an error");
            return "Create author didn't work";
        }
        return "Author created successfully";
    }

    public List<AuthorResponseDto> findAuthorByName(String name){
        List<Author> authors = authorRepository.findByName(name);
        List<AuthorResponseDto> authorResponseDtos = AuthorConvertor.convertEntityToDto(authors);
        return authorResponseDtos;
    }
    public void updateAuthor(UpdateAuthor updateAuthor){
        int id = updateAuthor.getId();
        Author authorToBeUpdated = authorRepository.findById(id).get();
        authorToBeUpdated.setName(updateAuthor.getName());
        authorToBeUpdated.setCountry(updateAuthor.getCountry());
        authorRepository.save(authorToBeUpdated);
    }

    public void deleteAuthorById(int id){
        authorRepository.deleteById(id);
    }
}
