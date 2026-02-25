package seleniumPractice;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions1 {

	public static void main(String[] args) {
     WebDriver driver = new ChromeDriver();
     driver.get("https://www.google.com/");
     driver.findElement(By.name("q"));
     Actions act = new Actions(driver);
     act.keyDown(Keys.SHIFT)
     .sendKeys("c")
     .keyUp(Keys.SHIFT)
     .sendKeys("a")
     .sendKeys("t  ").perform();
     driver.close();
     

	}

}
