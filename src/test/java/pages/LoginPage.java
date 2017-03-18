package pages;


//import org.testng.annotations.BeforeClass;

import wrappers.OpentapsWrappers;

public class LoginPage extends OpentapsWrappers {



	

	// Enter the user name
	public LoginPage enterUserName(String userdata){
		enterById(prop.getProperty("Login.UserName.Id"), userdata);
		return this;
	}

	// Enter the password
	public LoginPage enterPassword(String pass){
		enterById(prop.getProperty("Login.Password.Id"), pass);

		return this;
	}

	// Click Login
	public SearchHotelPage clickLogin(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return new SearchHotelPage();
	}

	public LogoutPage clickLogout(){
		clickByLink(prop.getProperty("LogoutPage.Logout.Link"));
		return new LogoutPage();
	}
	// Click Login
	public LoginPage clickLoginForFailure(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return this;
	}


	public LoginPage getErrorMessage(){
		System.out.println(getTextByXpath("//*[@id='errorDiv']"));
		return this;
	}

}
