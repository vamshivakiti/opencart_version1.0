package AnnotaionsDemo2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependancyDemo {
	@Test(priority = 0)
	void openApp() {
	Assert.assertTrue(true);
		}
	@Test(priority = 1,dependsOnMethods = {"openApp"} )
void Login() {
	System.out.println("This is login");
	Assert.assertTrue(false );
}
@Test(priority = 2,dependsOnMethods = {"Login"})
void search() {
	System.out.println("This is search");
	Assert.assertTrue(true);
}
@Test(priority = 3,dependsOnMethods = {"Login"})
void advSearch() {
	System.out.println("This is adv search");
	Assert.assertTrue(true);
}
@Test(priority = 4,dependsOnMethods = {"Login"})
void logout() {
	System.out.println("This is log out");
	Assert.assertTrue(true);
}
	
	
}
