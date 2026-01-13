package testNGListners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ListnersDemo {
	WebDriver driver;
@BeforeClass

void setUp() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	
@Test(priority = 1)
void loginApp() throws InterruptedException {
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(5000);
}
@Test(priority = 3,dependsOnMethods = {"getTitle"})
void testLogo() {

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	boolean status= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	Assert.assertEquals(status, true);
}
@Test(priority = 2)
void getTitle() throws InterruptedException {
	Assert.assertEquals(driver.getTitle(),"OrageHRM");
	Thread.sleep(5000);
}
@AfterClass
void tearDown() {
	driver.close();
}

}
