package AnnotaionsDemo2;

import org.testng.annotations.Test;

public class GroupingDemo2_SignUp {
@Test(priority = 1, groups ={"regression"})
	void signupEmail(){
		System.out.println("Email sign up");
	}
@Test(priority = 2, groups ={"regression"})
	void signupFacebook() {
		System.out.println("Facebook sign up");
	}
@Test(priority = 3, groups ={"regression"})
	void signupInsta() {
		System.out.println("Insta sign up");
	}
}
