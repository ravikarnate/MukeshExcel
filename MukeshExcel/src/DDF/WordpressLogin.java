package DDF;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class WordpressLogin {

	WebDriver driver;
	@Test(dataProvider="workpressdata")
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
	
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="workpressdata")
	public Object[][] passData()
	{
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "admin1";
		data[0][1] = "demo1";
		
		data[1][0] = "admin";
		data[1][1] = "demo123";
		
		data[2][0] = "admin2";
		data[2][1] = "demo2";
		
		return data;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
