package testNgGroupingConcept;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class LoginTest {
   @Test(priority = 1, groups = {"sanity"})
	void email() {
		System.out.println("Login by email");
	}
   
   @Test(priority = 2,groups = {"sanity"})
  	void facebook() {
  		System.out.println("Login by facebook");
  	}
   @Test(priority = 3,groups = {"sanity"})
 	void gmail() {
 		System.out.println("Login by gmail");
   }
   @Test(priority = 4, groups = {"sanity"})
 	void twitter() {
 		System.out.println("Login by twitter");
 	}
}
