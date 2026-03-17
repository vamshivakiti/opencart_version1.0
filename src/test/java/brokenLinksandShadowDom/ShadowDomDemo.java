package brokenLinksandShadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomDemo {
// Xpath cannot interact directly with shadow dom elements.
// Main document ----> Shadow Host---> Shadow root---> element
//	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");
//		String cssSelectorForHost1 = "#shadow-root";
//		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#shadow-element"));
		
		// Nested shadow dom element
//		
		//This Element is inside 2 nested shadow DOM.
		
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		shadow1.findElement(By.cssSelector("#nested-shadow-element"));
	}

}
