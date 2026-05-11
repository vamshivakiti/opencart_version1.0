package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Simple Demo: OrangeHRM Login
 * This script demonstrates:
 * 1) Navigate to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
 * 2) Find username field and enter Admin
 * 3) Find password field and enter admin123
 * 4) Verify successful login
 */
public class OrangeHRMLoginDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			// Initialize WebDriver
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Step 1: Navigate to the OrangeHRM login page
			String loginURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
			driver.get(loginURL);
			System.out.println("Step 1: Navigated to " + loginURL);

			// Create WebDriverWait instance for explicit waits
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Step 2: Find username field and enter "Admin"
			WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
			usernameField.clear();
			usernameField.sendKeys("Admin");
			System.out.println("Step 2: Entered username: Admin");

			// Step 3: Find password field and enter "admin123"
			WebElement passwordField = driver.findElement(By.name("password"));
			passwordField.clear();
			passwordField.sendKeys("admin123");
			System.out.println("Step 3: Entered password: admin123");

			// Find and click the login button
			WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
			System.out.println("Step 3b: Found login button");
			loginButton.click();
			System.out.println("Step 3c: Clicked login button");

			// Wait for page to load
			Thread.sleep(3000);

			// Step 4: Verify successful login
			try {
				WebElement dashboardHeader = wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h6[contains(text(), 'Dashboard')]")))
				);
				System.out.println("\n========== LOGIN SUCCESSFUL ==========");
				System.out.println("Dashboard is now visible");
				System.out.println("Current URL: " + driver.getCurrentUrl());
				System.out.println("Page Title: " + driver.getTitle());
			} catch (Exception e) {
				System.out.println("\n========== LOGIN FAILED ==========");
				System.out.println("Dashboard not found. Checking for error message...");
				
				try {
					WebElement errorMsg = driver.findElement(By.xpath("//div[@role='alert']//div[@class='oxd-alert-content']"));
					System.out.println("Error Message: " + errorMsg.getText());
				} catch (Exception ex) {
					System.out.println("No error message found");
				}
				System.out.println("Current URL: " + driver.getCurrentUrl());
			}

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Close the browser
			if (driver != null) {
				driver.quit();
				System.out.println("\nBrowser closed");
			}
		}
	}
}
