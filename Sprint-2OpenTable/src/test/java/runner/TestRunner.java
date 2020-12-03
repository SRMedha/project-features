package runner;

import org.junit.AfterClass;
import com.cucumber.listener.Reporter;

//import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/TableBooking.feature",
		glue={"stepDefinition"},
		//monochrome = true,
		//plugin = {"html:target/Destination"}
		plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests
{
	@AfterClass
	public static void writeExtentReport() 
	{
		Reporter.loadXMLConfig("src/extent-config.xml");
	}
	
}
