package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage extends BasePage {

	public static By searchResult_tshirt = By.cssSelector("div.product-container");
	public static By addToCart = By.cssSelector(".ajax_add_to_cart_button");


	public SearchProductPage(WebDriver driver) {
		super(driver);
	}

	public void hoverOnTshirts() {
		hoverOnElement(searchResult_tshirt);
	}

	public void selectAddToCart() {
		clickOnElement(addToCart);
	}

}
