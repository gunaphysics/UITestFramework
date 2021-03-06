package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar on 05/20/2016.
 */
public class TC_08_VerifyTotalPrice extends OpentapsWrappers {

    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC08_VerifyTotalPrice";
        testCaseName 	= "TC03 -Adactin Check-Out Date Validation (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }



    @Test(dataProvider="fetchData")
    public void verifyTotalPrice(String username,String password, String location, String hotels, String roomType, String noOfRooms,
                               String checkInData, String checkOutDate,String adult,String billPrice) throws InterruptedException {
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
                .selectHotel()
                .clickContinue()
                .verifyTotelPrice(billPrice)

        ;


    }

}
