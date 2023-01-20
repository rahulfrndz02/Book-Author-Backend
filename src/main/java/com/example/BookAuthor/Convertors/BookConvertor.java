package com.example.BookAuthor.Convertors;

import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.RequestDto.BookRequestDto;

public class BookConvertor {

    //converting dto to entity
    public static Book convertDtoToEntity(BookRequestDto bookRequestDto){
        Book book = Book.builder().
                name(bookRequestDto.getName()).
                pages(bookRequestDto.getPages()).
                genre(bookRequestDto.getGenre()) .build();
        return book;
    }
}
