package services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import abstractfatory.CustomHotelStayCalculator;
import constants.HotelStayConstants;
import helper.HotelStayHelper;
import model.CustomHotelStayModel;
import model.SimpleHotelStayModel;

public class CustomHotelStayModelCalculatorServiceTest {
    private CustomHotelStayCalculator customHotelStayCalculator = new CustomHotelStayCalculator();
    private HotelStayCostService hotelStayCostService = new HotelStayCostService();

    private SimpleHotelStayModel simpleHotelStayModel = HotelStayHelper.generateDefaultHotelStay();

    @Test
    public void assertCostCalculator() {
        CustomHotelStayModel customHotelStayModel = HotelStayHelper.generateCustomHotelStayModel();

        BigDecimal expectedValue = new BigDecimal(34)
                .setScale(HotelStayConstants.DEFAULT_SCALE, RoundingMode.HALF_EVEN);

        BigDecimal calculatedCost = hotelStayCostService.calculateCosts(customHotelStayModel);

        assertEquals(expectedValue, calculatedCost);
    }
}
