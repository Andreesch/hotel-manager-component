package abstractfatory;

import services.HotelStayCostService;
import services.HotelStayTaxesService;

public abstract class HotelStayCalculatorServicesInjector {
    protected HotelStayCostService hotelStayCostService = new HotelStayCostService();
    protected HotelStayTaxesService hotelStayTaxesService = new HotelStayTaxesService();
}
