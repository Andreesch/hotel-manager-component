package com.andreschneider.hotelmanagerspring.services;

import org.springframework.stereotype.Service;

import com.andreschneider.hotelmanagerspring.api.dto.HotelStayByHourCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.HotelStayCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.HotelStayPaymentResponseDto;

import manager.HotelStayManager;
import model.CustomHotelStayModel;
import model.SimpleHotelStayModel;

@Service
public class HotelStayService {
    private HotelStayManager hotelStayManager = HotelStayManager.getInstance();

    public HotelStayPaymentResponseDto calculatePaymentValue(HotelStayCreateDto hotelStayCreateDto) {
        SimpleHotelStayModel hotelStay = new SimpleHotelStayModel(hotelStayCreateDto.getGuestExpensesList(),
                hotelStayCreateDto.getNights(), hotelStayCreateDto.getCostPerNight());

        return new HotelStayPaymentResponseDto()
                .setPaymentValue(hotelStayManager.calculateStay(hotelStay));
    }

    public HotelStayPaymentResponseDto calculatePaymentValueByHour(HotelStayByHourCreateDto hotelStayByHourCreateDto) {
        CustomHotelStayModel hotelStay = new CustomHotelStayModel(hotelStayByHourCreateDto.getGuestExpensesList(),
                hotelStayByHourCreateDto.getCostPerHour(),
                hotelStayByHourCreateDto.getCheckIn(),
                hotelStayByHourCreateDto.getCheckOut());

        return new HotelStayPaymentResponseDto()
                .setPaymentValue(hotelStayManager.calculateStay(hotelStay));
    }
}
