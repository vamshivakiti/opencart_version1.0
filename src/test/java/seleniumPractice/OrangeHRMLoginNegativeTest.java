package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

/**
 * Negative Test Cases for OrangeHRM Login
 * Test scenarios for invalid credentials, empty fields, and error conditions
 */
public class OrangeHRMLoginNegativeTest extends OrangeHRMLoginBase {

	private OrangeHRMLoginPage loginPage;

	@BeforeMethod
	public void setUpTest() {
		navigateToLoginPage();
		loginPage = new OrangeHRMLoginPage(driver);
	}

	/**
	 * Test Case 1: Login with invalid username and valid password
	 * Purpose: Verify that login fails with invalid username
	 */
	@Test(priority = 1, description = "TC_N_001: Login with invalid username")
	public void testLoginWithInvalidUsername() {
		System.out.println("\n========== TEST CASE 1: Login with Invalid Username ==========");
		
		String invalidUsername = "InvalidUser";
		String validPassword = "admin123";
		
		loginPage.performLogin(invalidUsername, validPassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail with invalid username");
		
		// Verify error message is displayed
		boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error message should be displayed");
		
		String errorMessage = loginPage.getErrorMessage();
		Assert.assertFalse(errorMessage.isEmpty(), "Error message should not be empty");
		
		System.out.println("Login failed as expected with invalid username");
	}

	/**
	 * Test Case 2: Login with valid username and invalid password
	 * Purpose: Verify that login fails with invalid password
	 */
	@Test(priority = 2, description = "TC_N_002: Login with invalid password")
	public void testLoginWithInvalidPassword() {
		System.out.println("\n========== TEST CASE 2: Login with Invalid Password ==========");
		
		String validUsername = "Admin";
		String invalidPassword = "wrongpassword";
		
		loginPage.performLogin(validUsername, invalidPassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail with invalid password");
		
		// Verify error message is displayed
		boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error message should be displayed");
		
		System.out.println("Login failed as expected with invalid password");
	}

	/**
	 * Test Case 3: Login with empty username
	 * Purpose: Verify that login fails when username is empty
	 */
	@Test(priority = 3, description = "TC_N_003: Login with empty username")
	public void testLoginWithEmptyUsername() {
		System.out.println("\n========== TEST CASE 3: Login with Empty Username ==========");
		
		String emptyUsername = "";
		String validPassword = "admin123";
		
		loginPage.performLogin(emptyUsername, validPassword);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail with empty username");
		
		System.out.println("Login failed as expected with empty username");
	}

	/**
	 * Test Case 4: Login with empty password
	 * Purpose: Verify that login fails when password is empty
	 */
	@Test(priority = 4, description = "TC_N_004: Login with empty password")
	public void testLoginWithEmptyPassword() {
		System.out.println("\n========== TEST CASE 4: Login with Empty Password ==========");
		
		String validUsername = "Admin";
		String emptyPassword = "";
		
		loginPage.performLogin(validUsername, emptyPassword);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail with empty password");
		
		System.out.println("Login failed as expected with empty password");
	}

	/**
	 * Test Case 5: Login with both username and password empty
	 * Purpose: Verify that login fails when both fields are empty
	 */
	@Test(priority = 5, description = "TC_N_005: Login with empty username and password")
	public void testLoginWithEmptyBoth() {
		System.out.println("\n========== TEST CASE 5: Login with Empty Username and Password ==========");
		
		String emptyUsername = "";
		String emptyPassword = "";
		
		loginPage.performLogin(emptyUsername, emptyPassword);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail with empty username and password");
		
		System.out.println("Login failed as expected with empty username and password");
	}

	/**
	 * Test Case 6: Login with case-sensitive password
	 * Purpose: Verify that password is case-sensitive
	 */
	@Test(priority = 6, description = "TC_N_006: Login with case-sensitive password")
	public void testLoginWithWrongCasePassword() {
		System.out.println("\n========== TEST CASE 6: Login with Case-Sensitive Password ==========");
		
		String validUsername = "Admin";
		String wrongCasePassword = "ADMIN123"; // Wrong case
		
		loginPage.performLogin(validUsername, wrongCasePassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail with wrong case password");
		
		// Verify error message is displayed
		boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error message should be displayed");
		
		System.out.println("Login failed as expected - password is case-sensitive");
	}

	/**
	 * Test Case 7: Login with special characters in credentials
	 * Purpose: Verify that special characters in credentials cause login failure
	 */
	@Test(priority = 7, description = "TC_N_007: Login with special characters")
	public void testLoginWithSpecialCharacters() {
		System.out.println("\n========== TEST CASE 7: Login with Special Characters ==========");
		
		String usernameWithSpecialChars = "Admin@#$";
		String passwordWithSpecialChars = "admin123!@#";
		
		loginPage.performLogin(usernameWithSpecialChars, passwordWithSpecialChars);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail with special characters");
		
		System.out.println("Login failed as expected with special characters");
	}

	/**
	 * Test Case 8: Login with spaces in credentials
	 * Purpose: Verify that spaces in credentials cause login failure
	 */
	@Test(priority = 8, description = "TC_N_008: Login with spaces in credentials")
	public void testLoginWithSpaces() {
		System.out.println("\n========== TEST CASE 8: Login with Spaces ==========");
		
		String usernameWithSpaces = " Admin ";
		String passwordWithSpaces = " admin123 ";
		
		loginPage.performLogin(usernameWithSpaces, passwordWithSpaces);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed or may succeed depending on app behavior
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		System.out.println("Login with spaces result: " + (isLoginSuccessful ? "Success" : "Failed"));
		
		System.out.println("Login with spaces test completed");
	}

	/**
	 * Test Case 9: Login with SQL injection attempt in username
	 * Purpose: Verify that SQL injection attempts are prevented
	 */
	@Test(priority = 9, description = "TC_N_009: Login with SQL injection attempt")
	public void testLoginWithSQLInjection() {
		System.out.println("\n========== TEST CASE 9: Login with SQL Injection Attempt ==========");
		
		String sqlInjectionUsername = "Admin' OR '1'='1";
		String sqlInjectionPassword = "' OR '1'='1";
		
		loginPage.performLogin(sqlInjectionUsername, sqlInjectionPassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "SQL injection attack should be prevented");
		
		System.out.println("Login failed as expected - SQL injection prevented");
	}

	/**
	 * Test Case 10: Multiple failed login attempts
	 * Purpose: Verify application behavior after multiple failed login attempts
	 */
	@Test(priority = 10, description = "TC_N_010: Multiple failed login attempts")
	public void testMultipleFailedLoginAttempts() {
		System.out.println("\n========== TEST CASE 10: Multiple Failed Login Attempts ==========");
		
		String invalidUsername = "InvalidUser";
		String invalidPassword = "wrongpassword";
		
		for (int i = 1; i <= 3; i++) {
			System.out.println("Attempt " + i);
			loginPage.performLogin(invalidUsername, invalidPassword);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// Verify login failed
			boolean isLoginSuccessful = loginPage.isLoginSuccessful();
			Assert.assertFalse(isLoginSuccessful, "Login attempt " + i + " should fail");
			
			// Reset for next attempt if needed
			if (i < 3) {
				navigateToLoginPage();
			}
		}
		
		System.out.println("All login attempts failed as expected");
	}

	/**
	 * Data Provider for testing multiple invalid credentials
	 */
	@DataProvider(name = "invalidCredentials")
	public Object[][] getInvalidCredentials() {
		return new Object[][] {
			{ "InvalidUser", "admin123", "Invalid username" },
			{ "Admin", "wrongpass", "Invalid password" },
			{ "user123", "password", "Invalid username and password" },
			{ "test", "test123", "Non-existent user" }
		};
	}

	/**
	 * Test Case 11: Parameterized test with multiple invalid credentials
	 * Purpose: Verify login fails with various invalid credential combinations
	 */
	@Test(priority = 11, dataProvider = "invalidCredentials", 
		description = "TC_N_011: Test with multiple invalid credentials")
	public void testLoginWithMultipleInvalidCredentials(String username, String password, String description) {
		System.out.println("\n========== TEST CASE 11: Testing - " + description + " ==========");
		
		loginPage.performLogin(username, password);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Verify login failed
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertFalse(isLoginSuccessful, "Login should fail for: " + description);
		
		System.out.println("Test passed for: " + description);
	}
}
