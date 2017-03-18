package pages;

import wrappers.OpentapsWrappers;

public class Hotel_Entry_Page extends OpentapsWrappers {
	public Hotel_Entry_Page enterLocation(String location){
		enterByXPath(prop.getProperty("CreateContact.FirstName.XPath"),location);
		return this;
	}

}
