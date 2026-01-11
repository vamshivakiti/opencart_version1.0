package dataDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtils;

public class DataDrivenDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		System.out.println(driver.getTitle());
		//driver.switchTo().alert().accept();

		String filePath=   System.getProperty("user.dir")+"\\TestData\\TestData1.xlsx";
		int row= ExcelUtils.getRowCount(filePath, "SimpleIntrest");
		for(int r=1;r<row;r++) {
			//read data from excel
			String pricepleAmount=ExcelUtils.getCellData(filePath, "SimpleIntrest", r, 0);
			String rateOfIntres=ExcelUtils.getCellData(filePath, "SimpleIntrest", r, 1);
			String period1=ExcelUtils.getCellData(filePath, "SimpleIntrest", r, 2);
			String period2=ExcelUtils.getCellData(filePath, "SimpleIntrest", r, 3);
			String freq=ExcelUtils.getCellData(filePath, "SimpleIntrest", r, 4);
			String expectedMaturity=ExcelUtils.getCellData(filePath, "SimpleIntrest", r, 5);

			driver.findElement(By.name("principal")).sendKeys(pricepleAmount);       	   
			driver.findElement(By.name("interest")).sendKeys(rateOfIntres);
			driver.findElement(By.name("tenure")).sendKeys(period1);


			Select perdrp = new Select	(driver.findElement(By.name("tenurePeriod")));
		   perdrp.selectByVisibleText(period2);
             
		    Select fredrp= new Select (driver.findElement(By.name("frequency")));
		     fredrp.selectByVisibleText(freq)  ;
		     
		     driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			 
			/*
			 * WebElement month
			 * =driver.findElement(By.xpath("//select[@id='frequency']//option[1]"));
			 * month.click();
			 */


		}


		//driver.close();
	}

}
