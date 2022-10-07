package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.dataprovider.Data_Providers;
import com.pages.AddToCart_Page;
import com.pages.Index_Page;
import com.pages.SearchResult_Page;
import com.utility.Log;

public class AddToCart_Test extends Base {

	Index_Page IndexPage;
	SearchResult_Page SearchResultPage;
	AddToCart_Page AddToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String browser) {
		Driver_Init(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void Teardown() {
		getDriver().quit();
	}

	@Test(groups = {"Sanity","Regression"},dataProvider = "Product",dataProviderClass = Data_Providers.class)
	public void AddToCart_test(String ProductName,String Qty,String Size) throws Throwable {
		Log.startTestCase("Add To Cart");	
		IndexPage = new Index_Page();
		SearchResultPage=IndexPage.SearchForProduct(ProductName);
		SearchResultPage.ListView_click();
		AddToCartPage = SearchResultPage.More_click();
		boolean img = AddToCartPage.Image_verify();
		Assert.assertTrue(img);
		AddToCartPage.ColorYellow_click();
		AddToCartPage.Quantity_enter(Qty);
		AddToCartPage.Size_enter(Size);
		AddToCartPage.AddToCart_click();
		boolean msg = AddToCartPage.ItemAddToCart_verify();
		Assert.assertTrue(msg);
//		AddToCartPage.Checkout_click();
		Log.endTestCase("Add To Cart");
	}
}