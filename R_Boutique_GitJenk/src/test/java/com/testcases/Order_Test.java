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
import com.pages.Order_Page;
import com.pages.SearchResult_Page;
import com.utility.Log;

public class Order_Test extends Base{

	Index_Page IndexPage;
	SearchResult_Page SearchResultPage;
	AddToCart_Page AddToCartPage;
	Order_Page OrderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String browser) {
		Driver_Init(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void  Teardown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression",dataProvider = "Product",dataProviderClass = Data_Providers.class)
	public void TotalPrice_Test(String ProductName,String Qty,String Size) {
		Log.startTestCase("Total Price");
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
		OrderPage=AddToCartPage.Checkout_click();
		double Unit_Price = OrderPage.UnitPrice_verify();
		double Total_Price = OrderPage.TotalPrice_verify();
		double TotalExpected_Price = (Unit_Price*(Double.parseDouble(Qty)))+2;
		Assert.assertEquals(Math.round(Total_Price),Math.round(TotalExpected_Price));		
		Log.endTestCase("Total Price");
	}
}
