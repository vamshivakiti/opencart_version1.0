package seleniumPractice;

import java.lang.foreign.Linker.Option;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions chromeptions = new ChromeOptions();
		chromeptions.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(chromeptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> options=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		for(WebElement option:options)
		{ option.click(); }
		 
		// To select all check boxes
		
		 for (int i=0; i<options.size();i++) { options.get(i).click(); }
		 
		
		// To select last 3 checkboxes
		for(int k =4; k<options.size();k ++) {
			options.get(k).click();
		}
		
		for(int k =4; k<options.size();k ++) {
			options.get(k).click();
		}
		driver.quit();
	}

}
