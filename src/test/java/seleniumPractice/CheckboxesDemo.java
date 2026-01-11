package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxesDemo {

	public static void main(String[] args) {
   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   driver.get("https://testautomationpractice.blogspot.com/");
   //Select all the check boxes
   System.out.println(driver.getTitle());
   
   List<WebElement> checkboxes= driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));  
   for(WebElement checkbox:checkboxes) {
	   checkbox.click();
   }
  // driver.close();
   
	}

}
