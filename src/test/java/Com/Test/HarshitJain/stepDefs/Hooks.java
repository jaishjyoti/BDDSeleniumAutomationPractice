 package Com.Test.HarshitJain.stepDefs;

import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import Com.Test.HarshitJain.pageObjects.TestSessionInitiator;
import Com.Test.HarshitJain.utilities.PropFileHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void beforeScenario() {
		new TestSessionInitiator(PropFileHandler.readProperty("browser"));
	}
	
	
	@After
	public void afterScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			try {
				byte[] file = ((TakesScreenshot) TestSessionInitiator.driver).getScreenshotAs(OutputType.BYTES);
			    scenario.attach(file, "image/png",scenario.getName());
			}
			 catch (WebDriverException somePlatformsDontSupportScreenshots) {
		            System.out.println(somePlatformsDontSupportScreenshots.getMessage());
		        } catch (ClassCastException cce) {
		            cce.printStackTrace();
		        }
		}	
		TestSessionInitiator.driver.quit();
	}
}
