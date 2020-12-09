package interfaces;

import java.math.BigDecimal;

import model.SimpleHotelStayModel;

public interface HotelStayCalculator {

    BigDecimal calculatePaymentValue(HotelStayModelSelector hotelStayModelSelector);

    BigDecimal calculateCosts(HotelStayModelSelector hotelStayModelSelector);

    BigDecimal calculateTaxes(BigDecimal costs);
}
