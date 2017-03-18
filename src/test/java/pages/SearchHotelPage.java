package pages;

import org.openqa.selenium.By;
import utils.Reporter;
import wrappers.OpentapsWrappers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchHotelPage extends OpentapsWrappers {

    public SearchHotelPage(){
        if(!verifyTitle("AdactIn.com - Search Hotel")){
            Reporter.reportStep("This is NOT Search Hotel page", "FAIL");
        }
    }

    public SearchHotelPage selectLocation(String location) {
        selectById(prop.getProperty("Home.location.id"), location);
        return this;
    }

    public SearchHotelPage selectHotels(String hotels) {
        selectById(prop.getProperty("Home.Hotels.id"), hotels);
        return this;
    }

    public SearchHotelPage roomType(String roomType) {
        selectById(prop.getProperty("Home.RoomType.id"), roomType);
        return this;
    }

    public SearchHotelPage noOfRooms(String count) {
        selectById(prop.getProperty("Home.RoomCount.id"), count);
        return this;
    }

    public SearchHotelPage AutodatePickin() {
        String Home_checkIn_id;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateobj = new Date();
       // System.out.println(df.format(dateobj));
        Home_checkIn_id=(df.format(dateobj)+7);
       // enterById(prop.getProperty("Home.checkIn.id"), Home_checkIn_id);
        enterById("datepick_in",Home_checkIn_id);
        return this;
    }
    public SearchHotelPage datePickin(String pickin) {
        enterById(prop.getProperty("Home.checkIn.id"), pickin);
        return this;
    }

    public SearchHotelPage datePickout(String pickOut) {
        enterById(prop.getProperty("Home.checkOut.id"), pickOut);
        return this;
    }

    public SearchHotelPage adultperRoom(String adult) {
        selectById(prop.getProperty("Home.adult.id"), adult);
        return this;
    }

    public SearchHotelPage childrenperRoom(String children) {
        selectById(prop.getProperty("Home.children.id"), children);
        return this;
    }

    public SelectHotelPage clickSearch() {
        clickById(prop.getProperty("Search.Hotel.Search.Button.id"));
        return new SelectHotelPage();
    }

    public SearchHotelPage arrivalDate(String arrivalDate) {
        verifyTextContainsById(prop.getProperty("Home.verifyarrival.id"), arrivalDate);
        return this;
    }

    public SearchHotelPage depatureDate(String depatureDate) {
        verifyTextContainsById(prop.getProperty("Home.verifydepature.id"), depatureDate);
        return this;
    }

    public SearchHotelPage hotelName(String name) {
        if(!verifyTextboxValueById(prop.getProperty("Home.hotelName.id"), name))
            Reporter.reportStep("entered location name does not match with the location shown in the search results", "FAIL");
        return this;
    }

    public SearchHotelPage clickLogout() {
        clickByXpath(prop.getProperty("LogoutPage.Logout.Link"));
        return this;

    }
    public SearchHotelPage selectHotel() {
        clickById(prop.getProperty("Home.SelectHotel.id"));
        return this;

    }
    public SearchHotelPage clickContinue() {
        clickById(prop.getProperty("Home.clickContinue.id"));
        return this;

    }
    public SearchHotelPage enterFirstname(String fname) {
        enterById(prop.getProperty("Home.firstName.Id"),fname);
        return this;

    }
    public SearchHotelPage enterLasttname(String lname) {
        enterById(prop.getProperty("Home.lastName.Id"),lname);
        return this;
    }
    public SearchHotelPage enterAddress(String address) {
        enterById(prop.getProperty("Home.billngAddress.id"),address);
        return this;
    }
    public SearchHotelPage enterCCNumber(String ccno) {
        enterById(prop.getProperty("home.ccno.id"),ccno);
        return this;
    }
    public SearchHotelPage enterCCType(String type) {
        selectById(prop.getProperty("Home.cctype.id"),type);
        return this;
    }
    public SearchHotelPage enterexpmonth(String expMonth) {
        selectById(prop.getProperty("Home.expmonth.id"),expMonth);
        return this;
    }
    public SearchHotelPage enterExpYear(String expYear) {
        selectById(prop.getProperty("Home.expyear.id"),expYear);
        return this;
    }
    public SearchHotelPage enterCvvNumber(String cvv) {
        enterById(prop.getProperty("Home.cvv.id"),cvv);
        return this;
    }



    public SearchHotelPage clickBooknow() throws InterruptedException {
        clickById(prop.getProperty("home.booknow.id"));
        fluentWait(By.id(prop.getProperty("Book.Confirm.OrderNumber")), 30, 1);
        String orderNumber = getTextById(prop.getProperty("Book.Confirm.OrderNumber"));
        System.out.print("ord" + orderNumber);
        Reporter.reportStep("Order has been generated. Order Number is " + orderNumber,"PASS");
        if(orderNumber==null)
            Reporter.reportStep("Order is not created", "FAIL");
        return this;
    }


    public SearchHotelPage clickMyItinerary() {
        clickById(prop.getProperty("Home.Myitinerary.id"));
        return this;
    }
    public SearchHotelPage clickBookedItinerary(){
        clickByXpath(prop.getProperty("Home.Bookeditinerary.id"));
        return this;
    }
    public SearchHotelPage enterOrderID(String orderID) {
        enterById(prop.getProperty("Home.orderid.id"),orderID);
        return this;
    }
    public SearchHotelPage clickGoButton() {
        clickById(prop.getProperty("Home.ClickGObutton.id"));
        return this;
    }
    public SearchHotelPage clickOrdercancelButton() {
        clickById(prop.getProperty("Home.orderCancel.id"));
        acceptAlert();
        return this;
    }

    public SearchHotelPage verifyCheckInErrorMessage(String checkInError){
        if(!verifyTextById(prop.getProperty("SearchHotel.CheckIn.Error.id"),checkInError))
            Reporter.reportStep("Alert not  Present","FAIL");

        return this ;
    }


}