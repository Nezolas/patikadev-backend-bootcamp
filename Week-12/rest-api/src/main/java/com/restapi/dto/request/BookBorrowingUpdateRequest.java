package com.restapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookBorrowingUpdateRequest {
    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
}
