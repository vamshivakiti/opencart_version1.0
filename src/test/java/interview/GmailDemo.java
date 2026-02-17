package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailDemo {

	public static void main(String[] args) {
  WebDriver driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
  driver.get("http://gmail.com");
  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vamshi.qaeng@gail.com");
  driver.findElement(By.xpath("//span[text()='Next']")).click();
 // driver.close();
  
	}

}
