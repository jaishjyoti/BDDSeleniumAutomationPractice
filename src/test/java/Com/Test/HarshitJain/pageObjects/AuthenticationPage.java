package Com.Test.HarshitJain.pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;

public class AuthenticationPage extends BasePage {

	public static By emailAddress = By.cssSelector(".clearfix [name='email']");
	public static By password = By.cssSelector(".clearfix [name='passwd']");
	public static By signInButton = By.id("SubmitLogin");
	
	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}
	
	public void submitCredentials(DataTable usercredentials) {
		List<List<String>> data = usercredentials.asLists();
		sendKeysOnElement(emailAddress,data.get(0).get(0));
		sendKeysOnElement(password,data.get(0).get(1));
		clickOnElement(signInButton);
	}
	
	

	
}
