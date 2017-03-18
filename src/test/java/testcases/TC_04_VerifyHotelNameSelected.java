package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar on 05/20/2016.
 */
public class TC_04_VerifyHotelNameSelected extends OpentapsWrappers {


    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC04_CheckSelectedHotelName";
        testCaseName 	= "TC03 -Adactin Checking Location Name As selceted  (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }



    @Test(dataProvider="fetchData")
    public void verifyHotelName(String username,String password, String location, String hotels, String roomType, String noOfRooms,
                             String checkInData, String checkOutDate,String adult,String children,String name) throws InterruptedException {
        new LoginPage()
                .enterUserName(username)
                .enterPassword(password)
                .clickLogin()
                .selectLocation(location)
                .selectHotels(hotels)
                .roomType(roomType)
                .datePickin(checkInData)
                .datePickout(checkOutDate)
                .adultperRoom(adult)
                .childrenperRoom(children)
                .clickSearch()
                .hotelLocation(name)
        ;


    }
}
