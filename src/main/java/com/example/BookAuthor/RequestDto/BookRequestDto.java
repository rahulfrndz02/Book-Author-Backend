package com.example.BookAuthor.RequestDto;

import com.example.BookAuthor.Enums.Genre;
import lombok.Data;


@Data //providing getters and setters
public class BookRequestDto {
    
    private String name;

    private int pages;

    private Genre genre;

    private int authorId;

}