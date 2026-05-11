# OrangeHRM Login Automation - Quick Start Guide

## What Was Created

I've created a complete test automation framework for OrangeHRM login with the following files:

### 1. **OrangeHRMLoginDemo.java** (Simple Demo)
A standalone script that demonstrates basic login functionality:
- Navigates to the OrangeHRM login page
- Finds and fills username field with "Admin"
- Finds and fills password field with "admin123"
- Verifies successful login by checking for Dashboard

**How to Run:**
```bash
mvn clean compile exec:java -Dexec.mainClass="seleniumPractice.OrangeHRMLoginDemo"
```

### 2. **OrangeHRMLoginBase.java** (Base Class)
Provides common test setup and teardown:
- Browser initialization
- Window maximization
- Implicit and explicit waits (10 seconds)
- Browser cleanup
- Login URL constant

### 3. **OrangeHRMLoginPage.java** (Page Object Model)
Encapsulates all login page elements and interactions:
- Locators for all UI elements
- Methods for user interactions (enter username, enter password, click login)
- Verification methods (isLoginSuccessful, isErrorMessageDisplayed, etc.)
- Explicit waits for element interactions

**Key Methods:**
- `enterUsername(String username)` - Enter username
- `enterPassword(String password)` - Enter password
- `clickLoginButton()` - Click login button
- `performLogin(String username, String password)` - Complete login
- `isLoginSuccessful()` - Verify successful login
- `getErrorMessage()` - Get error message text
- `isErrorMessageDisplayed()` - Check if error is shown

### 4. **OrangeHRMLoginPositiveTest.java** (Positive Test Cases)
8 positive test cases verifying successful login scenarios:

| Test Case | Description |
|-----------|-------------|
| TC_P_001 | Verify all login page elements are displayed |
| TC_P_002 | Successful login with valid credentials (Admin/admin123) |
| TC_P_003 | Verify username field accepts input |
| TC_P_004 | Verify password field accepts input |
| TC_P_005 | Verify login page title |
| TC_P_006 | Verify login page URL contains "auth/login" |
| TC_P_007 | Verify login button is clickable |
| TC_P_008 | Complete end-to-end login workflow |

### 5. **OrangeHRMLoginNegativeTest.java** (Negative Test Cases)
11 negative test cases verifying login failure scenarios:

| Test Case | Description |
|-----------|-------------|
| TC_N_001 | Login with invalid username |
| TC_N_002 | Login with invalid password |
| TC_N_003 | Login with empty username |
| TC_N_004 | Login with empty password |
| TC_N_005 | Login with both fields empty |
| TC_N_006 | Login with case-sensitive password |
| TC_N_007 | Login with special characters |
| TC_N_008 | Login with spaces in credentials |
| TC_N_009 | SQL injection attempt prevention |
| TC_N_010 | Multiple failed login attempts |
| TC_N_011 | Parameterized test with multiple invalid credentials |

### 6. **orangehrm_login_tests.xml** (TestNG Configuration)
TestNG suite configuration that runs all positive and negative test cases

### 7. **OrangeHRM_LOGIN_TEST_CASES.md** (Documentation)
Comprehensive documentation including:
- Project overview
- Setup instructions
- Complete test case descriptions
- Best practices implemented
- Troubleshooting guide

## Running the Tests

### Option 1: Run Demo Script
```bash
mvn clean test -Dtest=OrangeHRMLoginDemo
```

### Option 2: Run Positive Tests Only
```bash
mvn clean test -Dtest=OrangeHRMLoginPositiveTest
```

### Option 3: Run Negative Tests Only
```bash
mvn clean test -Dtest=OrangeHRMLoginNegativeTest
```

### Option 4: Run All Tests with TestNG XML
```bash
mvn clean test -DsuiteXmlFiles=orangehrm_login_tests.xml
```

### Option 5: Run All Tests
```bash
mvn clean test
```

## Test Credentials
- **Username**: Admin
- **Password**: admin123

## Test Flow Summary

### Positive Test Flow:
1. Navigate to login page ✓
2. Verify all elements are displayed ✓
3. Enter valid credentials ✓
4. Click login button ✓
5. Verify Dashboard is displayed ✓

### Negative Test Flow:
1. Navigate to login page ✓
2. Enter invalid/empty credentials ✓
3. Click login button ✓
4. Verify error message is displayed ✓
5. Verify login failed (Dashboard not shown) ✓

## Key Features

✅ **Page Object Model** - Clean separation of UI locators and test logic
✅ **Explicit Waits** - Reliable element interactions with proper waits
✅ **Comprehensive Coverage** - 19 test cases covering positive and negative scenarios
✅ **Data-Driven Testing** - Parameterized tests with @DataProvider
✅ **Error Handling** - Try-catch blocks and proper exception handling
✅ **Detailed Logging** - Console output for debugging
✅ **Best Practices** - Follows industry standards and Selenium best practices
✅ **Easy Maintenance** - Well-organized, readable, and maintainable code

## Project Structure

```
C:\Git\opencart_version1.0\
├── src\test\java\seleniumPractice\
│   ├── OrangeHRMLoginDemo.java
│   ├── OrangeHRMLoginBase.java
│   ├── OrangeHRMLoginPage.java
│   ├── OrangeHRMLoginPositiveTest.java
│   └── OrangeHRMLoginNegativeTest.java
├── orangehrm_login_tests.xml
├── OrangeHRM_LOGIN_TEST_CASES.md
└── pom.xml (existing)
```

## Wait Strategies Implemented

- **Implicit Wait**: 10 seconds globally
- **Explicit Wait**: 10 seconds for critical elements
- **Conditions Used**:
  - `presenceOfElementLocated` - Element exists in DOM
  - `visibilityOf` - Element is visible on page
  - `elementToBeClickable` - Element is clickable

## Browser Configuration

- Browser: Chrome
- Window: Maximized
- Mode: Normal (can be changed to incognito)
- Timeout: 10 seconds implicit + explicit

## Reports Generated

After test execution, reports are available in:
- `target/surefire-reports/` - Maven test reports
- `test-output/` - TestNG HTML reports
- Console output with detailed logs

## Next Steps

1. Navigate to Eclipse workspace
2. Open the created files to review
3. Run any of the test options mentioned above
4. Check test reports in target folder
5. Review console output for detailed execution flow

## Troubleshooting

**Q: Tests running slow?**
A: Check internet connection, reduce wait times if needed

**Q: Element not found?**
A: Verify the page loaded completely, check browser console

**Q: Login not working?**
A: Verify credentials, check if page structure changed

**Q: Browser not opening?**
A: Ensure ChromeDriver matches Chrome version

---
**All files created successfully and ready to use!** ✓
