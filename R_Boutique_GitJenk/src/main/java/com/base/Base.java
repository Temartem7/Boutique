package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.utility.ExtentReportManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
//	@BeforeSuite: Run before all tests in this suite.
//	@AfterSuite: Run after all tests in this suite.
	
//	@BeforeTest: Run before any test method belonging to the classes inside the <test> tag.
//	@AfterTest: Run after all the test methods belonging to the classes inside the <test> tag.
	
//	@BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method.
//	@AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method.
	
//	@BeforeClass: Run before the first test method in the current class is invoked.
//	@AfterClass: Run after all the test methods in the current class have been run.
	
//	@BeforeMethod: Run before each test method.
//	@AfterMethod: Run after each test method.
	
//	public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver>driver=new ThreadLocal<RemoteWebDriver>();
	public static Properties prop;
	
	//============================================================================================================
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void Load_Configuration() {
		ExtentReportManager.Set_ExtentReport();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/Config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//============================================================================================================
	public static WebDriver getDriver() {
		return driver.get();
	}
	//============================================================================================================
	@Parameters("browser")
	public void Driver_Init(String browserName) {
//		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
//			driver= new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
//			driver= new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver()); 
//			driver= new EdgeDriver();
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
	}
	//============================================================================================================
	public boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}
	//============================================================================================================
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}
	//============================================================================================================
	public static String Screenshot(WebDriver driver, String FileName) {
		String Full_Date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String Screenshot_Destination = System.getProperty("user.dir")+"\\Screenshots\\"+FileName+"_"+Full_Date+".png";
		try {
			FileUtils.copyFile(src, new File(Screenshot_Destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// Jenkins config
//				String Screenshot_DestinationJenkins = "http://localhost:8080/job/Qstore/ws/Qstore3_4/Screenshot/"
//				+ FileName + "_" + Full_Date + ".png";
		return Screenshot_Destination;
	}
	//============================================================================================================
//	public static String GetCurrentTime() {
//		String Current_Date = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
//		return Current_Date;
//	}
	//============================================================================================================
	@AfterSuite
	public void After_Suite() {
		ExtentReportManager.End_ExtentReport();
	}
	//============================================================================================================
}
