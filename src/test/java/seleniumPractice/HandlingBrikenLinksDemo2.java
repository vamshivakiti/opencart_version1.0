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

public class HandlingBrikenLinksDemo2 {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");


		//FInd the broken links in the website.
		List<WebElement> webLinks=  driver.findElements(By.tagName("a"));

		// Find the Href attribute of webLink
		for(WebElement linkNames: webLinks) {
			String HrefNames=  linkNames.getAttribute("Href");
			System.out.println(HrefNames);

			if (HrefNames== null || HrefNames.isEmpty()) {
				System.out.println("Links has no Href attributre");
				continue;
			}

			URL weburl = new URL(HrefNames);
			HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();

			conn.connect();

			if(conn.getResponseCode()>=400) {
				System.out.println("This is broken links "+HrefNames);
			}	
			else {
				System.out.println("This is not broken link "+ HrefNames);
			}
		}
		driver.close();

	}
	}
