package model;

import java.util.List;

public class HotelStay {
    private int nights;
    private double costPerNight;
    private List<Double> guestExpensesList;

    public int getNights() {
        return nights;
    }

    public HotelStay setNights(int nights) {
        this.nights = nights;
        return this;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public HotelStay setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
        return this;
    }

    public List<Double> getGuestExpensesList() {
        return guestExpensesList;
    }

    public HotelStay setGuestExpensesList(List<Double> guestExpensesList) {
        this.guestExpensesList = guestExpensesList;
        return this;
    }
}
