# OrangeHRM Login Test Automation Framework

> A comprehensive Selenium WebDriver & TestNG-based automation framework for testing OrangeHRM login functionality

## 📋 Overview

This project provides complete test automation for the OrangeHRM login page with:
- **8 Positive Test Cases** - Verify successful login scenarios
- **11 Negative Test Cases** - Verify login failure handling
- **19 Total Test Cases** - Comprehensive coverage
- **Page Object Model (POM)** - Clean architecture
- **Data-Driven Testing** - Parameterized test cases

## 🎯 Quick Start

### Clone & Setup
```bash
cd C:\Git\opencart_version1.0
mvn clean install
```

### Run Tests
```bash
# All tests
mvn clean test

# Positive tests only
mvn clean test -Dtest=OrangeHRMLoginPositiveTest

# Negative tests only
mvn clean test -Dtest=OrangeHRMLoginNegativeTest

# Demo script
mvn clean test -Dtest=OrangeHRMLoginDemo
```

## 📁 Project Structure

```
opencart_version1.0/
├── src/test/java/seleniumPractice/
│   ├── OrangeHRMLoginDemo.java              # Demo script
│   ├── OrangeHRMLoginBase.java              # Base test class
│   ├── OrangeHRMLoginPage.java              # Page Object Model
│   ├── OrangeHRMLoginPositiveTest.java      # 8 Positive tests
│   └── OrangeHRMLoginNegativeTest.java      # 11 Negative tests
│
├── orangehrm_login_tests.xml                # TestNG suite config
│
├── Documentation/
│   ├── QUICK_START_GUIDE.md                 # Quick reference
│   ├── OrangeHRM_LOGIN_TEST_CASES.md        # Full documentation
│   ├── TEST_CASES_SUMMARY.md                # Test specifications
│   ├── FILE_MANIFEST.md                     # File organization
│   └── IMPLEMENTATION_SUMMARY.md            # Project summary
│
└── pom.xml                                  # Maven configuration
```

## 🧪 Test Cases

### Positive Tests (TC_P_001 to TC_P_008)
- ✅ Verify login page elements
- ✅ Successful login with valid credentials
- ✅ Username field input validation
- ✅ Password field input validation
- ✅ Page title verification
- ✅ Page URL verification
- ✅ Login button functionality
- ✅ Complete login workflow

### Negative Tests (TC_N_001 to TC_N_011)
- ✅ Invalid username
- ✅ Invalid password
- ✅ Empty username
- ✅ Empty password
- ✅ Both fields empty
- ✅ Case-sensitive password
- ✅ Special characters
- ✅ Spaces in credentials
- ✅ SQL injection prevention
- ✅ Multiple failed attempts
- ✅ Data-driven test (parameterized)

## 🔑 Key Components

### OrangeHRMLoginPage (POM)
Page Object Model with methods:
- `enterUsername()` - Enter username
- `enterPassword()` - Enter password
- `clickLoginButton()` - Click login button
- `performLogin()` - Complete login
- `isLoginSuccessful()` - Verify login
- `getErrorMessage()` - Get error text
- And more...

### OrangeHRMLoginBase
Base class providing:
- Browser initialization
- Window maximization
- Wait configuration
- Browser cleanup
- Navigation methods

### Test Classes
- `OrangeHRMLoginPositiveTest` - 8 positive test methods
- `OrangeHRMLoginNegativeTest` - 11 negative test methods

## 🚀 Features

✨ **Modern Framework**
- Selenium WebDriver 4.34.0
- TestNG 7.11.0
- Java 21+

🎯 **Best Practices**
- Page Object Model
- Explicit and Implicit waits
- Data-driven testing
- Comprehensive error handling
- Detailed logging

📚 **Well Documented**
- 5 comprehensive markdown files
- Clear code comments
- Usage examples
- Troubleshooting guide

🔒 **Robust Testing**
- Security testing (SQL injection)
- Edge case handling
- Multiple failure scenarios
- Input validation

## 📊 Statistics

| Metric | Value |
|--------|-------|
| Java Files | 5 |
| Test Cases | 19 |
| POM Methods | 13 |
| Documentation Files | 5 |
| Lines of Code | 1,200+ |
| Test Coverage | Comprehensive |

## 🧑‍💻 Technology Stack

- **Language**: Java 21+
- **Automation**: Selenium WebDriver 4.34.0
- **Testing Framework**: TestNG 7.11.0
- **Build Tool**: Maven
- **Browser**: Chrome
- **IDE**: Eclipse/IntelliJ IDEA

## 🏃 How to Run

### Option 1: Demo Script
Step-by-step demonstration of login process
```bash
mvn clean test -Dtest=OrangeHRMLoginDemo
```

### Option 2: Positive Tests
Verify successful login scenarios
```bash
mvn clean test -Dtest=OrangeHRMLoginPositiveTest
```

### Option 3: Negative Tests
Verify failure handling
```bash
mvn clean test -Dtest=OrangeHRMLoginNegativeTest
```

### Option 4: All Tests
Run complete suite
```bash
mvn clean test
```

## 📖 Documentation

1. **QUICK_START_GUIDE.md** - Get started in 5 minutes
2. **OrangeHRM_LOGIN_TEST_CASES.md** - Comprehensive guide (2,500+ lines)
3. **TEST_CASES_SUMMARY.md** - Detailed test specifications
4. **FILE_MANIFEST.md** - File organization and purposes
5. **IMPLEMENTATION_SUMMARY.md** - Project overview and status

## ✅ Test Credentials

- **URL**: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
- **Username**: Admin
- **Password**: admin123

## 🔧 Configuration

### Implicit Wait: 10 seconds
### Explicit Wait: 10 seconds
### Browser: Chrome (Headless optional)
### Window: Maximized

## 📝 Test Results

After running tests:
- Maven Surefire Reports: `target/surefire-reports/`
- TestNG Reports: `test-output/`
- Console Output: Detailed execution logs

## 🐛 Troubleshooting

### Tests running slow?
- Check internet connection
- Verify page loading

### Element not found?
- Verify page structure
- Check browser console

### Browser issues?
- Ensure ChromeDriver matches Chrome version
- Check system resources

## 🎓 Learning Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [OrangeHRM](https://www.orangehrm.com/)

## 📞 Support

For issues or questions:
1. Check troubleshooting section
2. Review documentation files
3. Examine console output
4. Review test logs

## 🔄 Future Enhancements

- [ ] Screenshot capture on failure
- [ ] Extent Reports integration
- [ ] Performance testing
- [ ] CI/CD pipeline integration
- [ ] Cross-browser testing
- [ ] Mobile testing

## 📜 License

This project is for educational and testing purposes.

## 👨‍💼 Author

**QA Automation Team**  
**Date**: April 2026  
**Version**: 1.0

---

## 🎉 Status

**✅ Project Complete and Ready for Use**

All 19 test cases implemented and verified. Framework is production-ready.

---

### Quick Links

| Link | Purpose |
|------|---------|
| [QUICK_START_GUIDE.md](./QUICK_START_GUIDE.md) | Get started quickly |
| [OrangeHRM_LOGIN_TEST_CASES.md](./OrangeHRM_LOGIN_TEST_CASES.md) | Detailed documentation |
| [TEST_CASES_SUMMARY.md](./TEST_CASES_SUMMARY.md) | Test specifications |
| [FILE_MANIFEST.md](./FILE_MANIFEST.md) | File organization |
| [IMPLEMENTATION_SUMMARY.md](./IMPLEMENTATION_SUMMARY.md) | Project summary |

---

**Happy Testing! 🚀**

