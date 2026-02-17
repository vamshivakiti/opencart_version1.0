package TestNgDemo;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftVsHardAssertion {
	
//@Test(enabled = false)
	@Ignore
	void Test_HardAsserion() {
		System.out.println("Testing....");
		System.out.println("Testing....");
		//Hard Assertions
		Assert.assertEquals(1,2); //Failed
		
		System.out.println("Testing....");
		System.out.println("Testing....");
	}
@Test()
void Test_SoftAsserion() {
	System.out.println("Testing....");
	System.out.println("Testing....");
	
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(1,2); //Failed
	//FLows continues
	System.out.println("Testing....");
	System.out.println("Testing....");
	sa.assertAll();// This statement is mandatory
}


	
	
	
}
