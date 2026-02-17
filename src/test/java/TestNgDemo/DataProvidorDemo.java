package TestNgDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidorDemo {
	WebDriver driver;
	@BeforeClass
	void setUp() {
		System.out.println("Launch the application");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	@Test(dataProvider = "testdata")
	void LoginTest(String email, String password) throws InterruptedException {

	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

	    driver.findElement(By.id("input-email")).sendKeys(email);
	    driver.findElement(By.id("input-password")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();

	    boolean status = driver.findElement(
	        By.xpath("//h2[normalize-space()='My Account']")
	    ).isDisplayed();

	    Assert.assertTrue(status, "Login failed for user: " + email);

	    driver.findElement(
	        By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")
	    ).click();
	}
	@DataProvider(name="testdata")
	Object[][] TestData() {
		Object data[][]= {
				
				{"vamshi","test@123"},
				{"Krishna","Test@321"},
				{"pavan","test9"},
				{"kiran","98987"},
				};
		return data;
	}

	void tearDown() {
		driver.close();
	}
}
