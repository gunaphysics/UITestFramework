package wrappers;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utils.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


public class GenericWrappers {

	protected static RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch only firefox and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Babu - TestLeaf
	 * @param url - The url with http or https
	 * 
	 */
	public boolean invokeApp(String browser) {
		boolean bReturn = false;
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();		
			Reporter.reportStep("The browser:" + browser + " launched successfully", "PASS");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
		return bReturn;
	}

	/*---------------------Below are the Methods to Enter Text using Locators----------------------*/
	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterById(String idValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
		}
		return bReturn;
	}

	public boolean enterByName(String nameValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+nameValue, "FAIL");
		}
		return bReturn;
	}
	
	public boolean enterByXPath(String xpathValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+xpathValue, "FAIL");
		}
		return bReturn;
	}
	
	public boolean enterByClassName(String classNameValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.className(classNameValue)).clear();
			driver.findElement(By.className(classNameValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+classNameValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+classNameValue, "FAIL");
		}
		return bReturn;
	}
	
	public boolean enterByTagName(String TagValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.tagName(TagValue)).clear();
			driver.findElement(By.tagName(TagValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+TagValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+TagValue, "FAIL");
		}
		return bReturn;
	}

	public boolean enterByCSS(String cssValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.cssSelector(cssValue)).clear();
			driver.findElement(By.cssSelector(cssValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+cssValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+cssValue, "FAIL");
		}
		return bReturn;
	}
	
	
	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				Reporter.reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				Reporter.reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			Reporter.reportStep("The title did not match", "FAIL");
		}

		return bReturn;
	}
	/*----------------------Verifying Text Using Locators----------------------------------*/
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextById(String idValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(idValue).getText();
		if (driver.findElementById(idValue).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextboxValueById(String idValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(idValue).getAttribute("value");
		if (sText.trim().equals(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextByName(String nameValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementByName(nameValue).getText();
		if (driver.findElementByName(nameValue).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextByClassName(String className, String text){
		boolean bReturn = false;
		String sText = driver.findElementByClassName(className).getText();
		if (driver.findElementByClassName(className).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextByLinkText(String linkText, String text){
		boolean bReturn = false;
		String sText = driver.findElementByLinkText(linkText).getText();
		if (driver.findElementByLinkText(linkText).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextByPartialLink(String partialLinkValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementByPartialLinkText(partialLinkValue).getText();
		if (driver.findElementByPartialLinkText(partialLinkValue).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextByTagName(String tagValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementByTagName(tagValue).getText();
		if (driver.findElementByTagName(tagValue).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextByCSS(String cssValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementByCssSelector(cssValue).getText();
		if (driver.findElementByCssSelector(cssValue).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}

		return bReturn;
	}
	
/*---------------------Verifying using Locators and .Contains------------------*/	
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextContainsByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}
	
	public boolean verifyTextContainsById(String id, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(id).getText();
		if (driver.findElementById(id).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextContainsByName(String name, String text){
		boolean bReturn = false;
		String sText = driver.findElementByName(name).getText();
		if (driver.findElementByName(name).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextContainsByClassName(String className, String text){
		boolean bReturn = false;
		String sText = driver.findElementByClassName(className).getText();
		if (driver.findElementByClassName(className).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextContainsByLinkText(String linkText, String text){
		boolean bReturn = false;
		String sText = driver.findElementByLinkText(linkText).getText();
		if (driver.findElementByLinkText(linkText).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextContainsByPartialLink(String partialLink, String text){
		boolean bReturn = false;
		String sText = driver.findElementByPartialLinkText(partialLink).getText();
		if (driver.findElementByPartialLinkText(partialLink).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextContainsByTagName(String tagNam, String text){
		boolean bReturn = false;
		String sText = driver.findElementByTagName(tagNam).getText();
		if (driver.findElementByTagName(tagNam).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}

	public boolean verifyTextContainsByCSS(String cssValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementByCssSelector(cssValue).getText();
		if (driver.findElementByCssSelector(cssValue).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}

		return bReturn;
	}

	/**
	 * This method will close all the browsers
	 * @author Babu - TestLeaf
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Reporter.reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}

	/*--------------------Clicking the Webelement using Locators------------------------------*/
	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(id)).click();
			Reporter.reportStep("The element with id: "+id+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.className(classVal)).click();
			Reporter.reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.name(name)).click();
			Reporter.reportStep("The element with name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
/**
 * This Method will click the element using Partial Link Text
 * @param name partialLinkText
 * @return boolean
 */
	public boolean clickByPartialLink(String partialLinkText) {
		boolean bReturn = false;
		try{
			driver.findElement(By.partialLinkText(partialLinkText)).click();
			Reporter.reportStep("The element with link name: "+partialLinkText+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with link name: "+partialLinkText+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	public boolean clickByLink(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.linkText(name)).click();
			Reporter.reportStep("The element with link name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			Reporter.reportStep("The element : "+xpathVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	
	public static String getUrl()
	{
		 String url=driver.getCurrentUrl();
		int length=url.length();
	String currentURL=url.substring(length-5, length);
		
		return currentURL;
	}

	/*-----------------------Mouse Over action using the Locators---------------*/
	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			Reporter.reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	public boolean mouseOverById(String idValue) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.id(idValue))).build().perform();
			Reporter.reportStep("The mouse over by xpath : "+idValue+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+idValue+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByPartialLinkText(String partialLinkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.partialLinkText(partialLinkName))).build().perform();
			Reporter.reportStep("The mouse over by link : "+partialLinkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+partialLinkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	public boolean mouseOverByName(String nameVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.name(nameVal))).build().perform();
			Reporter.reportStep("The mouse over by xpath : "+nameVal+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+nameVal+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByClass(String className) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.className(className))).build().perform();
			Reporter.reportStep("The mouse over by link : "+className+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+className+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	public boolean mouseOverByTagName(String tagName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.tagName(tagName))).build().perform();
			Reporter.reportStep("The mouse over by xpath : "+tagName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+tagName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByCSS(String cssValue) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssValue))).build().perform();
			Reporter.reportStep("The mouse over by link : "+cssValue+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+cssValue+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
/*----------------------------Getting Text using Locators---------------------*/
	
	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public String getTextById(String id){
		String bReturn = "";
		try{
			return driver.findElementById(id).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+id+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public String getTextByName(String nameVal){
		String bReturn = "";
		try{
			return driver.findElement(By.name(nameVal)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+nameVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public String getTextByClassName(String className){
		String bReturn = "";
		try{
			return driver.findElementByClassName(className).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+className+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public String getTextByLinkText(String linkText){
		String bReturn = "";
		try{
			return driver.findElement(By.linkText(linkText)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+linkText+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public String getTextByPartialLink(String partialLinkVal){
		String bReturn = "";
		try{
			return driver.findElementByPartialLinkText(partialLinkVal).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+partialLinkVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public String getTextByTagName(String tagName){
		String bReturn = "";
		try{
			return driver.findElement(By.tagName(tagName)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+tagName+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public String getTextByCSS(String cssValue){
		String bReturn = "";
		try{
			return driver.findElementByCssSelector(cssValue).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+cssValue+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
/*------------------------Selecting Options using Locators------------------*/
	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public boolean selectById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			Reporter.reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
		return bReturn;
	}






	/*-------------------------------------------Handling Alerts-------------------------------------------*/
	public void acceptAlert() {
		try{
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (Exception e) {
			Reporter.reportStep("No Alert Found ", "FAIL");
		}
	}
	
	public void cancelAlert() {
		try{
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (Exception e) {
			Reporter.reportStep("No Alert Found ", "FAIL");
		}
	}
	
	public String getAlertText() {
	
			Alert alert = driver.switchTo().alert();
			return alert.getText();
	}
	
	public void sendTextToAlert(String text) {
		try{
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
			alert.accept();

		} catch (Exception e) {
			Reporter.reportStep("No Alert Found ", "FAIL");
		}
	}
	
	public void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File("./object.properties")));
	
	}

	public void selectByVisibleTextByID(String id,String value){
		new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
	}
	public void fluentWait(final By element, int totalWait, int pollingInterval)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(totalWait, SECONDS)
				.pollingEvery(pollingInterval, SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(element);
			}
		});

	}


}

