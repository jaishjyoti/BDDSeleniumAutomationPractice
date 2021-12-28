package Com.Test.HarshitJain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GlobalHeaderAndFooterPresentOrNot extends BasePage {
	public static By followUsText=By.xpath("//h4[text()='Follow us']");
	public static By fbLogo =By.xpath("//a[@href='http://www.facebook.com/prestashop']");
	public static By twitterLogo =By.xpath("//a[@href='http://www.twitter.com/prestashop']");
	public static By googleLogo =By.xpath("//a[@href='https://www.google.com/+prestashop']");
	public static By prestaShopLogo =By.xpath("//a[@href='http://www.prestashop.com/blog/en/']");
    public static By newslettertext=By.xpath("//h4[text()='Newsletter']");
    public static By enterYourEmailBox=By.id("newsletter-input");
    public static By clickEnterYourEmailBox=By.xpath("//button[@name='submitNewsletter']");
	public static By verifysubscribeMessage=By.xpath("//p[@class=\"alert alert-danger\"]");

    
	public GlobalHeaderAndFooterPresentOrNot (WebDriver driver) {
		super(driver);
	}
	public void checkTextPresentInGlobalFooter() {

		Assert.assertTrue(getElementWhenVisible(followUsText).isDisplayed());

	} public void clickOnFb() {
		clickOnElement(fbLogo);
	} 
	public void clickOnTwitter() {
		clickOnElement(twitterLogo);
	}
	public void clickOnGoogle() {
		clickOnElement(googleLogo);
		
	} public void clickOnPrestaShop() {
		clickOnElement(prestaShopLogo);
	} public void checkTextNewsletterPresentInGlobalFooter() {
		Assert.assertTrue(getElementWhenVisible(newslettertext).isDisplayed());
		
	} public void checkEnterYourEmailText() {
		clickOnElement(enterYourEmailBox);
		sendKeysOnElement(enterYourEmailBox,"harshitjain.qait@gmail.com");	
		clickOnElement(clickEnterYourEmailBox);
		System.out.println("successfully");
	} public void verifyNewsletterPlaceholder(String message) {
		Assert.assertEquals(getElementWhenVisible(verifysubscribeMessage).getText(),"Newsletter : This email address is already registered.");
	}
	}
