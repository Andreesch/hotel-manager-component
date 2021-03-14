package com.andreschneider.hotelmanagerspring.api.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class UserUpdateDto {

    @NotBlank
    @ApiModelProperty(value = "${user.update.id}")
    private String id;

    @NotBlank
    @ApiModelProperty(value = "${user.update.email}")
    private String email;

    @NotBlank
    @ApiModelProperty(value = "${user.update.password}")
    private String password;

    public String getId() {
        return id;
    }

    public UserUpdateDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserUpdateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserUpdateDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
