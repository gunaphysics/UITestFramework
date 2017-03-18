package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchHotelPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 21-05-2016.
 */
public class TC_17 extends OpentapsWrappers {
    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC17";
        testCaseName 	= "TC03 -Adactin Check-Out Date Validation (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }



    @Test(dataProvider="fetchData")
    public void verify_TC17(String username,String password, String orderID) throws InterruptedException {
        new LoginPage()
                .enterUserName(username)
                .enterPassword(password)
                .clickLogin();
        new SearchHotelPage()
                .clickBookedItinerary()
                .enterOrderID(orderID)
                .clickGoButton()
        .clickOrdercancelButton()

        ;

    }
}
