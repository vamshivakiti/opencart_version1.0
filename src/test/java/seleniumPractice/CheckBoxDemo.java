package seleniumPractice;

import java.lang.foreign.Linker.Option;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions chromeptions = new ChromeOptions();
		chromeptions.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(chromeptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Step 1: Navigate to the test automation practice website
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("Navigated to: https://testautomationpractice.blogspot.com/");
		
		// Step 2: Find all checkboxes
		List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		System.out.println("Total checkboxes found: " + allCheckboxes.size());
		
		// Step 3: Find and verify weekday checkboxes (Monday to Friday - first 5 checkboxes)
		String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		
		System.out.println("\n--- Verifying Weekday Checkboxes ---");
		for(int i = 0; i < 5 && i < allCheckboxes.size(); i++) {
			WebElement checkbox = allCheckboxes.get(i);
			boolean isDisplayed = checkbox.isDisplayed();
			System.out.println(weekdays[i] + " checkbox is displayed: " + isDisplayed);
		}
		
		// Step 4: Check weekday checkboxes individually and verify
		System.out.println("\n--- Checking Weekday Checkboxes Individually ---");
		for(int i = 0; i < 5 && i < allCheckboxes.size(); i++) {
			WebElement checkbox = allCheckboxes.get(i);
			if(!checkbox.isSelected()) {
				checkbox.click();
				System.out.println(weekdays[i] + " - Checked: " + checkbox.isSelected());
			}
		}
		
		// Step 5: Uncheck all weekday checkboxes
		System.out.println("\n--- Unchecking Weekday Checkboxes ---");
		for(int i = 0; i < 5 && i < allCheckboxes.size(); i++) {
			WebElement checkbox = allCheckboxes.get(i);
			if(checkbox.isSelected()) {
				checkbox.click();
				System.out.println(weekdays[i] + " - Unchecked: " + !checkbox.isSelected());
			}
		}
		
		// Step 6: Check all weekday checkboxes at once
		System.out.println("\n--- Checking All Weekday Checkboxes at Once ---");
		for(int i = 0; i < 5 && i < allCheckboxes.size(); i++) {
			allCheckboxes.get(i).click();
		}
		System.out.println("All weekday checkboxes checked!");
		
		// Step 7: Verify all weekday checkboxes are checked
		System.out.println("\n--- Final Verification ---");
		boolean allWeekdaysChecked = true;
		for(int i = 0; i < 5 && i < allCheckboxes.size(); i++) {
			boolean isSelected = allCheckboxes.get(i).isSelected();
			System.out.println(weekdays[i] + " is checked: " + isSelected);
			if(!isSelected) {
				allWeekdaysChecked = false;
			}
		}
		System.out.println("\nAll weekday checkboxes successfully checked: " + allWeekdaysChecked);
		
		driver.quit();
	}

}
