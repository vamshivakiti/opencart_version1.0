package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathRealtives {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("India");
	Thread.sleep(3000);
	
	
	}

}
