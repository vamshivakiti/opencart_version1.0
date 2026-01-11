package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
WebElement okbutton=driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-top ng-tns-c25-2 ng-star-inserted']"));

	}

}
