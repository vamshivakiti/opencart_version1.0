package seleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("PopUp")).click();
		Set <String> windowId=driver.getWindowHandles();
		List<String> winId = new ArrayList<String>(windowId);
		driver.switchTo().window(winId.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(winId.get(0));
		System.out.println(driver.getTitle());
		driver.close();
		

	}

}
