package com.andreschneider.hotelmanagerspring.api.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("StayCreate")
public class HotelStayCreateDto {

    @NotNull
    @ApiModelProperty(value = "${stay.create.nights}")
    private Integer nights;

    @NotNull
    @ApiModelProperty(value = "${stay.create.costPerNight}")
    private Double costPerNight;

    @NotEmpty
    @ApiModelProperty(value = "${stay.create.guestExpensesList}")
    private List<Double> guestExpensesList;

    @NotNull
    @ApiModelProperty(value = "${stay.create.costPerHour}")
    private Double costPerHour;

    public Integer getNights() {
        return nights;
    }

    public HotelStayCreateDto setNights(Integer nights) {
        this.nights = nights;
        return this;
    }

    public Double getCostPerNight() {
        return costPerNight;
    }

    public HotelStayCreateDto setCostPerNight(Double costPerNight) {
        this.costPerNight = costPerNight;
        return this;
    }

    public List<Double> getGuestExpensesList() {
        return guestExpensesList;
    }

    public HotelStayCreateDto setGuestExpensesList(List<Double> guestExpensesList) {
        this.guestExpensesList = guestExpensesList;
        return this;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public HotelStayCreateDto setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
        return this;
    }
}
