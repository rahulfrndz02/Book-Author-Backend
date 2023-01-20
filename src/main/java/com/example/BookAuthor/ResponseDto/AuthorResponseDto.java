package com.example.BookAuthor.ResponseDto;
import com.example.BookAuthor.Models.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {

    private int id;

    private String name;

    private int age;

    private String country;

    private String email;

    private List<Book> books;


}
