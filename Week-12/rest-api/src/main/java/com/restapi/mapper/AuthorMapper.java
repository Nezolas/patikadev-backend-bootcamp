package com.restapi.mapper;

import com.restapi.dto.request.AuthorRequest;
import com.restapi.dto.response.AuthorResponse;
import com.restapi.entitiy.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Configuration;


import javax.swing.*;
import java.util.List;
@Configuration
@Mapper(componentModel = "spring")

public interface AuthorMapper {
    Author asEntity(AuthorRequest authorRequest);

    AuthorResponse asOutput(Author author);

    List<AuthorResponse> asOutput(List<Author> author);

    void update(@MappingTarget Author entity, AuthorRequest request);
}
