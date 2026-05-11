package brokenLinksandShadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomDemo2 {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://selectorshub.com/xpath-practice-page/");
	SearchContext shadow0= driver.findElement(By.cssSelector("#userName")).getShadowRoot();
	SearchContext shadow1=shadow0.findElement(By.cssSelector("#app2")).getShadowRoot();
	shadow1.findElement(By.cssSelector("#pizza")).sendKeys("farm house");
	}

}
