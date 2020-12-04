package services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import constants.HotelStayConstants;
import helper.HotelStayHelper;
import model.HotelStay;

public class HotelStayCalculatorServiceTest {
    private DefaultHotelStayCalculator hotelStayCalculatorService = new DefaultHotelStayCalculator();

    private HotelStay hotelStay = HotelStayHelper.generateDefaultHotelStay();

    @Test
    public void assertFinalPaymentValueCalculator() {
        BigDecimal expectedValue = new BigDecimal(336.53)
                .setScale(HotelStayConstants.DEFAULT_SCALE, RoundingMode.HALF_EVEN);

        assertEquals(expectedValue, hotelStayCalculatorService.calculatePaymentValue(hotelStay));
    }

    @Test
    public void assertCostCalculator() {
        BigDecimal expectedValue = new BigDecimal(320.50)
                .setScale(HotelStayConstants.DEFAULT_SCALE, RoundingMode.HALF_EVEN);

        BigDecimal calculatedCost = hotelStayCalculatorService.calculateCosts(hotelStay);

        assertEquals(expectedValue, calculatedCost);
    }

    @Test
    public void assertTaxesCalculator() {
        BigDecimal expectedValue = new BigDecimal(16.03)
                .setScale(HotelStayConstants.DEFAULT_SCALE, RoundingMode.HALF_EVEN);

        BigDecimal calculatedCost = hotelStayCalculatorService.calculateCosts(hotelStay);

        BigDecimal calculatedTaxes = hotelStayCalculatorService.calculateTaxes(calculatedCost);

        assertEquals(expectedValue, calculatedTaxes);
    }
}
