package com.andreschneider.hotelmanagerspring.api.dto;

import java.math.BigDecimal;

public class HotelStayPaymentResponseDto {
    private BigDecimal paymentValue;

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public HotelStayPaymentResponseDto setPaymentValue(BigDecimal paymentValue) {
        this.paymentValue = paymentValue;
        return this;
    }
}
