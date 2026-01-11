package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionsDemo {

	public static void main(String[] args) {
     WebDriver driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     driver.manage().window().maximize();
     driver.get("https://text-compare.com/");
     driver.findElement(By.xpath("//textarea[@name='text1']")).sendKeys("Hello World");
     Actions act = new Actions(driver);
     act.keyDown(Keys.CONTROL).sendKeys("a")
     .keyUp("a").sendKeys("c").keyUp(Keys.CONTROL)
     .keyDown(Keys.TAB)
     .keyDown(Keys.CONTROL).sendKeys("v").perform();
     
     
	}

}
