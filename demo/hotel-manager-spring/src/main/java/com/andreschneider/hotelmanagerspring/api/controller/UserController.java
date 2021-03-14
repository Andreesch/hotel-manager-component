package com.andreschneider.hotelmanagerspring.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andreschneider.hotelmanagerspring.api.dto.UserCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserCreateResponseDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserFindDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserUpdateDto;
import com.andreschneider.hotelmanagerspring.entity.User;
import com.andreschneider.hotelmanagerspring.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("UserController")
@RequestMapping(RestPath.BASE_PATH + "/users")
@Api(tags = "Users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.user.create}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = UserCreateResponseDto.class),
    })
    public UserCreateResponseDto create(
            @ApiParam(value = "${v1.user}", required = true) @RequestBody @Valid UserCreateDto userCreateDto) {
        return userService.create(userCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.user.find}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = UserFindDto.class),
    })
    public UserFindDto find(
            @ApiParam(value = "${v1.user}", required = true) @RequestParam String userId) {
        return userService.findById(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.user.update}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = User.class),
    })
    public User update(
            @ApiParam(value = "${v1.user}", required = true) @RequestBody @Valid UserUpdateDto userUpdateDto) {
        return userService.update(userUpdateDto);
    }
}
