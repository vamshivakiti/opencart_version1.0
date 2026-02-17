package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDrapdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement dd=driver.findElement(By.id("country"));
		Select ddOptions = new Select(dd);
		//ddOptions.selectByVisibleText("India");
		//ddOptions.selectByIndex(5);
		List<WebElement> alloptions =ddOptions.getOptions();
           for(WebElement allopt : alloptions) {
        	   System.out.println(allopt.getText());
           }
	}

}
