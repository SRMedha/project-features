
package pageObject;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestData 
{
		WebDriver driver;
		
		public TestData(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		
		public void user_is_signed_in_to_opentable() throws Throwable 
		{
			System.out.println("User is logged into account");
			//driver.findElement(By.id("global_nav_sign_in")).click();
			driver.findElement(By.xpath("//div[@class='_2UIXA4qZp-BBVaEsy-Fj4H']/button[2]")).click();    
			Thread.sleep(7000);
			FileReader fr1 = new FileReader("testData.properties");
			Properties data = new Properties();
			data.load(fr1);
			
			WebElement we = driver.findElement(By.xpath("//iframe[@title='Sign in']"));
			driver.switchTo().frame(we);
			driver.findElement(By.id(data.getProperty("emailid"))).sendKeys("medhasr168@gmail.com");
			driver.findElement(By.id(data.getProperty("pass"))).sendKeys("abc@1234");
			driver.findElement(By.id("signInButton")).click();
			Thread.sleep(3000);
		}
}

