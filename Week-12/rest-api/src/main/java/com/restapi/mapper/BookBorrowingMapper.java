package com.restapi.mapper;

import com.restapi.dto.request.BookBorrowingRequest;
import com.restapi.dto.request.BookBorrowingUpdateRequest;
import com.restapi.entitiy.BookBorrowing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookBorrowingMapper {
    BookBorrowing asEntity(BookBorrowingRequest bookBorrowingRequest);

    BookBorrowing asEntity(BookBorrowingUpdateRequest bookBorrowingUpdateRequest);

    void update(@MappingTarget BookBorrowing entity, BookBorrowingUpdateRequest bookBorrowingUpdateRequest);
}
