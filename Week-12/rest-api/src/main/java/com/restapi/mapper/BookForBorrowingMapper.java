package com.restapi.mapper;

import com.restapi.dto.request.BookForBorrowingRequest;
import com.restapi.entitiy.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookForBorrowingMapper {
    Book asEntity(BookForBorrowingRequest bookForBorrowingRequest);
}
