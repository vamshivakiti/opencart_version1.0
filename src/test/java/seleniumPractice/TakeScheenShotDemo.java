package seleniumPractice;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScheenShotDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		TakesScreenshot ts = (TakesScreenshot)driver;
		     File SourceFle=ts.getScreenshotAs(OutputType.FILE);
          File targerFile = new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\demo.png");
          SourceFle.renameTo(targerFile);
          driver.close();
	}

}
