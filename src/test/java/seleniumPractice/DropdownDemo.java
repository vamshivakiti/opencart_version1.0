package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement dropDown= driver.findElement(By.xpath("//select[@id='country']"));
		Select dropDownCountry = new Select(dropDown);
		// Select options from Drop down:
	/*	 dropDownCountry.selectByVisibleText("India");
		dropDownCountry.selectByValue("uk");
		dropDownCountry.selectByIndex(1);
		driver.close(); */
		
		
		// count the values in the dropdown
		List<WebElement> dd_Options= dropDownCountry.getOptions();
		for(  WebElement all_Options : dd_Options) {
			System.out.println(all_Options.getText());
			
			
		}
		driver.close();
	}

}
