package com.restapi.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingRequest {
    private String borrowerName;
    private String borrowerMail;
    private LocalDate borrowingDate;
    private BookForBorrowingRequest bookForBorrowingRequest;
}
