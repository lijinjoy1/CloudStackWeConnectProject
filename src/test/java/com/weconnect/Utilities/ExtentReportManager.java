package com.weconnect.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest tests;
	
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myReport.html"); // Specify the location
		
		sparkReporter.config().setDocumentTitle("Automation Report"); // Specify the title
		sparkReporter.config().setReportName("Login Functional testing"); // Specify the report name
		sparkReporter.config().setTheme(Theme.DARK);				 // Specify the theme.
		
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("computername", "localhost");
		reports.setSystemInfo("ENV", "QA");
		reports.setSystemInfo("Tester Name", "Lijin");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Browser", "Edge");
		
	  }	
	public void onTestStart(ITestResult result) {
		 System.out.println("Test started");
	  }
	
	 
	public void onTestSuccess(ITestResult result) { 
		
		tests = reports.createTest(result.getName());  // Create a new entry in the report
		tests.log(Status.PASS, "test passed "+result.getName()); // update status
		
	  }
	
	public void onTestFailure(ITestResult result) {
		tests = reports.createTest(result.getName());  // Create a new entry in the report
		tests.log(Status.FAIL, "test failed " +result.getName()); // update status
		tests.log(Status.FAIL, "test failed cause is "+result.getThrowable()); // update status

	  }

	 public void onFinish(ITestContext context) {
		 System.out.println("Test completed");
			reports.flush();
		  }
}

