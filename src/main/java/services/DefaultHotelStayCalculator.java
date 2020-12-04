package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import constants.HotelStayConstants;
import interfaces.HotelStayCalculator;
import model.HotelStay;

public class DefaultHotelStayCalculator implements HotelStayCalculator {
    private HotelStayCostService hotelStayCostService = new HotelStayCostService();
    private HotelStayTaxesService hotelStayTaxesService = new HotelStayTaxesService();

    @Override
    public BigDecimal calculatePaymentValue(HotelStay hotelStay) {
        BigDecimal costs = calculateCosts(hotelStay);
        BigDecimal taxes = calculateTaxes(costs);

        return costs.add(taxes)
                .setScale(HotelStayConstants.DEFAULT_SCALE, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal calculateCosts(HotelStay hotelStay) {
        return hotelStayCostService.calculateCosts(hotelStay);
    }

    @Override
    public BigDecimal calculateTaxes(BigDecimal costs) {
        return hotelStayTaxesService.calculateTaxes(costs);
    }

}
