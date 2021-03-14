package com.andreschneider.hotelmanagerspring.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreschneider.hotelmanagerspring.api.dto.UserCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserCreateResponseDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserFindDto;
import com.andreschneider.hotelmanagerspring.api.dto.UserUpdateDto;
import com.andreschneider.hotelmanagerspring.api.mapper.UserMapper;
import com.andreschneider.hotelmanagerspring.entity.User;
import com.andreschneider.hotelmanagerspring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreateResponseDto create(UserCreateDto userCreateDto) {
        if (validateEmailAlreadyExists(userCreateDto.getEmail())) {
            // exceção
        }

        return UserMapper.toResponse(userRepository.save(
                UserMapper.toEntity(userCreateDto)));
    }

    public UserFindDto findById(String userId) {
        UserFindDto userFindDto = new UserFindDto();

        User user = userRepository.findById(userId)
                .orElse(null);

        if (user != null) {
            userFindDto.setEmail(user.getEmail());
        }

        return userFindDto;
    }

    public User findUserById(String id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    public User update(UserUpdateDto userUpdateDto) {
        User currentUser = findUserById(userUpdateDto.getId());

        if (!Objects.isNull(currentUser)) {
            currentUser.setEmail(userUpdateDto.getEmail())
                    .setPassword(userUpdateDto.getPassword());
        }

        return currentUser;
    }

    private boolean validateEmailAlreadyExists(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .isPresent();
    }

}
