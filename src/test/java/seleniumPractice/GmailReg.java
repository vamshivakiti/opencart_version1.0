package seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailReg {

	public static void main(String[] args) throws InterruptedException, IOException {
	int	brokenLinks =0;
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.gmail.com");
   List<WebElement> allLinks= driver.findElements(By.tagName("a"));
   for(WebElement link: allLinks) {
	   String hrefref= link.getAttribute("Href");
	   System.out.println(link);
	   if(hrefref==null || hrefref.isEmpty()) {
		   System.out.println("This is not a valitLink"+hrefref);
	   continue;
   }
   URL webURL = new URL(hrefref);
   HttpURLConnection conn=(HttpURLConnection) webURL.openConnection();
   conn.connect();
   if(conn.getResponseCode()>=400)
   {
	   System.out.println("This is a broken link :"+webURL );
	   brokenLinks++;
   }
   System.out.println("Total broken liinks are :"+brokenLinks);
   }
    driver.findElement(By.xpath("//button[normalize-space()='Forgot email?']")).click();
    Thread.sleep(3000);
    //Taking Screen Shot of gmail full page
    TakesScreenshot tc = (TakesScreenshot) driver;
    File sourceFile=tc.getScreenshotAs(OutputType.FILE);
    File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\gmail.png");
    sourceFile.renameTo(targetFile);
       WebElement gmailLogo=driver.findElement(By.xpath("//div[@class='FDhDJc']"));
    // Taking Screenshot of gmailLogo
       File logoSource=gmailLogo.getScreenshotAs(OutputType.FILE);
       File logoTar=new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\\\gmailLogo.png");
       logoSource.renameTo(logoTar);
       driver.close();
    
	}

}
