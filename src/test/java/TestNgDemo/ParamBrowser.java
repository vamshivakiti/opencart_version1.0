package TestNgDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamBrowser {
	WebDriver driver;
   @BeforeClass
   @Parameters({"browser","url"})
	void setUp(String br, String url) throws InterruptedException {
		switch (br) {
		case "chrome": driver= new ChromeDriver();break;
		case "ff": driver= new FirefoxDriver();break;
		case "edge": driver = new EdgeDriver(); break;
		
		default:
			System.out.println("Enter the valid browser");
		return;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		 driver.get(url);
			Thread.sleep(3000);
		
	}
  
   
   @Test
   void Test() throws InterruptedException {
	  
	  boolean LogoStatus=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
	  if(LogoStatus==true) {
		  System.out.println("browser launches");
	  }
	  else {
		System.out.println("browser did not launched");
	}
	  
	  
	   
   }
	@AfterClass
	void TeatDown() {
		driver.close();
	}
}
