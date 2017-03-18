package pages;

import org.openqa.selenium.By;
import utils.Reporter;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 23-05-2016.
 */
public class BookHotelConfirmationPage extends OpentapsWrappers {

    public BookedItineraryPage clickMyItinerary() {
        clickById(prop.getProperty("Home.Myitinerary.id"));
        return new BookedItineraryPage();
    }
    public BookHotelConfirmationPage clickLogout() {
        clickByXpath(prop.getProperty("LogoutPage.Logout.Link"));
        return this;

    }

    public BookHotelConfirmationPage verifyTotelPrice(String price){
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.totalprice.id"),price))
            Reporter.reportStep("Price Not Matched with the Entered Data ","FAIL");
        return this ;
    }







    public BookHotelConfirmationPage verifyHotelName(String name) {
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.hotelName.id"), name))
            Reporter.reportStep("entered hotel name does not match with the hotel name shown in the search results", "FAIL");
        return this;
    }


    public BookHotelConfirmationPage verifyRoomType(String roomType){
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.roomType.id"),roomType))
            Reporter.reportStep("Room type not match with the room type entered in search hotel ","FAIL");
        return this ;
    }

    public BookHotelConfirmationPage arrivalDate(String arrivalDate){
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.arrivalDate.id"), arrivalDate))
            Reporter.reportStep(" Arrival Date does not match with the Dates Entered in Search Hotel", "FAIL");
        return this ;
    }
    public BookHotelConfirmationPage depatureDate(String depatureDate){
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.depatureDate.id"), depatureDate))
            Reporter.reportStep(" Depature Date does not match with the Dates Entered in Search Hotel", "FAIL");
        return this ;
    }
    public BookHotelConfirmationPage verifyRoomCount(String roomCount){
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.roomCount.id"),roomCount))
            Reporter.reportStep(" Room count not match with the no of room entered in the search hotel page","FAIL");
        return this ;
    }
    public BookHotelConfirmationPage verifyAdultcount(String adult){
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.adultperRoom.id"), adult))
            Reporter.reportStep(" Adult count not matched with existing data", "FAIL");
        return this ;
    }
    public BookHotelConfirmationPage verifyChildrenCount(String children){
        if(!verifyTextboxValueById(prop.getProperty("bookconfirmation.childrenperRoom.id"),children))
            Reporter.reportStep(" Children count not matched with existing data","FAIL");
        return this ;
    }
    public BookHotelConfirmationPage verifyOrderNumber() throws InterruptedException {
        boolean boolan = driver.findElement(By.id("order_no")).isEnabled();
        System.out.print(boolan);
        Thread.sleep(10000);
        Reporter.reportStep("order number not generated","FAIL");
        return this ;
    }

}
