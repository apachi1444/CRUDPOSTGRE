package com.example.postgrecrud.controller;

import com.example.postgrecrud.mapstruct.dto.UserGetDto;
import com.example.postgrecrud.mapstruct.dto.UserPostDto;
import com.example.postgrecrud.mapstruct.mappers.MapStructMapper;
import com.example.postgrecrud.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MapStructMapper mapstructMapper;

    @Autowired
    private UserRepository userRepository;



    @PostMapping()
    public ResponseEntity<Void> create(
            @Validated @RequestBody UserPostDto userPostDto
    ) {
        userRepository.save(
                mapstructMapper.userPostDtoToUser(userPostDto)
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getById(
            @PathVariable(value = "id") int id
    ) {
        return new ResponseEntity<>(
                mapstructMapper.userToUserGetDto(
                        userRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

}
