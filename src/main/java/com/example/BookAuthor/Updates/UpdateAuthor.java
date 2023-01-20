package com.example.BookAuthor.Updates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthor {
    private int id;
    private String name;
    private String country;
}


