package com.restapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookForBorrowingRequest {
    private Long id;
    private String name;
    private int publicationYear;
    private int stock;
}
