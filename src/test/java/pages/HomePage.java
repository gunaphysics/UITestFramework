package pages;

import wrappers.OpentapsWrappers;

public class HomePage extends OpentapsWrappers {

	
	// Verify the username
	public HomePage verifyLoggedinUserName(String userName){
		verifyTextContainsByXpath(prop.getProperty("Home.UserName.Xpath"), userName);
		return this;
	}
	public LogoutPage clickLogout(){
		clickByLink(prop.getProperty("LogoutPage.Logout.Link"));
		return new LogoutPage();
	}
	public HomePage enterLocation(String location){
		enterByXPath(prop.getProperty("CreateContact.FirstName.XPath"),location);
		return this;
	}

	public SearchHotelPage clickSearch(){
		clickByLink(prop.getProperty("Search.Hotel.LinkText"));
		return new SearchHotelPage();
	}

	
}