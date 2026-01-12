package AnnotaionsDemo2;

import org.testng.annotations.Test;

public class GroupingDemo3_Payment {

	@Test(priority = 1, groups ={"Sanity", "regression"})
	void payBycash() {
		System.out.println("Pay by cash");
	}
	@Test(priority = 2, groups ={"regression", "sanity"})
	void payByonline(){
		System.out.println("Payment by card");
	}
	@Test(priority = 3, groups ={"sanity","regression"})
	void payCard() {
		System.out.println("Payment by online");
	}
}
