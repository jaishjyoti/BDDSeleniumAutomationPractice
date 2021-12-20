package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	
	public static By myAccountPageHeader = By.xpath("//h1[text()='My account']");
	public static By orderHistoryAndDetails = By.xpath("//span[text()='Order history and details']");
	public static By homeButton = By.cssSelector("[title='Home']");
	
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
	
}
