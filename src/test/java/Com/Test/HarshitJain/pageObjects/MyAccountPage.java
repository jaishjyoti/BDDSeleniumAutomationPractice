package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	
	public static By myAccountPageHeader = By.xpath("//span[text()='My account']");
	public static By orderHistoryAndDetails = By.xpath("//span[text()='Order history and details']");
	public static By myPersonalInformation = By.xpath("//span[text()='My personal information']");
	public static By homeButton = By.cssSelector("[title='Home']");
	public static By firstName = By.id("firstname");
	public static By oldPassword = By.id("old_passwd");
	public static By saveBtn = By.cssSelector("[name='submitIdentity']");
	public static By accountName = By.cssSelector(".account>span");
	
	String currentName;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public void userIsOnMyAccountPage() {
		Assert.assertTrue(getElementWhenVisible(myAccountPageHeader).isDisplayed());
	}
	
	public void selectHome() {
		clickOnElement(homeButton);
	}
	
	public void selectMyPersonalInformation() {
		clickOnElement(myPersonalInformation);
	}
	
	public void updateFirstName() {
		currentName = getElementWhenVisible(firstName).getText();
		sendKeysOnElement(firstName, currentName+"a");
		sendKeysOnElement(oldPassword, "Qait@123");
		clickOnElement(saveBtn);
	}
	
	public void verifyFirstNameIsUpdated() {
		Assert.assertEquals(matchText(accountName,currentName+"a"), true,"Updated first name appears on Account Name");
	}
	
}
