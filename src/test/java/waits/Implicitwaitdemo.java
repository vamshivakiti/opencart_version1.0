package waits;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicitwaitdemo {
	 WebDriver driver;
	 

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		
			//*[@id="shopify-section-sections--18925762281693__header"]/height-observer/store-header/div/div[2]/ul/li[2]/a/span
			
			 WebDriver driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		     driver.manage().window().maximize();
		     driver.get("https://www.loomandneedles.com/pages/order-tracker");
		     
		     String pagetitle=driver.getTitle();


		  WebElement loginIcon=   driver.findElement(By.xpath("//a[@class='hidden tap-area sm:block']"));
		  loginIcon.click();

		  WebElement continueBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		  System.out.println(continueBtn.isEnabled());
		 WebElement inptTest= driver.findElement(By.xpath("//input[@type='email']"));
		 inptTest.sendKeys("vakitivamshi@gmail.com");
		 System.out.println(continueBtn.isEnabled());
		  
		  continueBtn.click();
	}

}
