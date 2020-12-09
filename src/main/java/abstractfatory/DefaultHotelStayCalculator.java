package abstractfatory;

import java.math.BigDecimal;
import java.math.RoundingMode;

import constants.HotelStayConstants;
import interfaces.HotelStayCalculator;
import interfaces.HotelStayModelSelector;

public class DefaultHotelStayCalculator extends HotelStayCalculatorServicesInjector implements HotelStayCalculator {

    @Override
    public BigDecimal calculatePaymentValue(HotelStayModelSelector hotelStayModelSelector) {
        BigDecimal costs = calculateCosts(hotelStayModelSelector);
        BigDecimal taxes = calculateTaxes(costs);

        return costs.add(taxes)
                .setScale(HotelStayConstants.DEFAULT_SCALE, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal calculateCosts(HotelStayModelSelector hotelStayModelSelector) {
        return hotelStayCostService.calculateCosts(hotelStayModelSelector);
    }

    @Override
    public BigDecimal calculateTaxes(BigDecimal costs) {
        return hotelStayTaxesService.calculateTaxes(costs);
    }

}
