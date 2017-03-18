package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchHotelPage;
import wrappers.OpentapsWrappers;

/**
 * Created by Udhayakumar PC2 on 21-05-2016.
 */
public class TC_20 extends OpentapsWrappers {

    @BeforeClass
    public void startTestCase(){
        browserName 	= "chrome";
        dataSheetName 	= "TC01_Login";
        testCaseName 	= "TC01 -Adactin Login (POM)";
        testDescription = "Login to Adactin.com using POM framework";
    }

    //comment
    @Test(dataProvider="fetchData")
    public void verify_TC20(String username,String password,String loginName) throws InterruptedException {
        new LoginPage()
                .enterUserName(username)
                .enterPassword(password)
                .clickLogin();
        new SearchHotelPage()

        ;

    }

}
