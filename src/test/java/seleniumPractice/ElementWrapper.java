package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementWrapper {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public ElementWrapper(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			}
	public void clickWithRetry(WebElement element) {
		int attempt =0;
		int Max_attemp=3;
		while(attempt<Max_attemp) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
			element.click();
			System.out.println("clicket the element at Attempt:"+ (attempt+1));
			return;
		}
		catch(StaleElementReferenceException e) {
			attempt++;
			System.out.println("Retrying attempt"+attempt);
		
		if(attempt==Max_attemp) {
			throw new RuntimeException("element remained stale after "+Max_attemp+"attemts",e);
		}
		
		}catch(Exception e) {
			throw new RuntimeException("Unable to click",e);
		}
}
}
	}