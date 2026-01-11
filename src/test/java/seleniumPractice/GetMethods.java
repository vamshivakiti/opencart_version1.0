 package seleniumPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException  {
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.loomandneedles.com/pages/order-tracker");
     String pagetitle=driver.getTitle();
   //button[@class='btn btn-primary']
  //  Object okButton = Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary']")));
//   wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']") ));                    
     //Thread.sleep(5000);
     System.out.println(pagetitle);
     System.out.println( driver.getCurrentUrl());
     String  Id=driver.getWindowHandle();
     System.out.println(Id);
     driver.findElement(By.linkText("Bluedart")).click();
     
     Set<String> WindowIds= driver.getWindowHandles();
     List<String> windowList = new ArrayList<String>(WindowIds);
     for(String list :windowList) {
    	 System.out.println(list);
     }
    // System.out.println(WindowIds);
     driver.switchTo().window(windowList.get(1));
     Thread.sleep(2000);
     WebElement continueBtn = driver.findElement(By.xpath("//button[@type='submit']"));
     System.out.println(continueBtn.isEnabled());
     driver.close();
     driver.switchTo().window(windowList.get(0));
     driver.close();
	}

}
