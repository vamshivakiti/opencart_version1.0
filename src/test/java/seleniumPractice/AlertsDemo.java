package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://the-internet.herokuapp.com/javascript_alerts");
      //Normal ALert with OK button
      driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
      Thread.sleep(3000);
      
      Alert myalert= driver.switchTo().alert();
      System.out.println(myalert.getText());
      myalert.accept();
      
      //Confirmation alert with OK and Cancel.
      driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
      Thread.sleep(2000);
      driver.switchTo().alert().accept();
      driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
      Thread.sleep(2000);
      driver.switchTo().alert().dismiss();
      
      //Promt Alert
      driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
      Thread.sleep(2000);
      driver.switchTo().alert().sendKeys("Ok");
      Thread.sleep(2000);
      driver.switchTo().alert().accept();
      
	}

}
