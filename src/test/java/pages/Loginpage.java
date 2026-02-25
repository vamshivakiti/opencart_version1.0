package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//instance variables
	WebDriver driver;
	//Constructor
 public Loginpage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			}
	//Page elements
	 @FindBy(xpath = "//input[@placeholder='Username']")
	 WebElement txt_username;
	 
	 @FindBy(xpath = "//input[@placeholder='Password']")
	 WebElement txt_password;
	
	 @FindBy(xpath = "//button[normalize-space()='Login']")
	 WebElement login_btn ;

	
	
	
	//Actions Methods
	
	void set_userName(String username) {
		txt_username.sendKeys(username);
	}
	
void set_password(String password) {
	txt_password.sendKeys(password);;
	}
void clickLogin() {
	login_btn.click();
	
}

	
}
