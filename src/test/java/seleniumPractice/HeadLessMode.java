package seleniumPractice;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadLessMode {

	public static void main(String[] args) {
		
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("--window-size=1920,1080");
	WebDriver driver = new ChromeDriver(options);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	driver.get("http://www.google.com");
    String pageTitle=driver.getTitle();
    System.out.println(pageTitle);
     WebElement googleSpace= wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
     googleSpace.click();
  
	}

}
