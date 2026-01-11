package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTCDemo {

	public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.irctc.co.in/nget/train-search");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

 // Wait for OK button in the popup
 

    WebElement okbutton=driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-top ng-tns-c25-2 ng-star-inserted']"));
    okbutton.click();
	}

}
