package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object Model for OrangeHRM Login Page
 */
public class OrangeHRMLoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By errorMessage = By.xpath("//div[@role='alert']//div[@class='oxd-alert-content']");
	private By dashboardHeader = By.xpath("//h6[contains(text(), 'Dashboard')]");
	private By userGreeting = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By forgotPasswordLink = By.xpath("//a[contains(text(), 'Forgot your password?')]");

	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * Enter username in the username field
	 */
	public void enterUsername(String username) {
		WebElement usernameElem = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
		usernameElem.clear();
		usernameElem.sendKeys(username);
		System.out.println("Entered username: " + username);
	}

	/**
	 * Enter password in the password field
	 */
	public void enterPassword(String password) {
		WebElement passwordElem = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
		passwordElem.clear();
		passwordElem.sendKeys(password);
		System.out.println("Entered password");
	}

	/**
	 * Click on the login button
	 */
	public void clickLoginButton() {
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginBtn.click();
		System.out.println("Clicked Login button");
	}

	/**
	 * Perform login with username and password
	 */
	public void performLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	/**
	 * Verify successful login - check if dashboard header is visible
	 */
	public boolean isLoginSuccessful() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(dashboardHeader)));
			System.out.println("Login successful - Dashboard header is visible");
			return true;
		} catch (Exception e) {
			System.out.println("Login failed - Dashboard header not found");
			return false;
		}
	}

	/**
	 * Get the error message displayed on login failure
	 */
	public String getErrorMessage() {
		try {
			WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessage)));
			String message = errorMsg.getText();
			System.out.println("Error message: " + message);
			return message;
		} catch (Exception e) {
			System.out.println("No error message found");
			return "";
		}
	}

	/**
	 * Check if error message is displayed
	 */
	public boolean isErrorMessageDisplayed() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessage)));
			System.out.println("Error message is displayed");
			return true;
		} catch (Exception e) {
			System.out.println("Error message is not displayed");
			return false;
		}
	}

	/**
	 * Check if username field is visible
	 */
	public boolean isUsernameFieldVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(usernameField)));
			System.out.println("Username field is visible");
			return true;
		} catch (Exception e) {
			System.out.println("Username field is not visible");
			return false;
		}
	}

	/**
	 * Check if password field is visible
	 */
	public boolean isPasswordFieldVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordField)));
			System.out.println("Password field is visible");
			return true;
		} catch (Exception e) {
			System.out.println("Password field is not visible");
			return false;
		}
	}

	/**
	 * Check if login button is visible
	 */
	public boolean isLoginButtonVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
			System.out.println("Login button is visible");
			return true;
		} catch (Exception e) {
			System.out.println("Login button is not visible");
			return false;
		}
	}

	/**
	 * Check if "Forgot your password?" link is visible
	 */
	public boolean isForgotPasswordLinkVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(forgotPasswordLink)));
			System.out.println("'Forgot your password?' link is visible");
			return true;
		} catch (Exception e) {
			System.out.println("'Forgot your password?' link is not visible");
			return false;
		}
	}

	/**
	 * Get current page URL
	 */
	public String getCurrentURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Current URL: " + url);
		return url;
	}

	/**
	 * Get page title
	 */
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		return title;
	}
}
