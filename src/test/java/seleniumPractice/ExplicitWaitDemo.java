package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		 WebDriverWait myWait= new WebDriverWait(driver, Duration.ofSeconds(10));
	     driver.manage().window().maximize();
	     driver.get("https://www.loomandneedles.com/pages/order-tracker");
	     
	     String pagetitle=driver.getTitle();


	 
	  WebElement loginIcon =   myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hidden tap-area sm:block']")));
	    
	  loginIcon.click();
	  WebElement continueBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	  System.out.println(continueBtn.isEnabled());
	 WebElement inptTest= driver.findElement(By.xpath("//input[@type='email']"));
	 inptTest.sendKeys("vakitivamshi@gmail.com");
	 System.out.println(continueBtn.isEnabled());
myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='button-content']"))).click();
	  //continueBtn.click();
	}

}
