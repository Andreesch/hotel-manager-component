package helper;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import model.HotelStayModel;
import model.SimpleHotelStayModel;
import model.CustomHotelStayModel;

public class HotelStayHelper {

    public static SimpleHotelStayModel generateDefaultHotelStay() {
        return new SimpleHotelStayModel(generateDefaultGuestExpensesList(), 2, 125.00);
    }

    public static CustomHotelStayModel generateCustomHotelStayModel() {
        LocalDateTime checkIn = LocalDateTime.of(2020, Month.NOVEMBER, 1, 8, 30, 0);
        LocalDateTime checkOut = LocalDateTime.of(2020, Month.NOVEMBER, 2, 18, 30, 0);

        return new CustomHotelStayModel(generateDefaultGuestExpensesList(), 1, checkIn, checkOut);
    }

    public static List<Double> generateDefaultGuestExpensesList() {
        return Arrays.asList(4.50, 66.00);
    }
}
