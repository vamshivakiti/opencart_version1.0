package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.net.Urls;

public class BrokenLinks {
        
	public static void main(String[] args) throws IOException {
		int brokenKinks = 0;
		int notBrokenLinks=0;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		List <WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (WebElement allLink: allLinks) {
			String herfNames=allLink.getAttribute("Href");
			System.out.println(herfNames);
			if (herfNames== null || herfNames.isEmpty()) {
				System.out.println(herfNames+" does not has value to validate");
				continue;
			}
			URL url = new URL(herfNames);
			HttpURLConnection urlConn=(HttpURLConnection) url.openConnection();
			urlConn.connect();
			if(urlConn.getResponseCode()>=400) {
				System.out.println(herfNames+ "is a broken Link");
				brokenKinks++;
			}
			else {
				System.out.println(herfNames+" is not a broken links");
				notBrokenLinks++;
			}
			
			
		}
		System.out.println("Total Broken links ="+ brokenKinks);
		System.out.println("Totla not broken Links= "+notBrokenLinks);
		driver.close();  

	}

}
