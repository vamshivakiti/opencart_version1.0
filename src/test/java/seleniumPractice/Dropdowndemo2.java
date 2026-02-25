package seleniumPractice;

//import java.lang.foreign.Linker.Option;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowndemo2 {

	public static void main(String[] args) {
   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
   driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
   WebElement countryDropdown = driver.findElement(By.tagName("select"));
   Select select  = new Select(countryDropdown);
    
   List<WebElement> optons = select.getOptions();
   System.out.println(optons.size());
   for(WebElement option : optons) {
	   System.out.println(option.getText());
	  
   }
   select.selectByVisibleText("India");
   driver.close();
	}

}
