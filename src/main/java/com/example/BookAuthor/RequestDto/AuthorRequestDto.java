package com.example.BookAuthor.RequestDto;

import jakarta.persistence.Column;
import lombok.Data;


@Data //provides getters and setters
public class AuthorRequestDto {

    private String name;

    private int age;

    private String country;

    @Column(unique = true)
    private String email;


}