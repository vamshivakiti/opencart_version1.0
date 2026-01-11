package seleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement link =driver.findElement(By.linkText("OrangeHRM, Inc"));
        link.click();
        Set<String> windowsId=driver.getWindowHandles();
        List<String>windowsList = new ArrayList<String>(windowsId);
      //  System.out.println(windowsId);
      driver.switchTo().window(windowsList.get(1));
        driver.close();
        driver.switchTo().window(windowsList.get(0));
        System.out.println(driver.getTitle());
        driver.close();
        
        
        for(String windId:windowsId) {
        	
        	String pageTitle=driver.switchTo().window(windId).getTitle();
        	
        	if(pageTitle.equals("OrangeHRM")) {
        		
        	}
        }

	}

}
