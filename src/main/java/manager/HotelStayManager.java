package manager;

import java.math.BigDecimal;

import abstractfatory.DefaultHotelStayCalculator;
import interfaces.HotelStayCalculator;
import interfaces.HotelStayModelSelector;

public class HotelStayManager {
    private static HotelStayManager hotelStayManager;

    private HotelStayManager() {
    }

    private static class SingletonHelper {
        private static final HotelStayManager hotelStayManager = new HotelStayManager();
    }

    public static HotelStayManager getInstance() {
        return SingletonHelper.hotelStayManager;
    }

    public BigDecimal calculateStay(HotelStayModelSelector hotelStayModelSelector) {
        return calculateCustomStay(hotelStayModelSelector, new DefaultHotelStayCalculator());
    }

    public BigDecimal calculateCustomStay(HotelStayModelSelector hotelStayModelSelector, HotelStayCalculator hotelStayCalculator) {
        return hotelStayCalculator.calculatePaymentValue(hotelStayModelSelector);
    }
}
