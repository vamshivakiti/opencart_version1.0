package AnnotaionsDemo2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDem02 {
	@BeforeMethod
	void BM() {
		System.out.println("This is Before method");
	}
	@AfterMethod
	void AM() {
		System.out.println("This is after method");
	}
	@BeforeSuite
void BS() {
	System.out.println("This is Before Suite");
}
	@AfterSuite
void AS() {
	System.out.println("This is After Suite");
}
	@BeforeTest
void BT() {
	System.out.println("This is Before Test");
}
	@AfterTest
void AT(){
	System.out.println("This is After Test");
}
	@BeforeClass
void BC() {
	System.out.println("This is Before Class");
}
	@AfterClass
	
void AC() {
	System.out.println("This is After Class");
}
	@Test

void Test1() {
	System.out.println("This is Test 1");
}
	@Test
void Test2(){
	System.out.println("This is Test 2");
}
}
