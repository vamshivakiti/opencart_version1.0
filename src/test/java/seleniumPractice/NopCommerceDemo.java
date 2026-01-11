package seleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NopCommerceDemo {

	public static void main(String[] args) {
   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   driver.get("https://demo.nopcommerce.com/");
   
   // Register link
  WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
  Actions act= new Actions(driver);
    act.keyDown(Keys.CONTROL).click(registerLink).keyUp(Keys.CONTROL).perform();
     Set<String>windowIds=  driver.getWindowHandles();
      List<String> idList  = new ArrayList<String>(windowIds);
      String parentId=idList.get(0);
      String childId=idList.get(1);
      driver.switchTo().window(childId);
      System.out.println(driver.getTitle());
      driver.findElement(By.name("FirstName")).sendKeys("Vamshi Krishna");
      driver.switchTo().window(parentId);
      
     
    
	}

}
