package helper;

import java.util.Arrays;
import java.util.List;

import model.HotelStay;

public class HotelStayHelper {

    public static HotelStay generateDefaultHotelStay() {
        return new HotelStay()
                .setCostPerNight(125.0)
                .setNights(2)
                .setGuestExpensesList(generateDefaultGuestExpensesList());
    }

    public static List<Double> generateDefaultGuestExpensesList() {
        return Arrays.asList(4.50, 66.00);
    }
}
