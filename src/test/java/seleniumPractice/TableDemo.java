package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableDemo {
    WebDriver driver;
    @BeforeTest
     public void beforeTest(){
        driver= new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    }
    @Test
    public void TableDemo_test(){
     WebElement table =driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> row_table= table.findElements(By.tagName("tr"));
        System.out.println(row_table.size());
        for(int i=0; i<row_table.size();i++){
            List<WebElement> col=row_table.get(i).findElements(By.tagName("td"));
            for (WebElement c : col){
                System.out.print(c.getText()+" ");

            }
            System.out.println();
        }
    }
    @AfterTest
    public  void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
