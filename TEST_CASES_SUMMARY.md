# OrangeHRM Login Test Cases Summary

## Overview
Complete test automation for OrangeHRM login functionality with 19 comprehensive test cases:
- **8 Positive Test Cases** - Verify successful login scenarios
- **11 Negative Test Cases** - Verify login failure handling

---

## POSITIVE TEST CASES

### TC_P_001: Verify Login Page Elements
**Priority**: 1  
**Type**: UI Verification  
**Description**: Verify that all required login elements are visible on page load  
**Steps**:
1. Navigate to login page
2. Check username field visibility
3. Check password field visibility
4. Check login button visibility
5. Check "Forgot your password?" link visibility

**Expected Result**: All elements are displayed  
**Test Data**: None  
**Status**: ✓ Ready

---

### TC_P_002: Successful Login with Valid Credentials
**Priority**: 2  
**Type**: Functional  
**Description**: Verify that user can successfully login with valid credentials  
**Steps**:
1. Navigate to login page
2. Enter username: "Admin"
3. Enter password: "admin123"
4. Click login button
5. Wait for dashboard to load
6. Verify dashboard is visible

**Expected Result**: User successfully logged in and redirected to dashboard  
**Test Data**: 
- Username: Admin
- Password: admin123
**Status**: ✓ Ready

---

### TC_P_003: Verify Username Field Accepts Input
**Priority**: 3  
**Type**: UI Verification  
**Description**: Verify that username field accepts user input correctly  
**Steps**:
1. Navigate to login page
2. Enter "Admin" in username field
3. Get the value from username field
4. Compare entered value with field value

**Expected Result**: Username field contains entered value "Admin"  
**Test Data**: Username = "Admin"  
**Status**: ✓ Ready

---

### TC_P_004: Verify Password Field Accepts Input
**Priority**: 4  
**Type**: UI Verification  
**Description**: Verify that password field accepts user input correctly  
**Steps**:
1. Navigate to login page
2. Enter "admin123" in password field
3. Get the value from password field
4. Compare entered value with field value

**Expected Result**: Password field contains entered value "admin123"  
**Test Data**: Password = "admin123"  
**Status**: ✓ Ready

---

### TC_P_005: Verify Login Page Title
**Priority**: 5  
**Type**: Verification  
**Description**: Verify that the login page has correct title  
**Steps**:
1. Navigate to login page
2. Get page title
3. Verify title contains "OrangeHRM" or "Login"

**Expected Result**: Page title contains "OrangeHRM" or "Login"  
**Test Data**: None  
**Status**: ✓ Ready

---

### TC_P_006: Verify Login Page URL
**Priority**: 6  
**Type**: Verification  
**Description**: Verify that the correct login page URL is loaded  
**Steps**:
1. Navigate to login page
2. Get current URL
3. Verify URL contains "auth/login"

**Expected Result**: URL contains "auth/login"  
**Expected URL**: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login  
**Status**: ✓ Ready

---

### TC_P_007: Verify Login Button is Clickable
**Priority**: 7  
**Type**: UI Verification  
**Description**: Verify that login button is clickable on the page  
**Steps**:
1. Navigate to login page
2. Verify login button is visible
3. Verify login button is enabled

**Expected Result**: Login button is visible and clickable  
**Status**: ✓ Ready

---

### TC_P_008: Complete Login Workflow
**Priority**: 8  
**Type**: End-to-End  
**Description**: Verify the complete login workflow from page load to dashboard access  
**Steps**:
1. Navigate to login page
2. Verify username field visibility
3. Verify password field visibility
4. Enter "Admin" in username field
5. Enter "admin123" in password field
6. Click login button
7. Wait for page load
8. Verify dashboard is visible

**Expected Result**: User successfully completes login workflow and reaches dashboard  
**Test Data**:
- Username: Admin
- Password: admin123
**Status**: ✓ Ready

---

## NEGATIVE TEST CASES

### TC_N_001: Login with Invalid Username
**Priority**: 1  
**Type**: Functional (Negative)  
**Description**: Verify that login fails with invalid username  
**Steps**:
1. Navigate to login page
2. Enter "InvalidUser" in username field
3. Enter "admin123" in password field
4. Click login button
5. Wait for response
6. Verify login failed
7. Verify error message is displayed

**Expected Result**: Login fails with error message  
**Test Data**:
- Username: InvalidUser
- Password: admin123
**Status**: ✓ Ready

---

### TC_N_002: Login with Invalid Password
**Priority**: 2  
**Type**: Functional (Negative)  
**Description**: Verify that login fails with invalid password  
**Steps**:
1. Navigate to login page
2. Enter "Admin" in username field
3. Enter "wrongpassword" in password field
4. Click login button
5. Wait for response
6. Verify login failed
7. Verify error message is displayed

**Expected Result**: Login fails with error message  
**Test Data**:
- Username: Admin
- Password: wrongpassword
**Status**: ✓ Ready

---

### TC_N_003: Login with Empty Username
**Priority**: 3  
**Type**: Functional (Negative)  
**Description**: Verify that login fails when username is empty  
**Steps**:
1. Navigate to login page
2. Leave username field empty
3. Enter "admin123" in password field
4. Click login button
5. Verify login failed

**Expected Result**: Login fails  
**Test Data**:
- Username: (empty)
- Password: admin123
**Status**: ✓ Ready

---

### TC_N_004: Login with Empty Password
**Priority**: 4  
**Type**: Functional (Negative)  
**Description**: Verify that login fails when password is empty  
**Steps**:
1. Navigate to login page
2. Enter "Admin" in username field
3. Leave password field empty
4. Click login button
5. Verify login failed

**Expected Result**: Login fails  
**Test Data**:
- Username: Admin
- Password: (empty)
**Status**: ✓ Ready

---

### TC_N_005: Login with Both Fields Empty
**Priority**: 5  
**Type**: Functional (Negative)  
**Description**: Verify that login fails when both fields are empty  
**Steps**:
1. Navigate to login page
2. Leave username field empty
3. Leave password field empty
4. Click login button
5. Verify login failed

**Expected Result**: Login fails  
**Test Data**:
- Username: (empty)
- Password: (empty)
**Status**: ✓ Ready

---

### TC_N_006: Login with Case-Sensitive Password
**Priority**: 6  
**Type**: Functional (Negative)  
**Description**: Verify that password is case-sensitive  
**Steps**:
1. Navigate to login page
2. Enter "Admin" in username field
3. Enter "ADMIN123" (wrong case) in password field
4. Click login button
5. Verify login failed
6. Verify error message is displayed

**Expected Result**: Login fails (password is case-sensitive)  
**Test Data**:
- Username: Admin
- Password: ADMIN123 (incorrect case)
**Status**: ✓ Ready

---

### TC_N_007: Login with Special Characters
**Priority**: 7  
**Type**: Functional (Negative)  
**Description**: Verify that special characters in credentials cause login failure  
**Steps**:
1. Navigate to login page
2. Enter "Admin@#$" in username field
3. Enter "admin123!@#" in password field
4. Click login button
5. Verify login failed

**Expected Result**: Login fails  
**Test Data**:
- Username: Admin@#$
- Password: admin123!@#
**Status**: ✓ Ready

---

### TC_N_008: Login with Spaces in Credentials
**Priority**: 8  
**Type**: Functional (Negative)  
**Description**: Verify behavior when spaces are included in credentials  
**Steps**:
1. Navigate to login page
2. Enter " Admin " (with spaces) in username field
3. Enter " admin123 " (with spaces) in password field
4. Click login button
5. Verify result (may fail or app may trim spaces)

**Expected Result**: Login fails (depending on application behavior)  
**Test Data**:
- Username: " Admin " (with leading/trailing spaces)
- Password: " admin123 " (with leading/trailing spaces)
**Status**: ✓ Ready

---

### TC_N_009: Login with SQL Injection Attempt
**Priority**: 9  
**Type**: Security Testing  
**Description**: Verify that SQL injection attempts are prevented  
**Steps**:
1. Navigate to login page
2. Enter "Admin' OR '1'='1" in username field
3. Enter "' OR '1'='1" in password field
4. Click login button
5. Verify login failed (SQL injection prevented)

**Expected Result**: Login fails (SQL injection is prevented)  
**Test Data**:
- Username: Admin' OR '1'='1
- Password: ' OR '1'='1
**Status**: ✓ Ready

---

### TC_N_010: Multiple Failed Login Attempts
**Priority**: 10  
**Type**: Functional (Negative)  
**Description**: Verify application behavior after multiple failed login attempts  
**Steps**:
1. Attempt login 3 times with invalid credentials
2. Each attempt: InvalidUser / wrongpassword
3. After each attempt, verify login failed
4. Monitor for any account lockout or throttling

**Expected Result**: All attempts fail as expected  
**Test Data**: 3 iterations with InvalidUser / wrongpassword  
**Status**: ✓ Ready

---

### TC_N_011: Parameterized Test with Multiple Invalid Credentials
**Priority**: 11  
**Type**: Data-Driven (Negative)  
**Description**: Verify login fails with various invalid credential combinations  
**Test Data**:
| Username | Password | Description |
|----------|----------|-------------|
| InvalidUser | admin123 | Invalid username |
| Admin | wrongpass | Invalid password |
| user123 | password | Invalid username and password |
| test | test123 | Non-existent user |

**Steps** (for each data set):
1. Navigate to login page
2. Enter username from test data
3. Enter password from test data
4. Click login button
5. Verify login failed

**Expected Result**: All login attempts fail  
**Status**: ✓ Ready

---

## Test Execution Summary

### Quick Start Commands

```bash
# Run all tests
mvn clean test

# Run positive tests only
mvn clean test -Dtest=OrangeHRMLoginPositiveTest

# Run negative tests only
mvn clean test -Dtest=OrangeHRMLoginNegativeTest

# Run demo script
mvn clean test -Dtest=OrangeHRMLoginDemo

# Run with TestNG XML
mvn clean test -DsuiteXmlFiles=orangehrm_login_tests.xml
```

### Test Coverage

| Category | Count | Status |
|----------|-------|--------|
| Positive Test Cases | 8 | ✓ Complete |
| Negative Test Cases | 11 | ✓ Complete |
| **Total Test Cases** | **19** | ✓ Complete |

### Test Scenarios Covered

✓ Valid Credentials Login  
✓ Invalid Username  
✓ Invalid Password  
✓ Empty Fields  
✓ Case Sensitivity  
✓ Special Characters  
✓ SQL Injection Prevention  
✓ Multiple Failed Attempts  
✓ Page Elements Verification  
✓ URL Verification  
✓ Title Verification  
✓ Error Message Handling  

---

## Key Test Assertions

1. **Login Success**: Dashboard header is visible
2. **Login Failure**: Dashboard is NOT visible
3. **Error Message**: Error message is displayed on login failure
4. **Page Elements**: All UI elements are visible on load
5. **URL Navigation**: Correct URL is loaded
6. **Field Input**: Fields accept and store entered values

---

## Test Environment

- **Application URL**: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
- **Test Credentials**: Admin / admin123
- **Browser**: Chrome
- **Implicit Wait**: 10 seconds
- **Explicit Wait**: 10 seconds
- **Java Version**: 21+
- **Selenium Version**: 4.34.0
- **TestNG Version**: 7.11.0

---

## Files Generated

1. ✓ OrangeHRMLoginDemo.java - Demo script
2. ✓ OrangeHRMLoginBase.java - Base test class
3. ✓ OrangeHRMLoginPage.java - Page Object Model
4. ✓ OrangeHRMLoginPositiveTest.java - Positive test cases
5. ✓ OrangeHRMLoginNegativeTest.java - Negative test cases
6. ✓ orangehrm_login_tests.xml - TestNG configuration
7. ✓ OrangeHRM_LOGIN_TEST_CASES.md - Detailed documentation
8. ✓ QUICK_START_GUIDE.md - Quick start guide
9. ✓ TEST_CASES_SUMMARY.md - This file

---

**Total Test Cases Created: 19**  
**Status: ✓ All Ready for Execution**  
**Last Updated: April 2026**

