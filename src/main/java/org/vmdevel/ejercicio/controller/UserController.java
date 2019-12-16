package org.vmdevel.ejercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.vmdevel.ejercicio.dto.UserDto;
import org.vmdevel.ejercicio.domain.User;
import org.vmdevel.ejercicio.dto.UserResponseDto;
import org.vmdevel.ejercicio.exception.RegisteredEmailException;
import org.vmdevel.ejercicio.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConversionService conversionService;

    @PostMapping(value = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody @Valid UserDto user) throws RegisteredEmailException {
        return conversionService.convert(
                userService.createUser(conversionService.convert(user, User.class)),
                UserResponseDto.class
        );
    }

    @PutMapping(value = "")
    public UserResponseDto update(@RequestBody @Valid UserDto user) {
        return conversionService.convert(
                userService.updateUser(conversionService.convert(user, User.class)),
                UserResponseDto.class
        );
    }
}
