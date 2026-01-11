package TestNgDemo;

import org.testng.annotations.Test;

import com.google.j2objc.annotations.Property;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

/*
 *  Open application
 *   Login
 *   Log out 
 * */

public class FirstTestcase 
{
	@Test(priority=3)
	void logout() {
		System.out.println("Log out application");
	}
	@Test(priority=1)
	void open_app() {
		System.out.println("Open application");
	}
	@Test(priority = 2)
	void login() {
		System.out.println("Login to app");
	}
	
	
	
}
