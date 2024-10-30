package com.testng.extentreport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner_ExtentReport implements ITestListener 
{

	public ExtentSparkReporter report;
	// it is provide the basic information of the document--> document tiitle, report name, theme of the report
	public ExtentReports extent;
	// it will provide the basic info of the user-->username, host name, environment, os, browser
	public ExtentTest test;
	//it is provide the basic info of the test cases--> Pass,fail,skip
	
	//pre-defined methods(onstart, onTestSuccess, OnTestFailure, OnTestSkipped, OnFinish)
	
	public void onStart(ITestContext tr) {
		
		report=new ExtentSparkReporter("D:\\testng workspace\\Team31_testng\\extentreport\\luma.html");
		
		//document tittle
		
		report.config().setDocumentTitle("Luma-Testing-Report");
		report.config().setReportName("Luma Login-Logout validation test");
		report.config().setTheme(Theme.STANDARD);
		
		//provide basic info user
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Hostname", "Local Host");
		extent.setSystemInfo("User", "mastani");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Browser", "Chrome,Edge");	
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));	
	}
	
	public void onTestFailure(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));	
	}
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));	
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush(); // ==> it will remove un-nessecary data
	
	} 
}
