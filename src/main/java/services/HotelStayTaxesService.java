package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import constants.HotelStayConstants;

public class HotelStayTaxesService {

    public BigDecimal calculateTaxes(BigDecimal cost) {
        return cost.multiply(new BigDecimal(HotelStayConstants.FIXED_TAX))
                .setScale(HotelStayConstants.DEFAULT_SCALE, RoundingMode.HALF_EVEN);
    }
}
