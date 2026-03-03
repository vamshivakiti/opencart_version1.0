package seleniumPractice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EbayAutomation {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        option.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }
    @Test
    @Description("Ebay shopping page")
    public void test() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("Mac mini");
        driver.findElement(By.xpath("//span[@class='gh-search-button__label']")).click();
        Thread.sleep(2000);
        java.util.List<WebElement> allMacMinics =driver.findElements(By.xpath("//span[@class='su-styled-text primary default']"));
        java.util.List<WebElement> all_prices = driver.findElements(By.xpath("//span[@class='su-styled-text primary bold large-1 s-card__price']"));
        System.out.println("Total search results: "+allMacMinics.size());
//        for(WebElement alltitles: allMacMinics){
//            System.out.println(alltitles.getText());
//
//        }
//        for (WebElement Prices:all_prices ){
//            System.out.println( Prices.getText());
//        }
        int size=Math.min(allMacMinics.size(),all_prices.size());
        for(int i=0; i<size;i++){
            System.out.println("Item :"+allMacMinics.get(i).getText());
            System.out.println("Price :"+ all_prices.get(i).getText());
        }

    }
    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
