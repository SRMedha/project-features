package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven 
{

	WebDriver driver;
	
	@BeforeMethod
	public void before()
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\RajaRajeshwari\\Desktop\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "user")
	public void verify(String email, String pass) throws Exception
	{
		System.out.println("Validating data");
		System.out.println(email);
		System.out.println(pass);
		driver.get("https://www.opentable.com/start/home");
		Thread.sleep(1000);
//		driver.findElement(By.className("fa-user")).click();
//		Thread.sleep(1000);
		//driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//div[@class='_2UIXA4qZp-BBVaEsy-Fj4H']/button[2]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys(email);
		Thread.sleep(2000);
		//driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(pass);
		Thread.sleep(2000);
	}
	
	@DataProvider(name ="user")
	public String[][] data() throws Exception
	{
		String[][] arrobj = getDataFromXLSX("sample.xlsx");
		return arrobj;
	}
	public String[][] getDataFromXLSX(String filename) throws IOException 
	{
		String[][] array = null;
		FileInputStream fs= new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheetAt(0);
		XSSFRow rows;
		XSSFCell cell;
		
		int rowCount = sh.getLastRowNum();
		int columnCount = sh.getRow(0).getLastCellNum();
		
		array = new String[rowCount][columnCount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				rows = sh.getRow(i);
				cell = rows.getCell(j);
				array[i-1][j] = cell.getStringCellValue();
			}
		}
		return array;
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}

