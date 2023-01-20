package com.example.BookAuthor.Convertors;

import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.RequestDto.AuthorRequestDto;
import com.example.BookAuthor.ResponseDto.AuthorResponseDto;

import java.util.ArrayList;
import java.util.List;
public class AuthorConvertor {


    //converting dto to entity
    public static Author convertDtoToEntity(AuthorRequestDto authorRequestDto){

        Author author = Author.builder().
                name(authorRequestDto.getName())
                .age(authorRequestDto.getAge()).country(authorRequestDto.getCountry())
                .email(authorRequestDto.getEmail()).build();
        return author;
    }

    //converting entity to dto
    public static List<AuthorResponseDto> convertEntityToDto(List<Author>authors){
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();
        for(Author author: authors){
            AuthorResponseDto authorRequestDto = AuthorResponseDto.builder().id(author.getId()).name(author.getName()).age(author.getAge())
                    .country(author.getCountry()).email(author.getEmail()).build();
            authorResponseDtoList.add(authorRequestDto);
        }
        return authorResponseDtoList;
    }
}
