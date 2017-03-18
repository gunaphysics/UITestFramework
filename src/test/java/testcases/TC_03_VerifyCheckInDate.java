package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar on 05/20/2016.
 */
public class TC_03_VerifyCheckInDate extends OpentapsWrappers {

    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC03_checkindate";
        testCaseName 	= "TC03 -Adactin Check-In Date Validation (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }



    @Test(dataProvider="fetchData")
    public void verifyDatein(String username,String password, String location, String hotels, String roomType, String noOfRooms,
                           String checkInData, String checkOutDate,String adult,String children,String checkInError) throws InterruptedException {
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
                .verifyCheckInErrorMessage(checkInError)
        ;




    }
}


