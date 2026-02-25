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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Links {

	public static void main(String[] args) throws IOException {
		int brokenLinks = 0;
		int workingLink=0;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		List<WebElement>allLinks= driver.findElements(By.tagName("a"));
		for(WebElement links:allLinks) {
			String HrefText=links.getAttribute("Href");
			if(HrefText==null || HrefText.isEmpty()) {
				System.out.println("Empty Link ");
				continue;
			}
			URL weburl = new URL(HrefText);
			HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
			conn.connect();
			if(conn.getResponseCode()>=400) {
				System.out.println(HrefText+ "This is broken link");
				brokenLinks++;
			}
			else {
				System.out.println(HrefText+"--> Working Link");
				workingLink++;
			}


		}

		System.out.println(brokenLinks+" Total broken links");
		System.out.println(workingLink+" Total working links");	

		driver.close();

	}

}
