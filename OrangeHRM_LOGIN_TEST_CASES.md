# OrangeHRM Login Test Automation

## Project Overview
This project provides comprehensive automated test cases for the OrangeHRM login functionality using Selenium WebDriver and TestNG. The test suite includes both positive and negative test scenarios.

## Application URL
- **Login Page**: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

## Project Structure

```
seleniumPractice/
├── OrangeHRMLoginDemo.java              # Simple demo script
├── OrangeHRMLoginBase.java              # Base test class with setup/teardown
├── OrangeHRMLoginPage.java              # Page Object Model
├── OrangeHRMLoginPositiveTest.java      # Positive test cases
├── OrangeHRMLoginNegativeTest.java      # Negative test cases
└── orangehrm_login_tests.xml            # TestNG configuration
```

## Setup Instructions

### Prerequisites
- Java 21 or higher
- Maven 3.8.1 or higher
- Chrome browser
- ChromeDriver (automatically managed by WebDriverManager)

### Dependencies
The project uses the following dependencies (already configured in pom.xml):
- Selenium WebDriver 4.34.0
- TestNG 7.11.0

### Running Tests

#### Option 1: Run using TestNG XML file
```bash
mvn clean test -Dsuitexml=orangehrm_login_tests.xml
```

#### Option 2: Run specific test class
```bash
mvn clean test -Dtest=OrangeHRMLoginPositiveTest
mvn clean test -Dtest=OrangeHRMLoginNegativeTest
```

#### Option 3: Run the demo script
```bash
# Compile and run the demo
javac -cp target/classes:target/dependency/* OrangeHRMLoginDemo.java
java -cp target/classes:target/dependency/* seleniumPractice.OrangeHRMLoginDemo
```

## Test Cases

### POSITIVE TEST CASES (OrangeHRMLoginPositiveTest.java)

| TC ID | Test Case | Purpose | Expected Result |
|-------|-----------|---------|-----------------|
| TC_P_001 | Verify login page elements are displayed | Verify all required UI elements are visible | All elements (username field, password field, login button, forgot password link) are displayed |
| TC_P_002 | Successful login with valid credentials | Verify user can login with Admin/admin123 | User is redirected to Dashboard successfully |
| TC_P_003 | Verify username field accepts input | Verify username field accepts user input | Username field contains entered value |
| TC_P_004 | Verify password field accepts input | Verify password field accepts user input | Password field contains entered value |
| TC_P_005 | Verify page title on login page | Verify login page has correct title | Page title contains "OrangeHRM" or "Login" |
| TC_P_006 | Verify login page URL | Verify correct URL is loaded | URL contains "auth/login" |
| TC_P_007 | Verify login button is clickable | Verify login button is clickable on page | Login button is clickable and visible |
| TC_P_008 | Complete login workflow | Verify end-to-end login process | Complete workflow from login to dashboard is successful |

### NEGATIVE TEST CASES (OrangeHRMLoginNegativeTest.java)

| TC ID | Test Case | Purpose | Expected Result |
|-------|-----------|---------|-----------------|
| TC_N_001 | Login with invalid username | Verify login fails with wrong username | Login fails and error message is displayed |
| TC_N_002 | Login with invalid password | Verify login fails with wrong password | Login fails and error message is displayed |
| TC_N_003 | Login with empty username | Verify login fails with empty username | Login fails |
| TC_N_004 | Login with empty password | Verify login fails with empty password | Login fails |
| TC_N_005 | Login with both fields empty | Verify login fails when both fields are empty | Login fails |
| TC_N_006 | Login with case-sensitive password | Verify password is case-sensitive | Login fails with wrong case password |
| TC_N_007 | Login with special characters | Verify special characters cause login failure | Login fails |
| TC_N_008 | Login with spaces in credentials | Verify spaces in credentials behavior | Login fails or app trims spaces |
| TC_N_009 | Login with SQL injection attempt | Verify SQL injection prevention | SQL injection is prevented and login fails |
| TC_N_010 | Multiple failed login attempts | Verify app behavior after multiple failures | All attempts fail as expected |
| TC_N_011 | Parameterized test with multiple invalid credentials | Test various invalid credential combinations | All combinations fail as expected |

## Key Features

### Page Object Model (OrangeHRMLoginPage.java)
The POM encapsulates all page elements and interactions:
- Username field
- Password field
- Login button
- Error message element
- Dashboard header (success verification)
- Forgot password link

### Methods in OrangeHRMLoginPage
- `enterUsername(String username)` - Enters username
- `enterPassword(String password)` - Enters password
- `clickLoginButton()` - Clicks login button
- `performLogin(String username, String password)` - Complete login action
- `isLoginSuccessful()` - Verifies successful login
- `getErrorMessage()` - Gets error message text
- `isErrorMessageDisplayed()` - Checks if error message is visible
- `isUsernameFieldVisible()` - Checks if username field is visible
- `isPasswordFieldVisible()` - Checks if password field is visible
- `isLoginButtonVisible()` - Checks if login button is visible
- `isForgotPasswordLinkVisible()` - Checks if forgot password link is visible
- `getCurrentURL()` - Gets current page URL
- `getPageTitle()` - Gets page title

### Base Test Class (OrangeHRMLoginBase.java)
Provides common functionality:
- Browser setup with ChromeDriver
- Implicit and explicit waits (10 seconds)
- Window maximization
- Browser cleanup after tests
- Navigation to login URL

## Test Execution

### Using Maven
```bash
# Run all tests
mvn clean test

# Run with test report
mvn clean test -Dtest=OrangeHRMLoginPositiveTest surefire-report:report

# Run specific test method
mvn clean test -Dtest=OrangeHRMLoginPositiveTest#testSuccessfulLogin
```

### Using TestNG Console
```bash
# Run from TestNG XML
mvn clean test -Dsuitexml=orangehrm_login_tests.xml
```

## Test Credentials
- **Username**: Admin
- **Password**: admin123

## Wait Strategies

### Implicit Wait
- Applied globally: 10 seconds
- Used for all element interactions

### Explicit Wait
- Used in POM methods for critical elements
- Timeout: 10 seconds
- Conditions: presenceOf, visibilityOf, elementToBeClickable

## Error Handling

The test suite includes comprehensive error handling:
- Try-catch blocks for element not found scenarios
- Verification of login success/failure
- Error message validation
- Page load verification

## Reports

Test execution generates reports in:
- `target/surefire-reports/` - Maven Surefire reports
- `test-output/` - TestNG reports
- Console output with detailed step information

## Best Practices Implemented

1. **Page Object Model** - Separation of concerns
2. **DRY Principle** - Reusable methods and base classes
3. **Explicit Waits** - For reliable element interactions
4. **Descriptive Test Names** - Clear test purpose
5. **Comprehensive Logging** - Console output for debugging
6. **Data-Driven Testing** - Using @DataProvider for parameterized tests
7. **Assertions** - TestNG assertions for verification
8. **Proper Setup/Teardown** - @BeforeTest and @AfterTest annotations

## Troubleshooting

### Tests taking too long
- Reduce implicit wait timeout
- Check internet connection for page loading

### Element not found errors
- Verify element locators are correct
- Check if element is within iframe or shadow DOM
- Add debug breakpoints to inspect page

### Browser crashes
- Update ChromeDriver to match Chrome version
- Check system resources
- Disable browser extensions in headless mode

## Future Enhancements

1. Add screenshot capture on test failure
2. Implement extent reports for better visualization
3. Add performance testing
4. Integrate with CI/CD pipeline (Jenkins, GitHub Actions)
5. Add mobile testing with Appium
6. Implement cross-browser testing
7. Add video recording of test execution

## Contact & Support

For issues or questions, please refer to:
- OrangeHRM Documentation: https://www.orangehrm.com/
- Selenium Documentation: https://www.selenium.dev/documentation/
- TestNG Documentation: https://testng.org/doc/

---
**Version**: 1.0
**Last Updated**: April 2026
**Author**: QA Automation Team
