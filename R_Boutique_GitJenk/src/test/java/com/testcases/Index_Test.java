package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.Index_Page;
import com.utility.Log;


public class Index_Test extends Base{

	Index_Page IndexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String browser) {
		Driver_Init(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void  Teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void Logo_Test() {
		Log.startTestCase("Logo");
		IndexPage = new Index_Page();
		boolean res = IndexPage.Logo_verify();
		Assert.assertTrue(res);
		Log.endTestCase("Logo");
	}
	
	@Test(groups = "Smoke")
	public void test_StoreTitle() {
		Log.startTestCase("Store Title");
		String actual_Title = IndexPage.StoreTitle_verify();
		String expected_Title = "My Store";
		Assert.assertEquals(actual_Title, expected_Title);
		Log.endTestCase("Store Title");
	}

}
