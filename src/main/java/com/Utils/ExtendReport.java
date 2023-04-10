package com.Utils;

import com.Base.CommonMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extend;
	public static ExtentTest test;
	
	
	public static void reportName(String filename) {
		// blank report 
		reporter = new ExtentSparkReporter("./TestReport/"+filename+CommonMethods.getTimeStamp()+".html");
				
		// report
		extend = new ExtentReports();
		extend.attachReporter(reporter);
	}
	
	public static ExtentTest testName(String testname) {
		test = extend.createTest(testname);
		return test;
	}
	
	public static ExtentTest assignAuthorName(String AuthorName) {
		ExtentTest assignAuthor = test.assignAuthor(AuthorName);
		return assignAuthor;
	}
	
	public static ExtentTest assignTestCategory(String TestCategory) {
		ExtentTest assignCategory = test.assignCategory(TestCategory);
		return assignCategory;
	}
	
	
	public static ExtentTest testResult(String testStatus, String message) {
		if(testStatus.toLowerCase()=="pass") {
			test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(CommonMethods.screenShot()).build());
		}else if(testStatus.toLowerCase()=="fail") {
			test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(CommonMethods.screenShot()).build());
		}
		return test;
	}
	
	public static void reportFlush() {
		if(extend != null) {
			extend.flush();
		}
	}

}
