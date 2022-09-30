package com.example.postgrecrud.mapstruct.mappers;

import com.example.postgrecrud.mapstruct.dto.*;
import com.example.postgrecrud.model.Author;
import com.example.postgrecrud.model.Book;
import com.example.postgrecrud.model.User;
import lombok.extern.apachecommons.CommonsLog;
import org.mapstruct.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*
*********
By setting the componentModel attribute
to spring, the MapStruct processor will
produce a singleton Spring Bean mapper
injectable wherever you need.
**********
 */

@Mapper(componentModel = "spring")
@Service
public interface MapStructMapper {
    BookSlimDto bookToBookSlimDto(Book book);

    BookDto bookToBookDto(Book book);

    AuthorDto authorToAuthorDto(Author author);

    AuthorAllDto authorToAuthorAllDto(Author author);

    List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);

    UserGetDto userToUserGetDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);
}
