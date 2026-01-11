package TestNgDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * Open Application
 * Login to application
 * Logout to application
 * Close
 * 
 * */
public class OrangeHRMDemo {
	WebDriver driver;
	
	@Test(priority = 0)
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test(priority = 1)
	void testLogo() {
	boolean Logo_status=	driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println(Logo_status);
	}
	@Test(priority = 2)
	void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test(priority = 3)
	void logout() {
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
		driver.close();
	}
  
	
}
