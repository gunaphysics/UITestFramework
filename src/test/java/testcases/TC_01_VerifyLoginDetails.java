package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC_01_VerifyLoginDetails extends OpentapsWrappers {
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
		dataSheetName 	= "TC01_Login";
		testCaseName 	= "TC01 -Adactin Login (POM)";
		testDescription = "Login to Adactin.com using POM framework";
	}
	
	//comment
	@Test(dataProvider="fetchData")
	public void loginForSuccess(String username,String password,String loginName) throws InterruptedException {
		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		;

	}
}
