package com.example.postgrecrud.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/*
******
*
*
UserGetDto will be used to expose the data of
* a specific user to the client application and
* does not require a password field.
 *
 *
 * */

@Getter
@Setter
public class UserGetDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;
}
