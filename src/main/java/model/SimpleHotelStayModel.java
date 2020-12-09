package model;

import java.util.List;

import interfaces.HotelStayModelSelector;

public class SimpleHotelStayModel extends HotelStayModel implements HotelStayModelSelector {
    private int nights;
    private double costPerNight;

    public SimpleHotelStayModel(List<Double> guestExpensesList, int nights, double costPerNight) {
        super(guestExpensesList);
        this.nights = nights;
        this.costPerNight = costPerNight;
    }

    public int getNights() {
        return nights;
    }

    public SimpleHotelStayModel setNights(int nights) {
        this.nights = nights;
        return this;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public SimpleHotelStayModel setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
        return this;
    }

    @Override
    public SimpleHotelStayModel getSimpleModel() {
        return this;
    }

    @Override
    public CustomHotelStayModel getCustomModel() {
        return null;
    }
}
