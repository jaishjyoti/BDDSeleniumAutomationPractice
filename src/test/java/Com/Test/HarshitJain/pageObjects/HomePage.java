package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import Com.Test.HarshitJain.utilities.PropFileHandler;

public class HomePage extends BasePage {

	public static By signIn = By.className("login");
	public static By tShirtsTab = By.cssSelector(".sf-menu>li>a[title='T-shirts']");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void launchURL() {
		visit(PropFileHandler.readProperty("appURL"));
	}
	
	public void selectSignIn() {
		clickOnElement(signIn);
	}
	
	public void selectTshirtsTab() {
		clickOnElement(tShirtsTab);
	}

}
