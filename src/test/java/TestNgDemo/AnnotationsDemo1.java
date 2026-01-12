package TestNgDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
  1) Login -- @BeforeMethod
  2) Search --@Test
  3) Logout --@AfterMethod
  4) Login -- @BeforeMethod
  5) AdvanseSearch-- @Test
  6) Logout--@AfterMethod
  */
public class AnnotationsDemo1 {
@BeforeMethod
	void Login() {
		System.out.println("Login");
	}
	 @Test(priority = 1)
	void search() {
		 System.out.println("Search");
	 }
	 @Test(priority = 2)
	void AdvanceSearch() {
		 System.out.println("Advance Search");
	 }
	@AfterMethod
	void Logout() {
		System.out.println("Logout");
	}
}
