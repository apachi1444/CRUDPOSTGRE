package com.example.postgrecrud.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

/*
******
*
*
UserPostDto is going to be used
while passing the data required
to persist a new User to the Spring
Boot application.
 *
 *
 * */

@Getter
@Setter
public class UserPostDto {
    @JsonProperty("id")
    private int id;

//    @Email
    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;
}
