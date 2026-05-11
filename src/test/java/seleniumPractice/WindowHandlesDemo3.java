package seleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesDemo3 {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	String parentId=driver.getWindowHandle();
	driver.findElement(By.xpath("//button[@onClick='myFunction()']")).click();
	Set <String >Id=driver.getWindowHandles();
	for(String id:Id) {
		if(!id.equals(parentId)) {
			driver.switchTo().window(id);
			System.out.println(driver.getTitle());
			driver.close();
		}
	
	}
	driver.switchTo().window(parentId);	
	WebElement fileUpload=driver.findElement(By.xpath("//input[@type='file']"));
	fileUpload.sendKeys("C:\\Users\\LENOVO\\OneDrive\\Desktop\\FileUploadDemo.txt");
	   System.out.println("File uploaded successfully");
	}
}