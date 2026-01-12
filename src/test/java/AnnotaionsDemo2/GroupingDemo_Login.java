package AnnotaionsDemo2;

import org.testng.annotations.Test;

public class GroupingDemo_Login {
@Test(priority = 1,groups = {"sanity"})
	void LoginEmail() {
		System.out.println("Login Email");
	}
@Test(priority = 2,groups = {"sanity"})
	void loginFaceBook() {
		System.out.println("Login FaceBook");
	}
@Test(priority = 3,groups = {"sanity"})
	void loginInsta() {
		System.out.println("Login Insta");
	}
	
}
