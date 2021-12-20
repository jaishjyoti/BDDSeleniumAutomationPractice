package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

	public static By termsOfServiceCheckbox = By.cssSelector(".checkbox>label");
	public static By addToCart = By.cssSelector(".ajax_add_to_cart_button");
	public static By payByCheck = By.className("cheque");
	public static By iConfirmMyOrder = By.cssSelector("[type='submit'].button-medium");
	public static By backToOrders = By.cssSelector("[title$='order history page']");
	public static By orderDetails = By.cssSelector("div.box.order-confirmation");
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectTermsOfServiceCheckbox() {
		clickOnElement(termsOfServiceCheckbox);
	}
	
	public void selectPayByCheck() {
		clickOnElement(payByCheck);
	}
	
	public void selectIConfirmMyOrderButton() {
		clickOnElement(iConfirmMyOrder);
	}
	
	public void selectBackToOrders() {
		clickOnElement(backToOrders);
	}
	
	public String getOrderDetails() {
		return getElementWhenVisible(orderDetails).getText();
	}

}
