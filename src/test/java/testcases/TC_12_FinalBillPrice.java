package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 21-05-2016.
 */
public class TC_12_FinalBillPrice extends OpentapsWrappers {
    @BeforeClass
    public void startTestCase() {
        browserName = "chrome";
        dataSheetName = "TC12_FinalBillPrice";
        testCaseName = "TC03 -Adactin Check-Out Date Validation (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }


    @Test(dataProvider = "fetchData")
    public void verifyFinalBillPriceTC_12(String username, String password, String location, String hotels, String roomType, String noOfRooms,
                                          String checkInData, String checkOutDate, String adult,String finalbill) throws InterruptedException {
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
                .verifyFinalbilledPrice(finalbill)
        ;

    }
}