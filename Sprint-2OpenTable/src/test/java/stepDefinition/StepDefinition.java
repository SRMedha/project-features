package stepDefinition;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import pageObject.AllDiningOptions;
import pageObject.TableBookingPage;
import pageObject.TestData;

public class StepDefinition 
{
	
		String expectedADPTitle = "Restaurant Reservation Availability | OpenTable";
		String expectedTBTitle = "Restaurants and Restaurant Reservations | OpenTable";
		WebDriver driver;
		String baseurl = "https://www.opentable.com/start/home";
		TableBookingPage tp;
		AllDiningOptions ap;
		TestData td;
		
		@Before			//Starting the driver
		public void start() 
		{
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\RajaRajeshwari\\Desktop\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			System.out.println("Started....");
			//htmlLocation = "file:"+System.getProperty("user.dir")+"/Coaching_Class_Enquiry.html";
			tp = new TableBookingPage(driver);
			ap = new AllDiningOptions(driver);
			td = new TestData(driver);
		}
		
		@After 		//Closing the driver
		public void driverClose()
		{
			driver.close();
			System.out.println("Ended....");
		}
	
		
		  @Given("^User is signed in to openTable$") 
		  public void user_is_signed_in_to_opentable() throws Throwable 
		  {
		  //System.out.println("^User is signed in to openTable$");
		  //driver.get(baseurl); //tp = new TableBookingPage(driver);
		  //hp.checkTitle(expectedHomePageTitle);
			  driver.get(baseurl);
			  td.user_is_signed_in_to_opentable();
		  }
		 

	    @Then("^User is redirected to All Dining Options page$")
	    public void user_is_redirected_to_all_dining_options_page() throws Throwable 
	    {
	        //System.out.println("^User is redirected to All Dining Options page$");
	    	ap = new AllDiningOptions(driver);
	    	System.out.println("Ap title "+driver.getTitle());
	    	ap.checkTitle(expectedADPTitle); 
	    	screenCapture();
	    	
	    	System.out.println("Successful");
	    }

	    @And("^User is in Home page$")
	    public void user_is_in_home_page() throws Throwable 
	    {
	        //System.out.println("^User is in Home page$");
	    	//driver.get(baseurl);
	    	//tp = new TableBookingPage(driver);
			tp.checkTitle(expectedTBTitle);
			screenCapture();
	    }
	    
	    @And("^User selects calender$")
	    public void user_selects_date() throws Throwable 
	    {
	    	
	        //System.out.println("^User selects date$");
	    	String expMonth = "January 2021";
	    	String expDate = "Sat, Jan 30, 2021";
	    	tp.calender(expMonth, expDate);
	    	screenCapture();
	    }
	    
	    
	    @And("^User selects time$")
	    public void user_selects_time() throws Throwable 
	    {
			//System.out.println("^User selects time$");
	    	tp.timing();
	    	screenCapture();
	    }

	    @And("^User selects no:of people$")
	    public void user_selects_noof_people() throws Throwable 
	    {
	        //System.out.println("^User selects no:of people$");
	    	tp.noofPeople();
	    	screenCapture();
	    }

	    @And("^User clicks on Let's Go button$")
	    public void user_clicks_on_lets_go_button() throws Throwable 
	    {
	        //System.out.println("^User clicks on Let's Go button$");
	    	tp.clickLetsGobtn();
	    	
	    }
	    
	    
	    public void screenCapture() throws IOException
	    {
		  //Convert web driver object to TakeScreenshot
		  TakesScreenshot scrShot = ((TakesScreenshot)driver);
		  
		  //Call getScreenshotAs method to create image file
		  File scrFile= scrShot.getScreenshotAs(OutputType.FILE);
		  
		  //Move image file to new destination
//		  File destFile = new File ("C:\\Users\\hp\\Desktop\\Automation\\Screenshots\\img"+System.currentTimeMillis()+"_01"+".png");
		  File destFile = new File ("F:\\eclipse-workspace\\Sprint-2OpenTable\\target\\Destination\\img"+System.currentTimeMillis()+"_01"+".png");
		  
		  //Copy file at destination
		  FileUtils.copyFile(scrFile, destFile); 
		  Reporter.log("<br><img src='"+destFile+"' height='300' width='300'/><br>");
	    } 

}
