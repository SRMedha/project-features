package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TableBookingPage 
{
	private By calender = By.xpath("//div[@class='_2arG8EjQcHCuJnaI2Zd_m0']");
	private By time = By.xpath("//select[@aria-label= 'Time selector']");
	private By noOfPeople = By.xpath("//select[@aria-label= 'Party size selector']");
	private By letsGoButton = By.xpath("//div[@class='_2lAfpfjrkgItR8yeTshVjh']/button");
	
	WebDriver driver;
	
	public TableBookingPage(WebDriver driver)
	{
		this.driver = driver;
		//PageFactory.initElements(driver,this);
	}
	
	public void calender(String expMonth, String expDate) throws InterruptedException
	{
		driver.findElement(calender).click();
    	Thread.sleep(1000);
    	String currMonth = driver.findElement(By.xpath("//div[@class='_3wSQGqgxHiHMiJ1u9fsROH']/div")).getText();
    	if(!(expMonth.equals(currMonth)))
    	{
    		//System.out.println("Month is already selected");
    		for(int i=1;i<12;i++)
    		{
    			driver.findElement(By.xpath("//span[@role='button'][2]")).click();
    			Thread.sleep(1000);
    			currMonth = driver.findElement(By.xpath("//div[@class='_3wSQGqgxHiHMiJ1u9fsROH']/div")).getText();
    			if(expMonth.equals(currMonth))
    	    	{
    	    		//System.out.println("Month selected");
    	    		break;
    	    	}
    		}
    	}
    	
    	Thread.sleep(2000);
    	//driver.findElement(By.xpath("//div[@aria-label='Sat, Nov 30, 2020']")).click();  ----- can also use
    	
    	//WebElement datepicker = driver.findElement(By.xpath("//div[@class='_37UDSfUADpts3pRPnSG8lO']"));
    	 
    	List<WebElement> dates = driver.findElements(By.xpath("//div[@class='_37UDSfUADpts3pRPnSG8lO']/div/div"));
    			//datepicker.findElements(By.("aria-label"));
    	for(WebElement date : dates) 
    	{
    		String currDate = date.getAttribute("aria-label");
    		if(currDate.equals(expDate)) {
    			date.click();
    		}
    	}
    	Thread.sleep(1000);
	}
	
	public void timing() throws InterruptedException
	{
		Select timings = new Select(driver.findElement(time));
    	timings.selectByIndex(4);
    	Thread.sleep(1000);
	}
	
	public void noofPeople() throws InterruptedException
	{
		Select s = new Select(driver.findElement(noOfPeople));
        s.selectByIndex(4);
        Thread.sleep(1000);
	}
	
	public void clickLetsGobtn() throws InterruptedException
	{
		driver.findElement(letsGoButton).click();
		Thread.sleep(1000);
	}
	
	public void checkTitle(String expectedTBTitle) 
	{
		Assert.assertEquals(expectedTBTitle, driver.getTitle());
	}
}
