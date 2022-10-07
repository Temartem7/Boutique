package com.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.dataprovider.Data_Providers;
import com.pages.AccountCreation_Page;
import com.pages.Home_Page;
import com.pages.Index_Page;
import com.pages.Login_Page;
import com.utility.Log;

public class AccountCreation_Test extends Base{

	Index_Page IndexPage;
	Login_Page LoginPage;
	AccountCreation_Page AccountCreationPage;
	Home_Page HomePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String browser) {
		Driver_Init(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void  Teardown() {
		getDriver().quit();
	}
	
//	@Test(groups = "Sanity",dataProvider = "Email",dataProviderClass = Data_Providers.class)
//	public void NewAccountCreation_verify(String Email) {		
//		Log.startTestCase("New Account Creation");		
//		IndexPage=new Index_Page();
//		LoginPage=IndexPage.SignIn_click();
//		AccountCreationPage=LoginPage.NewAccount_create(Email);
//		boolean res = AccountCreationPage.AccountCreation_verify();
//		Assert.assertTrue(res);		
//		Log.endTestCase("New Account Creation");
//	}
	
	@Test(groups = "Regression",dataProvider = "NewAccount",dataProviderClass = Data_Providers.class)
	public void test_AccountCreation(HashMap<String, String> Map) throws Throwable {
		Log.startTestCase("New Account Registration");	
		IndexPage=new Index_Page();
		LoginPage=IndexPage.SignIn_click();
		Thread.sleep(3000);
		AccountCreationPage=LoginPage.NewAccount_create(Map.get("Email"));
		Assert.assertTrue(AccountCreationPage.AccountCreation_verify());
		AccountCreationPage.NewAccount_create(
				Map.get("Gender"),
				Map.get("FirstName"),
				Map.get("LastName"),
				Map.get("SetPassword"),
				Map.get("Day"),
				Map.get("Month"),
				Map.get("Year"),
				Map.get("Company"),
				Map.get("Address"),
				Map.get("City"),
				Map.get("State"),
				Map.get("Zip"),
				Map.get("Country"),
				Map.get("MobileNumber"));
		HomePage=AccountCreationPage.Registration_click();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account",HomePage.HomePageURL_verify());
		Log.endTestCase("New Account Registration");
	}
}
