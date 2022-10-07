package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.dataprovider.Data_Providers;
import com.pages.Home_Page;
import com.pages.Index_Page;
import com.pages.Login_Page;
import com.utility.Log;


public class Login_Test extends Base {

	Index_Page IndexPage;
	Login_Page LoginPage;
	Home_Page HomePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String browser) {
		Driver_Init(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void Teardown() {
		getDriver().quit();
	}

	@Test(groups = {"Smoke","Sanity"},dataProvider = "Credentials", dataProviderClass = Data_Providers.class)
	public void Login_test(String Username, String Password) {
		Log.startTestCase("Login");
		IndexPage = new Index_Page();
		LoginPage = IndexPage.SignIn_click();
//		HomePage = LoginPage.LoginInformationHome_enter(prop.getProperty("username"), prop.getProperty("password"));
		HomePage = LoginPage.LoginInformationHome_enter(Username, Password);
		String Actual_URL = HomePage.HomePageURL_verify();
		String Expected_URL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(Actual_URL, Expected_URL);
		Log.endTestCase("Login");
	}
}
