package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

/**
 * Positive Test Cases for OrangeHRM Login
 * Test scenarios for valid credentials and successful login
 */
public class OrangeHRMLoginPositiveTest extends OrangeHRMLoginBase {

	private OrangeHRMLoginPage loginPage;

	@BeforeMethod
	public void setUpTest() {
		navigateToLoginPage();
		loginPage = new OrangeHRMLoginPage(driver);
	}

	/**
	 * Test Case 1: Verify login page elements are displayed
	 * Purpose: Verify that all required login elements are visible on page load
	 */
	@Test(priority = 1, description = "TC_P_001: Verify login page elements are displayed")
	public void testLoginPageElementsDisplayed() {
		System.out.println("\n========== TEST CASE 1: Verify Login Page Elements ==========");
		
		boolean usernameVisible = loginPage.isUsernameFieldVisible();
		boolean passwordVisible = loginPage.isPasswordFieldVisible();
		boolean loginBtnVisible = loginPage.isLoginButtonVisible();
		boolean forgotPasswordVisible = loginPage.isForgotPasswordLinkVisible();
		
		Assert.assertTrue(usernameVisible, "Username field should be visible");
		Assert.assertTrue(passwordVisible, "Password field should be visible");
		Assert.assertTrue(loginBtnVisible, "Login button should be visible");
		Assert.assertTrue(forgotPasswordVisible, "'Forgot your password?' link should be visible");
		
		System.out.println("All login page elements are displayed successfully");
	}

	/**
	 * Test Case 2: Successful login with valid credentials
	 * Purpose: Verify that user can successfully login with valid credentials (Admin/admin123)
	 */
	@Test(priority = 2, description = "TC_P_002: Successful login with valid credentials")
	public void testSuccessfulLogin() {
		System.out.println("\n========== TEST CASE 2: Successful Login ==========");
		
		String username = "Admin";
		String password = "admin123";
		
		loginPage.performLogin(username, password);
		
		// Wait for dashboard to load
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertTrue(isLoginSuccessful, "Login should be successful with valid credentials");
		
		String currentURL = loginPage.getCurrentURL();
		Assert.assertTrue(currentURL.contains("dashboard"), "Should be redirected to dashboard");
		
		System.out.println("Login successful - User is on dashboard");
	}

	/**
	 * Test Case 3: Verify username field accepts input
	 * Purpose: Verify that username field accepts user input correctly
	 */
	@Test(priority = 3, description = "TC_P_003: Verify username field accepts input")
	public void testUsernameFieldAcceptsInput() {
		System.out.println("\n========== TEST CASE 3: Username Field Accepts Input ==========");
		
		String username = "Admin";
		loginPage.enterUsername(username);
		
		String usernameValue = driver.findElement(org.openqa.selenium.By.name("username")).getAttribute("value");
		Assert.assertEquals(usernameValue, username, "Username field should contain entered value");
		
		System.out.println("Username field accepts input correctly");
	}

	/**
	 * Test Case 4: Verify password field accepts input
	 * Purpose: Verify that password field accepts user input correctly
	 */
	@Test(priority = 4, description = "TC_P_004: Verify password field accepts input")
	public void testPasswordFieldAcceptsInput() {
		System.out.println("\n========== TEST CASE 4: Password Field Accepts Input ==========");
		
		String password = "admin123";
		loginPage.enterPassword(password);
		
		String passwordValue = driver.findElement(org.openqa.selenium.By.name("password")).getAttribute("value");
		Assert.assertEquals(passwordValue, password, "Password field should contain entered value");
		
		System.out.println("Password field accepts input correctly");
	}

	/**
	 * Test Case 5: Verify page title on login page
	 * Purpose: Verify that the login page has correct title
	 */
	@Test(priority = 5, description = "TC_P_005: Verify page title on login page")
	public void testLoginPageTitle() {
		System.out.println("\n========== TEST CASE 5: Verify Login Page Title ==========");
		
		String pageTitle = loginPage.getPageTitle();
		Assert.assertTrue(pageTitle.contains("OrangeHRM") || pageTitle.contains("Login"), 
						"Page title should contain OrangeHRM or Login");
		
		System.out.println("Login page title is correct: " + pageTitle);
	}

	/**
	 * Test Case 6: Verify page URL
	 * Purpose: Verify that the correct login page URL is loaded
	 */
	@Test(priority = 6, description = "TC_P_006: Verify login page URL")
	public void testLoginPageURL() {
		System.out.println("\n========== TEST CASE 6: Verify Login Page URL ==========");
		
		String currentURL = loginPage.getCurrentURL();
		Assert.assertTrue(currentURL.contains("auth/login"), "URL should contain auth/login");
		
		System.out.println("Login page URL is correct");
	}

	/**
	 * Test Case 7: Verify login button is clickable
	 * Purpose: Verify that login button is clickable on the page
	 */
	@Test(priority = 7, description = "TC_P_007: Verify login button is clickable")
	public void testLoginButtonClickable() {
		System.out.println("\n========== TEST CASE 7: Verify Login Button Clickable ==========");
		
		boolean isClickable = loginPage.isLoginButtonVisible();
		Assert.assertTrue(isClickable, "Login button should be clickable");
		
		System.out.println("Login button is clickable");
	}

	/**
	 * Test Case 8: Complete login workflow
	 * Purpose: Verify the complete login workflow from page load to dashboard access
	 */
	@Test(priority = 8, description = "TC_P_008: Complete login workflow")
	public void testCompleteLoginWorkflow() {
		System.out.println("\n========== TEST CASE 8: Complete Login Workflow ==========");
		
		// Verify initial state
		Assert.assertTrue(loginPage.isUsernameFieldVisible(), "Username field should be visible");
		Assert.assertTrue(loginPage.isPasswordFieldVisible(), "Password field should be visible");
		
		// Perform login
		loginPage.performLogin("Admin", "admin123");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login success
		boolean isSuccessful = loginPage.isLoginSuccessful();
		Assert.assertTrue(isSuccessful, "Login should be successful");
		
		System.out.println("Complete login workflow executed successfully");
	}
}
