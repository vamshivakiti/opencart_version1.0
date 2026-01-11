package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnabledDemo {

	public static void main(String[] args) throws InterruptedException {
		//*[@id="shopify-section-sections--18925762281693__header"]/height-observer/store-header/div/div[2]/ul/li[2]/a/span
		
		 WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("https://www.loomandneedles.com/pages/order-tracker");
	     String pagetitle=driver.getTitle();
	     Thread.sleep(5000);
	  WebElement loginIcon=   driver.findElement(By.xpath("//a[@class='hidden tap-area sm:block']"));
	  loginIcon.click();
	  Thread.sleep(3000);
	  WebElement continueBtn = driver.findElement(By.xpath("//span[@class='button-content']"));
	  System.out.println(continueBtn.isEnabled());
	 WebElement inptTest= driver.findElement(By.xpath("//input[@type='email']"));
	 inptTest.sendKeys("vakitivamshi@gmail.com");
	 System.out.println(continueBtn.isEnabled());
	  Thread.sleep(2000);
	  continueBtn.click();
	  
	
	}

}
