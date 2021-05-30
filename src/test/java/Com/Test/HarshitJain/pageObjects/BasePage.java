package Com.Test.HarshitJain.pageObjects;

import static org.testng.Assert.fail;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Harshit
 */
public class BasePage {

	public WebDriver driver;
	
	public static By productToCheckout = By.xpath("(//span[contains(text(),'Proceed to checkout')])[last()]");
	public static By successMessage = By.cssSelector("p.alert.alert-success");

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void visit(String appURL) {
		driver.get(appURL);
	}

	protected WebElement getElementWhenVisible(By elementToken) {
		WebElement foundElement=null;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			foundElement = wait.until(ExpectedConditions.presenceOfElementLocated(elementToken));
		} catch (NoSuchElementException excp) {
			fail("[ASSERT FAILED]: Element " + elementToken + " not found on the webPage !!!");
		} catch (NullPointerException npe) {
			fail("[UNHANDLED EXCEPTION]: " + npe.getLocalizedMessage());
		}
		return foundElement;
	}
	
	protected boolean clickOnElement(By elementToken) {
		try {
			WebElement el = getElementWhenVisible(elementToken);
			el.click();
			return true;
		} catch (NullPointerException npe) {
			fail("[UNHANDLED EXCEPTION]: " + npe.getLocalizedMessage());
		}
		return false;
	}
	
	protected boolean sendKeysOnElement(By elementToken, String text) {
		try {
			WebElement el = getElementWhenVisible(elementToken);
			el.sendKeys(text);
			return true;
		} catch (NullPointerException npe) {
			fail("[UNHANDLED EXCEPTION]: " + npe.getLocalizedMessage());
		}
		return false;
	}
	
	
	protected boolean selectByValueInList(By elementToken, String text) {
		try {
			Select s = new Select(getElementWhenVisible(elementToken));
			s.selectByValue(text);
			return true;
		} catch (NullPointerException npe) {
			fail("[UNHANDLED EXCEPTION]: " + npe.getLocalizedMessage());
		}
		return false;
	}
	
	protected void clickOnElementViaJS(By elementToken) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getElementWhenVisible(elementToken));
	}
	
	protected void hoverOnElement(By elementToken) {
		Actions ac = new Actions(driver);
		try {
			WebElement el = getElementWhenVisible(elementToken);
			ac.moveToElement(el).build().perform();;
		} catch (NullPointerException npe) {
			fail("[UNHANDLED EXCEPTION]: " + npe.getLocalizedMessage());
		}
		
	}
	
	protected void switchToLastWindow() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		int n=tabs.size();
		driver.switchTo().window(tabs.get(n-1));
	}
	
	protected void switchToFrame(By frame) {
		driver.switchTo().frame(getElementWhenVisible(frame));
	}
	
	protected boolean matchPageTitle(String title) {
		if(driver.getTitle()==title)
			return true;
		else
			return false;
	}
	
	protected boolean matchText(By elementToken,String text) {
		try {
			WebElement el = getElementWhenVisible(elementToken);
			if(el.getText().contains(text))
				return true;
			else
				return false;
		} catch (NullPointerException npe) {
			fail("[UNHANDLED EXCEPTION]: " + npe.getLocalizedMessage());
		}
		return false;
	}
	
	public void waitToLoad(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getPassedAttribute(By elementToken, String attribute) {
		String attributeValue = getElementWhenVisible(elementToken).getAttribute(attribute);
		return attributeValue;
	}
	
	public void selectProceedToCheckout() {
		clickOnElement(productToCheckout);
	}
	
	public void successMsgIsDisplayed(String successMsg) {
		Assert.assertEquals(matchText(successMessage,successMsg), true,"Personal Information has been updated Successfully");
	}

}
