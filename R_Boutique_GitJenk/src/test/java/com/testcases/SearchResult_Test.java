package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.dataprovider.Data_Providers;
import com.pages.Index_Page;
import com.pages.SearchResult_Page;
import com.utility.Log;

public class SearchResult_Test extends Base{

	Index_Page IndexPage;
	SearchResult_Page SearchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String browser) {
		Driver_Init(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void  Teardown() {
		getDriver().quit();
	}

	@Test(groups="Smoke",dataProvider = "SearchProduct",dataProviderClass = Data_Providers.class)
	public void ProductAvailable_Test(String ProductName) {
		Log.startTestCase("Product Avalability");
		IndexPage=new Index_Page();
		SearchResultPage=IndexPage.SearchForProduct(ProductName);
		boolean res = SearchResultPage.ProductAvalability_verify();
		Assert.assertTrue(res);
		Log.endTestCase("Product Avalability");
	}
}
