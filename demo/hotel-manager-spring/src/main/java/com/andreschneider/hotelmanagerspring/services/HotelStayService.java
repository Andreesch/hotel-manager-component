package com.andreschneider.hotelmanagerspring.services;

import org.springframework.stereotype.Service;

import com.andreschneider.hotelmanagerspring.api.dto.HotelStayCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.HotelStayPaymentResponseDto;

import manager.HotelStayManager;
import model.HotelStay;

@Service
public class HotelStayService {
    private HotelStayManager hotelStayManager = new HotelStayManager();

    public HotelStayPaymentResponseDto calculatePaymentValue(HotelStayCreateDto hotelStayCreateDto) {
        HotelStay hotelStay = new HotelStay()
                .setNights(hotelStayCreateDto.getNights())
                .setCostPerNight(hotelStayCreateDto.getCostPerNight())
                .setGuestExpensesList(hotelStayCreateDto.getGuestExpensesList());

        return new HotelStayPaymentResponseDto()
                .setPaymentValue(hotelStayManager.calculateStay(hotelStay));
    }
}
