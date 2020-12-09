package model;

import java.time.LocalDateTime;
import java.util.List;

import interfaces.HotelStayModelSelector;

public class CustomHotelStayModel extends HotelStayModel implements HotelStayModelSelector {
    private double costPerHour;
    private LocalDateTime checkIn;
    private LocalDateTime checkout;

    public CustomHotelStayModel(List<Double> guestExpensesList, double costPerHour, LocalDateTime checkIn, LocalDateTime checkout) {
        super(guestExpensesList);
        this.costPerHour = costPerHour;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public CustomHotelStayModel setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
        return this;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public CustomHotelStayModel setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public CustomHotelStayModel setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
        return this;
    }

    @Override
    public SimpleHotelStayModel getSimpleModel() {
        return null;
    }

    @Override
    public CustomHotelStayModel getCustomModel() {
        return this;
    }
}
