package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 21-05-2016.
 */
public class TC_11_VerifyConfirmationPageInfo extends OpentapsWrappers {
    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC11_VerifyConfirmationpageInformation";
        testCaseName 	= "TC11_VerifyConfirmationpageInformation (POM)";
        testDescription = "TC11_VerifyConfirmationpageInformation using POM framework";
    }



    @Test(dataProvider="fetchData")
    public void verifyConfirmationPageInfoTC_11(String username,String password, String location, String hotels, String roomType, String noOfRooms,
                                 String checkInData, String checkOutDate,String adult,String totalDay,String pricepernight) throws InterruptedException {
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
                .verifyHotelLocation(location)
                .verifyHotelName(hotels)
                .verifyRoomType(roomType)
                .verifyTotalDay(totalDay)
                .verifyPriceperNight(pricepernight)
        ;


    }

}