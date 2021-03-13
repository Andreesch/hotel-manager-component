package com.andreschneider.hotelmanagerspring.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("UserCreateResponse")
public class UserCreateResponseDto {

    @ApiModelProperty(value = "${user.create.response.id}")
    private String id;

    public String getId() {
        return id;
    }

    public UserCreateResponseDto setId(String id) {
        this.id = id;
        return this;
    }
}
