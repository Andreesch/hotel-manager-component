package model;

import java.util.List;

public abstract class HotelStayModel implements Cloneable {
    private List<Double> guestExpensesList;

    public HotelStayModel(List<Double> guestExpensesList) {
        this.guestExpensesList = guestExpensesList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public List<Double> getGuestExpensesList() {
        return guestExpensesList;
    }

    public HotelStayModel setGuestExpensesList(List<Double> guestExpensesList) {
        this.guestExpensesList = guestExpensesList;
        return this;
    }
}
