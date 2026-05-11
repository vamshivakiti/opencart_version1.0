# File Manifest - OrangeHRM Login Test Automation

## Java Source Files

### 1. OrangeHRMLoginDemo.java
**Location**: `C:\Git\opencart_version1.0\src\test\java\seleniumPractice\`  
**Type**: Standalone Demo Script  
**Purpose**: Simple demonstration of OrangeHRM login automation  
**Contains**:
- Main method with step-by-step login process
- Navigation to login page
- Username/password entry
- Login verification

**Key Features**:
- No TestNG annotations
- Direct WebDriver usage
- Try-catch exception handling
- Console output for each step

**Usage**: `mvn clean test -Dtest=OrangeHRMLoginDemo`

---

### 2. OrangeHRMLoginBase.java
**Location**: `C:\Git\opencart_version1.0\src\test\java\seleniumPractice\`  
**Type**: Base Test Class  
**Purpose**: Common setup and teardown for all test classes  
**Contains**:
- @BeforeTest - Browser initialization
- @AfterTest - Browser cleanup
- Constants for login URL
- Common utility methods

**Key Features**:
- ChromeDriver initialization
- Window maximization
- Implicit and explicit wait configuration
- Extends in all test classes

**Usage**: Inherited by OrangeHRMLoginPositiveTest and OrangeHRMLoginNegativeTest

---

### 3. OrangeHRMLoginPage.java
**Location**: `C:\Git\opencart_version1.0\src\test\java\seleniumPractice\`  
**Type**: Page Object Model (POM)  
**Purpose**: Encapsulate login page elements and interactions  
**Contains**:
- Element locators (By)
- WebDriver and WebDriverWait instances
- Methods for user interactions
- Verification methods

**Key Methods**:
```java
enterUsername(String username)
enterPassword(String password)
clickLoginButton()
performLogin(String username, String password)
isLoginSuccessful()
getErrorMessage()
isErrorMessageDisplayed()
isUsernameFieldVisible()
isPasswordFieldVisible()
isLoginButtonVisible()
isForgotPasswordLinkVisible()
getCurrentURL()
getPageTitle()
```

**Usage**: Used by OrangeHRMLoginPositiveTest and OrangeHRMLoginNegativeTest

---

### 4. OrangeHRMLoginPositiveTest.java
**Location**: `C:\Git\opencart_version1.0\src\test\java\seleniumPractice\`  
**Type**: TestNG Test Class  
**Purpose**: Positive test cases for successful login scenarios  
**Contains**: 8 @Test methods with positive scenarios

**Test Cases**:
| Method | TC ID | Priority | Description |
|--------|-------|----------|-------------|
| testLoginPageElementsDisplayed | TC_P_001 | 1 | Verify all UI elements displayed |
| testSuccessfulLogin | TC_P_002 | 2 | Login with valid credentials |
| testUsernameFieldAcceptsInput | TC_P_003 | 3 | Username field input test |
| testPasswordFieldAcceptsInput | TC_P_004 | 4 | Password field input test |
| testLoginPageTitle | TC_P_005 | 5 | Verify page title |
| testLoginPageURL | TC_P_006 | 6 | Verify page URL |
| testLoginButtonClickable | TC_P_007 | 7 | Verify login button |
| testCompleteLoginWorkflow | TC_P_008 | 8 | End-to-end workflow |

**Key Features**:
- @BeforeMethod for test setup
- Extends OrangeHRMLoginBase
- Uses OrangeHRMLoginPage POM
- TestNG assertions
- @Test annotations with priority and description

**Usage**: `mvn clean test -Dtest=OrangeHRMLoginPositiveTest`

---

### 5. OrangeHRMLoginNegativeTest.java
**Location**: `C:\Git\opencart_version1.0\src\test\java\seleniumPractice\`  
**Type**: TestNG Test Class  
**Purpose**: Negative test cases for login failure scenarios  
**Contains**: 11 @Test methods and 1 @DataProvider

**Test Cases**:
| Method | TC ID | Priority | Description |
|--------|-------|----------|-------------|
| testLoginWithInvalidUsername | TC_N_001 | 1 | Invalid username |
| testLoginWithInvalidPassword | TC_N_002 | 2 | Invalid password |
| testLoginWithEmptyUsername | TC_N_003 | 3 | Empty username |
| testLoginWithEmptyPassword | TC_N_004 | 4 | Empty password |
| testLoginWithEmptyBoth | TC_N_005 | 5 | Both fields empty |
| testLoginWithWrongCasePassword | TC_N_006 | 6 | Case-sensitive password |
| testLoginWithSpecialCharacters | TC_N_007 | 7 | Special characters |
| testLoginWithSpaces | TC_N_008 | 8 | Spaces in credentials |
| testLoginWithSQLInjection | TC_N_009 | 9 | SQL injection test |
| testMultipleFailedLoginAttempts | TC_N_010 | 10 | Multiple attempts |
| testLoginWithMultipleInvalidCredentials | TC_N_011 | 11 | Data-driven test |

**Key Features**:
- Data-driven testing with @DataProvider
- Parameterized tests
- Security testing (SQL injection)
- Error message validation
- Multiple attempt handling

**Usage**: `mvn clean test -Dtest=OrangeHRMLoginNegativeTest`

---

## Configuration Files

### orangehrm_login_tests.xml
**Location**: `C:\Git\opencart_version1.0\`  
**Type**: TestNG Suite Configuration  
**Purpose**: Define test suite structure and execution order  
**Contains**:
- Suite configuration
- Two test definitions:
  - OrangeHRM Login Positive Tests
  - OrangeHRM Login Negative Tests
- Test method inclusion list

**Usage**: `mvn clean test -DsuiteXmlFiles=orangehrm_login_tests.xml`

---

## Documentation Files

### OrangeHRM_LOGIN_TEST_CASES.md
**Location**: `C:\Git\opencart_version1.0\`  
**Type**: Comprehensive Documentation  
**Contains**:
- Project overview
- Setup instructions
- Complete test case descriptions
- Project structure
- Methods documentation
- Test execution guidelines
- Best practices
- Troubleshooting guide
- Future enhancements

---

### QUICK_START_GUIDE.md
**Location**: `C:\Git\opencart_version1.0\`  
**Type**: Quick Reference Guide  
**Contains**:
- File descriptions
- Running instructions
- Test credentials
- Test flow summary
- Key features
- Troubleshooting

---

### TEST_CASES_SUMMARY.md
**Location**: `C:\Git\opencart_version1.0\`  
**Type**: Test Cases Detail Document  
**Contains**:
- All 19 test cases with details
- Priority levels
- Test data
- Steps and expected results
- Test coverage summary
- Execution commands

---

## File Organization

```
C:\Git\opencart_version1.0\
│
├── src\test\java\seleniumPractice\
│   ├── OrangeHRMLoginDemo.java              [Demo Script]
│   ├── OrangeHRMLoginBase.java              [Base Class]
│   ├── OrangeHRMLoginPage.java              [POM]
│   ├── OrangeHRMLoginPositiveTest.java      [8 Positive Tests]
│   └── OrangeHRMLoginNegativeTest.java      [11 Negative Tests]
│
├── orangehrm_login_tests.xml                [TestNG Configuration]
│
├── OrangeHRM_LOGIN_TEST_CASES.md            [Detailed Documentation]
├── QUICK_START_GUIDE.md                     [Quick Reference]
├── TEST_CASES_SUMMARY.md                    [Test Details]
└── FILE_MANIFEST.md                         [This File]
```

---

## Dependencies Required

All dependencies are already configured in `pom.xml`:

```xml
<!-- Selenium WebDriver -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.34.0</version>
</dependency>

<!-- TestNG -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.11.0</version>
    <scope>test</scope>
</dependency>
```

---

## Summary Statistics

| Item | Count |
|------|-------|
| Java Source Files | 5 |
| Configuration Files | 1 |
| Documentation Files | 4 |
| Total Test Cases | 19 |
| Positive Test Cases | 8 |
| Negative Test Cases | 11 |
| POM Methods | 13 |
| Lines of Code (approx.) | 1,200+ |

---

## How to Use Each File

### For Quick Demo
1. Run `OrangeHRMLoginDemo.java`
2. View console output

### For Test Development
1. Use `OrangeHRMLoginPage.java` (POM) for page interactions
2. Extend `OrangeHRMLoginBase.java` for test classes
3. Write test methods in test classes

### For Running Tests
1. Use Maven commands with POM.xml
2. Or use TestNG XML configuration

### For Documentation
1. Read `QUICK_START_GUIDE.md` for overview
2. Read `OrangeHRM_LOGIN_TEST_CASES.md` for details
3. Read `TEST_CASES_SUMMARY.md` for test specifications

---

## Test Execution Workflow

```
Start
  ↓
Setup (OrangeHRMLoginBase.setUp())
  ↓
Navigate to Login Page
  ↓
OrangeHRMLoginPositiveTest / OrangeHRMLoginNegativeTest
  ├─ Test 1
  ├─ Test 2
  ├─ ...
  └─ Test N
  ↓
Teardown (OrangeHRMLoginBase.tearDown())
  ↓
End
```

---

## Version Information

- **Created**: April 2026
- **Java Version**: 21+
- **Selenium Version**: 4.34.0
- **TestNG Version**: 7.11.0
- **Status**: ✓ Production Ready

---

**All files created and documented successfully!**
