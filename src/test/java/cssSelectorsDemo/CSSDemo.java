package cssSelectorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * CSS- Cascading Style sheets.
 * tag id
 * tag class
 * tag attribute
 * ex 1: tag#id.
 * ex 2:tag.classname
 * ex 3 tag[attribute='value']
 * ex 4: tag.classname[attribute="value"] */
public class CSSDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.cssSelector("input[id='small-searchterms']")).sendKeys("Laptops");
       //driver.findElement(By.xpath("//button[normalize-space()=\"Search\"]")).click();
       //tag class attribue
       driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Tshirsts");
	}

}
