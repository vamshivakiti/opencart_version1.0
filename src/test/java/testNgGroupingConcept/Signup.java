package testNgGroupingConcept;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Signup {

	  @Test(priority = 1,groups = {"regression"})
	  	void email() {
	  		System.out.println("signUp by email");
	  	}
	  
	  @Test(priority = 2,groups = {"regression"})
	  	void facebook() {
	  		System.out.println("signUp by facebook");
	  	}
	  @Test(priority = 3,groups = {"regression"})
	  	void gmail() {
	  		System.out.println("signUp by gmail");
	  	}
	  @Test(priority = 4,groups = {"regression"})
	  	void twitter() {
	  		System.out.println("signUp by twitter");
	  	}
	  
}
