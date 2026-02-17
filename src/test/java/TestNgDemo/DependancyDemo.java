package TestNgDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependancyDemo {
@Test(priority = 1)
	void opeApp()
	{
	
		System.out.println("Open the Application");
		Assert.assertTrue(false);
	}
@Test(priority=1,dependsOnMethods = "opeApp")
	void Login() {
		System.out.println("Login the App");
	}
@Test(priority = 3,dependsOnMethods = "Login")
	void search() {
		System.out.println("Search...");
	}
@Test(priority = 4, dependsOnMethods = "search")
	void AdvSearch() {
		
		System.out.println("Adv search ......");
	}
@Test(priority = 5,dependsOnMethods = "opeApp")
void logout() {
	System.out.println("Logout..");
}
	
}
