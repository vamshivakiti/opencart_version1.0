package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Loginpage;

public class LoginTest   {
	WebDriver driver;
	
	@BeforeClass
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test
	void loginTest() 
	{
		Loginpage lp =new Loginpage(driver);
		
		
	}
	@AfterClass
	void tearDown() {
		
	}
	

}
