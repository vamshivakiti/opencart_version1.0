package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyBoardActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q"));
       Actions ac = new Actions(driver);
       
       ac.keyDown(Keys.SHIFT)
       .sendKeys("amma")
      .perform();
      List<WebElement> allResults= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='G43f7e']//li//div[@role='option']")));
      for(WebElement results:allResults) {
    	System.out.println(results.getText());
    	if(results.getText().equalsIgnoreCase("Amma")) {
    		results.click();
    		break;
    	}
    	  }
	}}
	

