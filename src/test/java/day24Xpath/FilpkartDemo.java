package day24Xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilpkartDemo {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.flipkart.com/");
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='button']")));

closeButton.click();

driver.findElement(By.xpath("(//input[@name='q'])[1]")).sendKeys("Power bank");
driver.findElement(By.xpath("//button[@type='submit']")).click();
List<WebElement> allList= driver.findElements(By.xpath("//a[@class='pIpigb']"));
for(WebElement powerBanks : allList) {
System.out.println(	powerBanks.getText());
}
}
	}


