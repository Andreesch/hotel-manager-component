package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import helper.HotelStayHelper;

public class ModelTest {

    @Test
    public void simpleHotelStayClone() throws CloneNotSupportedException {
        SimpleHotelStayModel simpleHotelStayModel = HotelStayHelper.generateDefaultHotelStay();
        SimpleHotelStayModel simpleHotelStayModelClone = simpleHotelStayModel.clone();

        assertEquals(simpleHotelStayModel.getNights(), simpleHotelStayModelClone.getNights());
        assertEquals(simpleHotelStayModel.getCostPerNight(), simpleHotelStayModelClone.getCostPerNight(), 0);
        assertEquals(simpleHotelStayModel.getGuestExpensesList(), simpleHotelStayModelClone.getGuestExpensesList());
    }

    @Test
    public void CustomHotelStayClone() throws CloneNotSupportedException {
        CustomHotelStayModel customHotelStayModel = HotelStayHelper.generateCustomHotelStayModel();
        CustomHotelStayModel customHotelStayModelClone = customHotelStayModel.clone();

        assertEquals(customHotelStayModel.getCostPerHour(), customHotelStayModelClone.getCostPerHour(), 0);
        assertEquals(customHotelStayModel.getCheckIn(), customHotelStayModelClone.getCheckIn());
        assertEquals(customHotelStayModel.getCheckout(), customHotelStayModelClone.getCheckout());
        assertEquals(customHotelStayModel.getGuestExpensesList(), customHotelStayModelClone.getGuestExpensesList());
    }
}
