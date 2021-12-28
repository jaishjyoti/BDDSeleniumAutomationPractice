package Com.Test.HarshitJain.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchProduct extends BasePage {

	//private static final String firstItemText = null;
	public static By searchBox=By.id("search_query_top");
	public static By searchedText=By.xpath("//span[@class=\"lighter\"]");
	public static By searchButton=By.xpath("//button[@name=\"submit_search\"]");
	public static By firstItem=By.xpath("(//a[@class='product-name'][@itemprop='url'])[1]");
	public static By productName=By.xpath("//h1[text()=\"Printed Dress\"]");
	private String firstProductName;
    private String productNameAfterClick;
    String title;
    
	public SearchProduct(WebDriver driver) {
		super(driver);
	}
	public void textToBeSearched() {
		clickOnElement(searchBox);
		sendKeysOnElement(searchBox,FileReader.getUserTypeDetails("1","Product name"));
		clickOnElement(searchButton);
		System.out.println("Text to be searched");
	}
	public void verifySearchText(String text) {
		text=getElementWhenVisible(searchedText).getText();
		Assert.assertEquals(text.toString(),"\"DRESS\"");
	System.out.println("Verified searched text");

	}
	public void getFirstProductName() {
	 firstProductName=getElementWhenVisible(firstItem).getText();
	 System.out.println("Get first product name");
	}
	public void selectFirstProduct() {
		clickOnElement(firstItem);
		System.out.println("First product clicked");
		title =driver.getTitle();
	}
	public void getProductNameAfterClick() {
		productNameAfterClick=getElementWhenVisible(productName).getText();
		
	}
	public void verifyProductName() {
		Assert.assertEquals(firstProductName,productNameAfterClick);
		System.out.println("Succesfully verified product name");
	}
	
	public void verifyTitle()
	{
		assertTrue(title.contains(firstProductName));
		System.out.println("Successfully verified Title"+title);
	}
}