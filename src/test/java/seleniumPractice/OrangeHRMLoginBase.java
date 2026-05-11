package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

/**
 * Base class for OrangeHRM Login Test - contains common setup and teardown
 */
public class OrangeHRMLoginBase {

	protected WebDriver driver;
	protected static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeTest
	public void setUp() {
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--incognito");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		System.out.println("Browser launched and navigated to login page");
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed");
		}
	}

	protected void navigateToLoginPage() {
		driver.get(LOGIN_URL);
		System.out.println("Navigated to: " + LOGIN_URL);
	}
}
