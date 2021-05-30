package Com.Test.HarshitJain.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/resources/features",glue={"Com/Test/HarshitJain/stepDefs"},plugin = { "pretty", "html:target/cucumber-reports.html"})						
public class TestRunner extends AbstractTestNGCucumberTests				
{		

}