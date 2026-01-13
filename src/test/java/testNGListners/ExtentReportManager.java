package testNGListners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;//UI of the report
	public ExtentReports extent; // Populate common info of the report
	public ExtentTest test; // Creating test case entries in the report.
	public void OnStartupTriggeringPolicy(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myreport.html");
		sparkReporter.config().setDocumentTitle("Automation-Report");
		sparkReporter.config().setReportName("FUnctional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer name", "Local Host");
		extent.setSystemInfo("Environment name", "QA");
		extent.setSystemInfo("Tester name", "Vamshi");
		extent.setSystemInfo("Browser name", "Chrome");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is: "+result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is: "+result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is: "+result.getThrowable());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is: "+result.getName());
		//test.log(Status.SKIP, "Test case SKIPPED cause is: "+result.getThrowable());
		
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
