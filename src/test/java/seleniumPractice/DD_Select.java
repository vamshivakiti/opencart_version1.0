package seleniumPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class DD_Select {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver= new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    }
    @Test
    public void SelectDD() throws InterruptedException {
   WebElement  DropDown =driver.findElement(By.id("country"));
        Select ddCount = new Select(DropDown);
        ddCount.selectByVisibleText("India");
        Thread.sleep(3000);
        ddCount.selectByIndex(4);
        Thread.sleep(2000);
        //ddCount.selectByValue("Japan");
        //Thread.sleep(2000);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\ss.png");
        sourceFile.renameTo(targetFile);
    }

    public  void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
