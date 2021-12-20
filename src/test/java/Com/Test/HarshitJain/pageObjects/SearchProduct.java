package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchProduct extends BasePage {

	public static By searchBox=By.id("search_query_top");
	public static By searchedText=By.xpath("//span[@class=\"lighter\"]");
	public static By submitSearch=By.xpath("//button[@name=\"submit_search\"]");
	public static By firstItemText=By.xpath("//span[contains(text(),'$50.99')]/../../..//div[@class='right-block']//a[@title='Printed Dress']");
	public static By firstDressText=By.xpath("//h1[text()=\"Printed Dress\"]");
	public SearchProduct(WebDriver driver) {
		super(driver);
	}

	public void textToBeSearched() {
		clickOnElement(searchBox);
		sendKeysOnElement(searchBox,"DRESS");
		clickOnElement(submitSearch);
	}
	public void verifySearchText(String text) {
		text=getElementWhenVisible(searchedText).getText();
		Assert.assertEquals(text.toString(),"\"DRESS\"");

	}
	public void searchedFirstItem() {
		clickOnElement(firstItemText);
	}
	public void verifyFirstItemText(String firstItemText) {
		//Assert.assertTrue(firstItemText.contains(getElementWhenVisible(firstItemText).getText().trim()),"Order Price has been successfully verified");
	firstItemText=getElementWhenVisible(firstDressText).getText();
		Assert.assertEquals(firstItemText.toString(),"Printed Dress");
	}
}