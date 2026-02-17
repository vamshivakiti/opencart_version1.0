package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		//WebElement pointMe=driver.findElement(By.xpath("//botton[@class='dropbtn']"));
		WebElement pointMe=driver.findElement(By.xpath("//div[@class='dropdown']"));
	WebElement mobile=	driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
	Actions act = new Actions(driver);
	act.moveToElement(pointMe).moveToElement(mobile).click().perform();
	
	
	}

}
