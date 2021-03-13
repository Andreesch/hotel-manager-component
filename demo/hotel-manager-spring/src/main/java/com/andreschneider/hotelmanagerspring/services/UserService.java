package com.andreschneider.hotelmanagerspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreschneider.hotelmanagerspring.api.dto.UserCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserCreateResponseDto;
import com.andreschneider.hotelmanagerspring.api.mapper.UserMapper;
import com.andreschneider.hotelmanagerspring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreateResponseDto create(UserCreateDto userCreateDto) {
        if (validateEmailAlreadyExists(userCreateDto.getEmail())){
            // exceção
        };

        return UserMapper.toResponse(userRepository.save(
                UserMapper.toEntity(userCreateDto)));
    }

    private boolean validateEmailAlreadyExists(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .isPresent();
    }
}
