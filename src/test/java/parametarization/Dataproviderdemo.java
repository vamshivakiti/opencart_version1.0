package parametarization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderdemo {
	WebDriver driver;
	@BeforeClass

   void setUp() {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  	  
   }
	@Test(dataProvider = "dp")
	void testLogin(String email, String password) {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "OrangeHRM");
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
	}
	@AfterClass


	void tearDown() {
		driver.close();
	}
	@DataProvider(name="dp",indices = 3)//Takes only 4th input
	Object[][] LoginData() {
		String data[][]= {
				
				{"Vamshi@gmail","test@123"},
				{"John@gmail.com","demo123"},
				{"Krishna@gmail.com","demo123"},
				{"Admin","admin123"},
			
		};
		return data;
	}
}
