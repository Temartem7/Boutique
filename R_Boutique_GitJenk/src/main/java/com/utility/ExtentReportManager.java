package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;	//add test cases to report
	public static ExtentTest test;
	
	
	
	public static void Set_ExtentReport() {
		

		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"ExtReport.html");		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");	
		
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Project Name", "Boutique");
		extent.setSystemInfo("Tester", "Artem");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	
	public static void End_ExtentReport() {
		extent.flush();
	}
}
