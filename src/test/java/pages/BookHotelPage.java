package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 23-05-2016.
 */
public class BookHotelPage extends OpentapsWrappers {

    public BookHotelPage verifyTotelPrice(String price){
        if(!verifyTextboxValueById(prop.getProperty("Bookhotel.price.id"),price))
            Reporter.reportStep("Price Not Matched with the Entered Data ","FAIL");
        return this ;
    }

    public BookHotelPage enterFirstname(String fname) {
        enterById(prop.getProperty("Home.firstName.Id"),fname);
        return this;

    }
    public BookHotelPage enterLasttname(String lname) {
        enterById(prop.getProperty("Home.lastName.Id"),lname);
        return this;
    }
    public BookHotelPage enterAddress(String address) {
        enterById(prop.getProperty("Home.billngAddress.id"),address);
        return this;
    }
    public BookHotelPage enterCCNumber(String ccno) {
        enterById(prop.getProperty("home.ccno.id"),ccno);
        return this;
    }
    public BookHotelPage enterCCType(String type) {
        selectById(prop.getProperty("Home.cctype.id"),type);
        return this;
    }
    public BookHotelPage enterexpmonth(String expMonth) {
        selectById(prop.getProperty("Home.expmonth.id"),expMonth);
        return this;
    }
    public BookHotelPage enterExpYear(String expYear) {
        selectById(prop.getProperty("Home.expyear.id"),expYear);
        return this;
    }
    public BookHotelPage enterCvvNumber(String cvv) {
        enterById(prop.getProperty("Home.cvv.id"),cvv);
        return this;
    }
    public BookHotelConfirmationPage clickBooknow() throws InterruptedException {
        clickById(prop.getProperty("home.booknow.id"));
        Thread.sleep(10000);
        String orderNumber = getTextById(prop.getProperty("Book.Confirm.OrderNumber"));
      //  System.out.print("ord" + orderNumber);
        Reporter.reportStep("Order has been generated. Order Number is " + orderNumber,"PASS");
        if(orderNumber==null)
            Reporter.reportStep("Order is not created", "FAIL");
        return new BookHotelConfirmationPage();
    }



    public BookHotelPage verifyHotelName(String name) {
        if(!verifyTextboxValueById(prop.getProperty("bookhotel.hotelname.id"), name))
            Reporter.reportStep("entered location name does not match with the location shown in the search results", "FAIL");
        return this;
    }

    public BookHotelPage verifyHotelLocation(String location) {
        if(!verifyTextboxValueById(prop.getProperty("Bookhotel.verifylocation.id"), location))
            Reporter.reportStep("entered location name does not match with the location shown in the search results", "FAIL");
        return this;
    }


    public BookHotelPage verifyRoomType(String roomType){
        if(!verifyTextboxValueById(prop.getProperty("bookhotel.verifyroomtype.id"),roomType))
            Reporter.reportStep("Room type not match with the room type entered in search hotel ","FAIL");
        return this ;
    }

    public BookHotelPage verifyTotalDay(String totalDays){
        if(!verifyTextboxValueById(prop.getProperty("bookhotel.verifytotalday.id"),totalDays))
            Reporter.reportStep("Room type not match with the room type entered in search hotel ","FAIL");
        return this ;
    }

    public BookHotelPage verifyPriceperNight(String priceperNight){
        if(!verifyTextboxValueById(prop.getProperty("bookhotel.verifypricepernight.id"),priceperNight))
            Reporter.reportStep("Room type not match with the room type entered in search hotel ","FAIL");
        return this ;
    }
    public BookHotelPage verifyFinalbilledPrice(String finalBill){
        if(!verifyTextboxValueById(prop.getProperty("bookhotel.verifyfinalbill.id"),finalBill))
            Reporter.reportStep("Room type not match with the room type entered in search hotel ","FAIL");
        return this ;
    }

}
