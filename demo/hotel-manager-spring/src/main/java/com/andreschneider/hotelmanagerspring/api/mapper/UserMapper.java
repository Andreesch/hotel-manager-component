package com.andreschneider.hotelmanagerspring.api.mapper;

import org.modelmapper.ModelMapper;

import com.andreschneider.hotelmanagerspring.api.dto.UserCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserCreateResponseDto;
import com.andreschneider.hotelmanagerspring.entity.User;

public class UserMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private UserMapper(){
    }

    public static User toEntity(UserCreateDto userCreateDto) {
        return modelMapper.map(userCreateDto, User.class);
    }

    public static UserCreateResponseDto toResponse(User user) {
        return modelMapper.map(user, UserCreateResponseDto.class);
    }
}
