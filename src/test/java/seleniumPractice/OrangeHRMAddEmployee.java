package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMAddEmployee {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='PIM']")).click();
	Thread.sleep(3000);
	WebElement addButton= driver.findElement(By.xpath("//button[normalize-space()='Add']"));
	addButton.click();
	Thread.sleep(2000);
	driver.findElement(By.name("firstName")).sendKeys("John");
	driver.findElement(By.name("lastName")).sendKeys("Smith");
	driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	driver.findElement(By.xpath("//span[text()='PIM']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("John");
	
	driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
	Thread.sleep(2000);
	
	WebElement result=driver.findElement(By.xpath("//div[@role=\"rowgroup\"]/div/div/div[3]"));
	String resultString=result.getText();
	if(resultString.equals("John")) {	
		System.out.println("Employee found in the list");
	}
	else {
		System.out.println("Employee not found in the list");
	}
	
	driver.quit();
		
	}
}
