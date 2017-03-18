package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;


public class SelectHotelPage extends OpentapsWrappers {



    public SelectHotelPage selectHotel() {
        clickById(prop.getProperty("Home.SelectHotel.id"));
        return this;

    }
    public BookHotelPage clickContinue() {
        clickById(prop.getProperty("Home.clickContinue.id"));
        return new BookHotelPage();

    }
    public SelectHotelPage hotelLocation(String name) {
        if(!verifyTextboxValueById(prop.getProperty("Home.hotelName.id"), name))
            Reporter.reportStep("entered location name does not match with the location shown in the search results", "FAIL");
        return this;
    }



    public SelectHotelPage arrivalDate(String arrivalDate){
        if(!verifyTextboxValueById(prop.getProperty("Home.verifyarrival.id"), arrivalDate))
            Reporter.reportStep(" Dates does not match with the Dates Entered in Search Hotel", "FAIL");
              return this ;
    }
    public SelectHotelPage depatureDate(String depatureDate){
        if(!verifyTextboxValueById(prop.getProperty("Home.verifydepature.id"), depatureDate))
            Reporter.reportStep(" Dates does not match with the Dates Entered in Search Hotel", "FAIL");
               return this ;
    }
    public SelectHotelPage verifyRoomCount(String roomCount){
        if(!verifyTextboxValueById(prop.getProperty("Select.Roomcount.id"),roomCount))
            Reporter.reportStep(" Room count not match with the no of room entered in the search hotel page","FAIL");
        return this ;
    }

    public SelectHotelPage verifyRoomType(String roomType){
        if(!verifyTextboxValueById(prop.getProperty("Select.RoomType.id"),roomType))
            Reporter.reportStep("Room type not match with the room type entered in search hotel ","FAIL");
        return this ;
    }

    public SelectHotelPage verifyCheckInErrorMessage(String checkInError){
        if(!verifyTextById(prop.getProperty("SearchHotel.CheckIn.Error.id"),checkInError))
            Reporter.reportStep("Alert not  Present","FAIL");
        return this ;
    }

    public SelectHotelPage verifyCheckInErrorMessage1(String checkInError){
        if(!verifyTextById(prop.getProperty("SearchHotel.CheckIn.Error.id"),checkInError))
            Reporter.reportStep("Alert not  Present","FAIL");
        System.out.print("Enter valid dates");
        return this ;
    }


}
