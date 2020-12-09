package services;

import static constants.HotelStayConstants.DEFAULT_SCALE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import constants.HotelStayConstants;
import interfaces.HotelStayModelSelector;
import model.CustomHotelStayModel;
import model.SimpleHotelStayModel;

public class HotelStayCostService {

    public BigDecimal calculateCosts(HotelStayModelSelector hotelStayModelSelector) {

        if (!Objects.isNull(hotelStayModelSelector.getSimpleModel())) {
            return calculateCostsByNights(hotelStayModelSelector.getSimpleModel());
        }

        if (!Objects.isNull(hotelStayModelSelector.getCustomModel())) {
            return calculateCostsByHour(hotelStayModelSelector.getCustomModel());
        }

        return null;
    }

    private BigDecimal calculateCostsByNights(SimpleHotelStayModel simpleHotelStayModel) {
        BigDecimal fixedCost = new BigDecimal(simpleHotelStayModel.getCostPerNight() * simpleHotelStayModel.getNights())
                .setScale(DEFAULT_SCALE, RoundingMode.HALF_EVEN);

        if (simpleHotelStayModel.getGuestExpensesList().isEmpty()) {
            return fixedCost;
        }

        double totalExpenses = simpleHotelStayModel.getGuestExpensesList().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        return fixedCost.add(new BigDecimal(totalExpenses)
                .setScale(DEFAULT_SCALE, RoundingMode.HALF_EVEN));
    }

    private BigDecimal calculateCostsByHour(HotelStayModelSelector hotelStayModelSelector) {
        CustomHotelStayModel customHotelStayModel = hotelStayModelSelector.getCustomModel();
        long hours = customHotelStayModel.getCheckIn().until(customHotelStayModel.getCheckout(), ChronoUnit.HOURS);

        return new BigDecimal(hours * customHotelStayModel.getCostPerHour())
                .setScale(DEFAULT_SCALE, RoundingMode.HALF_EVEN);
    }
}
