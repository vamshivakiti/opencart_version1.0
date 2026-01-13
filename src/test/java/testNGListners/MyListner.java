package testNGListners;

import org.testng.ITestContext;
import org.testng.ITestListener;
//ITestListener is pre-defined interface
import org.testng.ITestResult;


public class MyListner implements ITestListener {
	public void onStart() {
		System.out.println("Test execution is started");
	}
	
	 public void onTestStart(ITestResult result) {
		    System.out.println("Test has stared....");
		  }
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("Test is passed....");		  }
	  public void onTestFailure(ITestResult result) {
		  System.out.println("Test is Failed....");
		  }
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("Test is skipped....");
		  }
    public void onFinis(ITestContext context) {
		System.out.println("Test has finished...");
	}
	
}
