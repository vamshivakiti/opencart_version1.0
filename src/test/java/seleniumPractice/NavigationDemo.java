package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NavigationDemo {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 //WebDriverWait myWait= new WebDriverWait(driver, Duration.ofSeconds(10));
	     driver.manage().window().maximize();
	     driver.get("https://www.loomandneedles.com/");
	    WebElement cart= driver.findElement(By.xpath("/html[1]/body[1]/header[1]/height-observer[1]/store-header[1]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
	     cart.click();
	     String actualTitle = driver.getTitle();
	        String expectedTitle = "You Shopping Cart";

	        Assert.assertEquals(actualTitle, expectedTitle,
	                "Page title does not match!");
	     
	     driver.navigate().back();
	     driver.quit();
	     
	}

}
