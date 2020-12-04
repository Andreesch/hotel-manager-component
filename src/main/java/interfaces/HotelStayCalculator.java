package interfaces;

import java.math.BigDecimal;

import model.HotelStay;

public interface HotelStayCalculator {

    BigDecimal calculatePaymentValue(HotelStay hotelStay);

    BigDecimal calculateCosts(HotelStay hotelStay);

    BigDecimal calculateTaxes(BigDecimal costs);
}
