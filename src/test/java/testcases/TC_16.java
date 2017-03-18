package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchHotelPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 21-05-2016.
 */
public class TC_16 extends OpentapsWrappers {

    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC10_BookedHotelPrice";
        testCaseName 	= "TC03 -Adactin Check-Out Date Validation (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }



    @Test(dataProvider="fetchData")
    public void verify_TC16(String username,String password, String location, String hotels, String roomType, String noOfRooms,
                            String checkInData, String checkOutDate,String adult,String fname,String lname,String address,String ccno,String cctype,String expmonth,String expyear,String cvv) throws InterruptedException {
        new LoginPage()
                .enterUserName(username)
                .enterPassword(password)
                .clickLogin();
        new SearchHotelPage()
                .selectLocation(location)
                .selectHotels(hotels)
                .roomType(roomType)
                .noOfRooms(noOfRooms)
              //  .datePickin(checkInData)
                .datePickout(checkOutDate)
                .adultperRoom(adult)
                .clickSearch()
                .selectHotel()
                .clickContinue()
                .enterFirstname(fname)
                .enterLasttname(lname)
                .enterAddress(address)
                .enterCCNumber(ccno)
                .enterCCType(cctype)
                .enterexpmonth(expmonth)
                .enterExpYear(expyear)
                .enterCvvNumber(cvv)
                .clickBooknow()
                .clickMyItinerary()
        ;

    }
}
