package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AssertionsDemo {
@Test
	void TestTitle() {
		String exp_Title="Opencart";
		String act_title="Opencart";
	
		if(act_title==exp_Title) {
			System.out.println("test passed");
		}
		else {
			{System.out.println("test failed");}
		}
		
		//Hard Assertions.
		Assert.assertEquals(exp_Title, act_title);
   
	}
	@Test
   void softAssertion() {
	   String exp_Title1="Opencart1";
		String act_title1="Opencart";
	    SoftAssert sa = new SoftAssert();
	    sa.assertEquals(exp_Title1, act_title1);
	   
	   
   }
	
}
