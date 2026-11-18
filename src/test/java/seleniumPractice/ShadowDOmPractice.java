package seleniumPractice;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOmPractice {

	public static void main(String[] args) throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://selectorshub.com/xpath-practice-page/");
	 driver.manage().window().maximize();
      String dir=System.getProperty("user.dir");
      System.out.println(dir);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 WebElement divScrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
	 js.executeScript("arguments[0].scrollIntoView(true);",divScrollTo);
	 
	 WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
	 inputboxPizza.sendKeys("Farmhouse");
	 Thread.sleep(13000);
	}

}
