package TestNgDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
@Test(priority = 1)
	void openApp()
	{
	Assert.assertTrue(true);
	}
	@Test(priority = 2, dependsOnMethods = "openApp")
	void login() {
		Assert.assertTrue(false);
	}
	@Test(priority = 3, dependsOnMethods = "login"  )
	void search() {
		Assert.assertTrue(true);
	}
	@Test(priority = 4, dependsOnMethods = {"login","search"})
	void advSearch() {
		Assert.assertTrue(true);
	}
	@Test(priority = 5,dependsOnMethods = "login")
	
	void logtOut() {
		Assert.assertTrue(true);
	}
	@Test
	void titletest() {
	String	exp_Title="OpenCart";
	String	act_Title="Openshop";	
	if(act_Title.equals(exp_Title)) {
		System.out.println("Test Passed");
	}
	else {
		System.out.println("Test Failed");
	}
	Assert.assertEquals(act_Title, exp_Title);
	}
	
}

