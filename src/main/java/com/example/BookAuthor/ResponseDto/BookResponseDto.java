package com.example.BookAuthor.ResponseDto;


import com.example.BookAuthor.Enums.Genre;
import com.example.BookAuthor.Models.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    String name;
    int pages;
    Genre genre;
    //AuthorResponseDto authorResponseDto = new AuthorResponseDto();
    //String authorName = authorResponseDto.getName();
   // Author author = new Author();
    String authorName = getAuthorName();
}
