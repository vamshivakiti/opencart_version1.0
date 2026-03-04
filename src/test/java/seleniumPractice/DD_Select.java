package seleniumPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class DD_Select {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        option.addArguments("--window-size=1920,1080");
        driver= new ChromeDriver(option);
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
      List<WebElement> options=  ddCount.getOptions();
        System.out.println(options.size());
    /*    for (int i=0;i<options.size();i++ ){
            System.out.println(options.get(i).getText());
        */
        for(WebElement op:options){
            System.out.println(op.getText());
        }
        //ddCount.selectByValue("Japan");
        //Thread.sleep(2000);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\ss.png");
        sourceFile.renameTo(targetFile);
    }
@AfterTest
    public  void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
