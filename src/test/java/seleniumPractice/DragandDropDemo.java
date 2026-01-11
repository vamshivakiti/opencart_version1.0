package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropDemo {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

  WebElement sorceImg=  driver.findElement(By.xpath("//img[@src='images/high_tatras_min.jpg']"));
	WebElement Targer=driver.findElement(By.id("trash"));
	
	Actions act = new Actions(driver);
	act.dragAndDrop(sorceImg, Targer).perform();
	
	
	}

}
