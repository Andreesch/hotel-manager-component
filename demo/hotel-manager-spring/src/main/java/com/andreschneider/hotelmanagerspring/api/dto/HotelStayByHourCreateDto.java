package com.andreschneider.hotelmanagerspring.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("StayByHourCreate")
public class HotelStayByHourCreateDto {
    @NotEmpty
    @ApiModelProperty(value = "${stay.create.guestExpensesList}")
    private List<Double> guestExpensesList;

    @NotNull
    @ApiModelProperty(value = "${stay.create.byHour.costPerHour}")
    private Double costPerHour;

    @NotNull
    @ApiModelProperty(value = "${stay.create.byHour.checkIn}")
    private LocalDateTime checkIn;

    @NotNull
    @ApiModelProperty(value = "${stay.create.byHour.checkOut}")
    private LocalDateTime checkOut;

    public List<Double> getGuestExpensesList() {
        return guestExpensesList;
    }

    public HotelStayByHourCreateDto setGuestExpensesList(List<Double> guestExpensesList) {
        this.guestExpensesList = guestExpensesList;
        return this;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public HotelStayByHourCreateDto setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
        return this;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public HotelStayByHourCreateDto setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public HotelStayByHourCreateDto setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
        return this;
    }
}
