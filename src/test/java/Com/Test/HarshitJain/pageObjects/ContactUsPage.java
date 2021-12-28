package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage  extends BasePage{
	public static By contactusButton= By.id("contact-link");
	public static By subjectHeading = By.xpath("//select[@name=\"id_contact\"]");
	public static By emailAddress = By.xpath("//input[@class=\"form-control grey validate\"]");
	public static By Orderreference = By.xpath("//select[@name=\"id_order\"]");
	public static By attachFile = By.xpath("//input[@name=\"fileUpload\"]");
	public static By sendButton = By.xpath("//button[@name=\"submitMessage\"]");
	public static By messageBox=By.xpath("//textarea[@class=\"form-control\"]");
	public static By verifyMessage=By.xpath("//p[@class=\"alert alert-success\"]");
	
	public  ContactUsPage(WebDriver driver) {
		super(driver);//super use for initializTion(driver)
	}
	public void contactButton() {
		clickOnElement(contactusButton);
		Assert.assertTrue(getElementWhenVisible(contactusButton).isDisplayed());
	}
	public void subjectHeading() {
		clickOnElement(subjectHeading); 
		selectByValueInList(subjectHeading,"2");
				
	}
	
	public void emailAddress(){
		clickOnElement(emailAddress);
		sendKeysOnElement(emailAddress,"harshitjain.qait@gmail.com");	
	}
	public void orderReference() {
		clickOnElement(Orderreference);
		selectByValueInList(Orderreference,"320");
		
	}
	public void attachFile() {
		sendKeysOnElement(attachFile,"C:/Users/lenovo/Desktop/Camera/IMG20200329101545.JPG");	
		
	} 
	public void messageBox() {
		clickOnElement(messageBox);
		sendKeysOnElement(messageBox,"This framework is very useful to me");
	}
	public void sendButton() {
		clickOnElement(sendButton);
		
	}
	public void verifyContactUsDetails(String message) {
		Assert.assertEquals(getElementWhenVisible(verifyMessage).getText(),"Your message has been successfully sent to our team.");
		

}}
