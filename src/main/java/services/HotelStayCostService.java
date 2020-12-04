package services;

import static constants.HotelStayConstants.DEFAULT_SCALE;

import java.math.BigDecimal;
import java.math.RoundingMode;

import model.HotelStay;

public class HotelStayCostService {

    public BigDecimal calculateCosts(HotelStay hotelStay) {
        BigDecimal fixedCost = new BigDecimal(hotelStay.getCostPerNight() * hotelStay.getNights())
                .setScale(DEFAULT_SCALE, RoundingMode.HALF_EVEN);

        if (hotelStay.getGuestExpensesList().isEmpty()) {
            return fixedCost;
        }

        double totalExpenses = hotelStay.getGuestExpensesList().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        return fixedCost.add(new BigDecimal(totalExpenses)
                .setScale(DEFAULT_SCALE, RoundingMode.HALF_EVEN));
    }
}
