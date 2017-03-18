package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar on 05/20/2016.
 */
public class TC_07_VerifyRoomType extends OpentapsWrappers {

    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC07_VerifyRoomType";
        testCaseName 	= "TC03 -Adactin Check-Out Date Validation (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }



    @Test(dataProvider="fetchData")
    public void verifyRoomType(String username,String password, String location, String hotels, String roomType, String noOfRooms,
                                String checkInData, String checkOutDate,String adult) throws InterruptedException {
        new LoginPage()
                .enterUserName(username)
                .enterPassword(password)
                .clickLogin()
                .selectLocation(location)
                .selectHotels(hotels)
                .roomType(roomType)
                .noOfRooms(noOfRooms)
                .datePickin(checkInData)
                .datePickout(checkOutDate)
                .adultperRoom(adult)
                .clickSearch()
                .verifyRoomType(roomType)
        ;


    }
}
