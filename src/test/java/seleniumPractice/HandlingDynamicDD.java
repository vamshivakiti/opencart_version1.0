package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicDD {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.switchTo().alert().accept();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		//Click on drop down
		
		driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[6]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
	    // Selecting single option
		//driver.findElement(By.xpath("//span[normalize-space()='Financial Analyst']")).click();
	    //Fetch all options
	List<WebElement>allOptions=	driver.findElements(By.xpath("//div[@role='listbox']//span"));
	   System.out.println(allOptions.size());
	   for(WebElement options:allOptions) {
		   System.out.println(options.getText());
	   }
	
	}

}
