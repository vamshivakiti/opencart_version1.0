package brokenLinksandShadowDom;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenlinksDemo {

	public static void main(String[] args) {
		int totalBrLinks=0;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--healdless=new");
		options.addArguments("--window-size=1920,1080");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> allLinks =driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(WebElement links:allLinks) {
			String url=links.getAttribute("href");
			if(url==null ||url.isEmpty()) {
				System.out.println("Url is empty");
				continue;
			}
			try {
				URL urllink = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) urllink.openConnection();
	            connection.connect();
	            int responseCode= connection.getResponseCode();
	            if (responseCode >=400) {
	            	System.out.println(urllink+" --> is broken link");
	            	totalBrLinks++;
	            }
	            else {
	            	System.out.println(urllink+" --> is working links");
	            }
			}
			catch(Exception e){
				System.out.println("Error occured");
			}
		}
		System.out.println("Total broken Links :"+ totalBrLinks);
	}

}
