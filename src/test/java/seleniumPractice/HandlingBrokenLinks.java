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

public class HandlingBrokenLinks {
 
	public static void main(String[] args) throws IOException {
		 int brokenLinks=0;
WebDriver driver = new ChromeDriver();
driver.get("http://www.deadlinkcity.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

// capture all links on the page
List<WebElement> links = driver.findElements(By.tagName("a"));
System.out.println("Total Number of Links is :"+links.size());

for(WebElement linksNames:links) {
	//System.out.println(linksNames.getText());
	String hrefAtLinks = linksNames.getAttribute("href");
	
	if(hrefAtLinks== null || hrefAtLinks.isEmpty()) {
		System.out.println("Links cannot be verified that it does not have Href value");
		continue;
	}
	
	//Hit url to the server.

	URL linkUrl = new URL(hrefAtLinks);
	   HttpURLConnection conn=(HttpURLConnection) linkUrl.openConnection();
	   conn.connect();
	   if(conn.getResponseCode()>=400)
	   {
		   System.out.println(hrefAtLinks+ "---> is a broken links");
		   brokenLinks++;
	   }
	   else {
		System.out.println(hrefAtLinks+"---> is not a broken links");
	}
	   
    }
System.out.println("Total Number of Broken Links :"+brokenLinks);
	}

}
