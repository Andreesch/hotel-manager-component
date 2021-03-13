package com.andreschneider.hotelmanagerspring.api.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("UserCreate")
public class UserCreateDto {

    @NotBlank
    @ApiModelProperty(value = "${user.create.email}")
    private String email;

    @NotBlank
    @ApiModelProperty(value = "${user.create.password}")
    private String password;

    public String getEmail() {
        return email;
    }

    public UserCreateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserCreateDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
