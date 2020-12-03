package pageObject;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllDiningOptions 
{
	WebDriver driver;
	
//	@FindBy(linkText = "All dining options")
//	WebElement allDiningOptions;
	
	public AllDiningOptions(WebDriver driver) 
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void checkTitle(String expectedADPTitle )
	{
		//return allDiningOptions;
		Assert.assertEquals(expectedADPTitle, driver.getTitle());
	}
}
// Need to check this.. Here instead of return allDi..Op.., I should write isSelected for checking the page... It was done.