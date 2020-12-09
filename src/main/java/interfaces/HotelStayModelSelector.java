package interfaces;

import model.CustomHotelStayModel;
import model.SimpleHotelStayModel;

public interface HotelStayModelSelector {

    SimpleHotelStayModel getSimpleModel();

    CustomHotelStayModel getCustomModel();
}
