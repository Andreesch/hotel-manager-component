package com.andreschneider.hotelmanagerspring.api.dto;

public class UserFindDto {

    private String email;

    public String getEmail() {
        return email;
    }

    public UserFindDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
