package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderHistory extends BasePage {

	public static By pageHeader = By.xpath("//h1[text()='Order history']");
	public static By orderReference = By.cssSelector("tr.first_item .color-myaccount");
	public static By orderPrice = By.cssSelector(".first_item .history_price");
	
	
	public OrderHistory(WebDriver driver) {
		super(driver);
	}
	
	public void userIsOnOrderHistoryPage() {
		Assert.assertTrue(getElementWhenVisible(pageHeader).isDisplayed());
	}
	
	public void verifyOrderDetails(String orderDetails) {
		Assert.assertTrue(orderDetails.contains(getElementWhenVisible(orderReference).getText().trim()),"Order Reference has been successfully verified");
		Assert.assertTrue(orderDetails.contains(getElementWhenVisible(orderPrice).getText().trim()),"Order Price has been successfully verified");
	}

}
