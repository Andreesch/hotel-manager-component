package manager;

import java.math.BigDecimal;

import interfaces.HotelStayCalculator;
import model.HotelStay;
import services.DefaultHotelStayCalculator;

public class HotelStayManager {

    public BigDecimal calculateStay(HotelStay hotelStay) {
        return calculateStay(hotelStay, new DefaultHotelStayCalculator());
    }

    public BigDecimal calculateStay(HotelStay hotelStay, HotelStayCalculator hotelStayCalculator) {
        return hotelStayCalculator.calculatePaymentValue(hotelStay);
    }
}
