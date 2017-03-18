package pages;

import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 23-05-2016.
 */
public class BookedItineraryPage extends OpentapsWrappers {

    public BookedItineraryPage enterOrderID(String orderID) {
        enterById(prop.getProperty("Home.orderid.id"),orderID);
        return this;
    }
    public BookedItineraryPage clickGoButton() {
        clickById(prop.getProperty("Home.ClickGObutton.id"));
        return this;
    }
}
