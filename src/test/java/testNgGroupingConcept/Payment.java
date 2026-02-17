package testNgGroupingConcept;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Payment {
   @Test(priority = 1,groups = {"sanity", "regression","functional"})
	void cash() {
		System.out.println("Payment by cash");
	}
   @Test(priority = 2,groups = {"sanity", "regression","functional"})
	void card() {
		System.out.println("Payment by card");
	}
   
   @Test(priority = 3,groups = {"sanity", "regression","functional"})
	void online() {
		System.out.println("Payment by online");
	}
   
}
