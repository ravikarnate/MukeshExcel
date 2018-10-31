package DDF;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelDataConfig;


public class WordpressLoginExcel {

	WebDriver driver;
	@Test(dataProvider="wordpressdata")
	public void loginToWordpress(String username, String password) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","/home/ravindranath/Downloads/chromedriver_linux64/chromedriver");
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	driver.get("http://demosite.center/wordpress/wp-login.php?loggedout=true");
	
	driver.findElement(By.id("user_login")).sendKeys(username);
	driver.findElement(By.id("user_pass")).sendKeys(password);
	driver.findElement(By.id("wp-submit")).click();	
	Thread.sleep(3000);
	System.out.println(driver.getTitle());
    Assert.assertTrue(driver.getTitle().contains("Dashboard"), "User is not able to Login");
	System.out.println("Page title verified  - User is able to login successfully");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="wordpressdata")
	public Object[][] passData()
	{
		
		ExcelDataConfig config = new ExcelDataConfig("/home/ravindranath/eclipse-workspace/MukeshExcel/TestData/wordpress.xlsx");
		
		int rows = config.getRowCount(0);
				
		Object[][] data = new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			data[i][0] = config.getData(0, i, 0); 
			data[i][1] = config.getData(0, i, 1);
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
