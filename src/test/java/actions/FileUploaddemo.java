package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploaddemo {

	public static void main(String[] args) {
  WebDriver driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://awesomeqa.com/selenium/upload.html");
  WebElement uploadFile= driver.findElement(By.id("fileToUpload"));
	uploadFile.sendKeys("C:\\Git\\opencart_version1.0\\uploadMe.txt");
	driver.findElement(By.name("submit")).click();
	}

}
