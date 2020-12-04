package com.andreschneider.hotelmanagerspring.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andreschneider.hotelmanagerspring.api.dto.HotelStayCreateDto;
import com.andreschneider.hotelmanagerspring.api.dto.HotelStayPaymentResponseDto;
import com.andreschneider.hotelmanagerspring.services.HotelStayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("StayController")
@RequestMapping(RestPath.BASE_PATH + "/stays")
@Api(tags = "Stays")
public class StayController {

    @Autowired
    private HotelStayService hotelStayService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.stay.calculate}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = HotelStayPaymentResponseDto.class),
    })
    public HotelStayPaymentResponseDto calculate(
            @ApiParam(value = "${v1.stay}", required = true) @RequestBody @Valid HotelStayCreateDto hotelStayCreateDto) {
        return hotelStayService.calculatePaymentValue(hotelStayCreateDto);
    }
}

