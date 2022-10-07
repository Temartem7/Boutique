package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.dataprovider.Data_Providers;
import com.pages.AddToCart_Page;
import com.pages.Address_Page;
import com.pages.Index_Page;
import com.pages.Login_Page;
import com.pages.OrderConfirmation_Page;
import com.pages.OrderSummary_Page;
import com.pages.Order_Page;
import com.pages.Payment_Page;
import com.pages.SearchResult_Page;
import com.pages.Shipping_Page;
import com.utility.Log;

public class EndToEnd_Test extends Base{

	Index_Page IndexPage;
	SearchResult_Page SearchResultPage;
	AddToCart_Page AddToCartPage;
	Order_Page OrderPage;
	Login_Page LoginPage;
	Address_Page AddressPage;
	Shipping_Page ShippingPage;
	Payment_Page PaymentPage;
	OrderSummary_Page OrderSummaryPage;
	OrderConfirmation_Page OrderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String browser) {
		Driver_Init(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void  Teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression",dataProvider = "Product",dataProviderClass = Data_Providers.class)
	public void EndToEnd_test(String ProductName,String Qty,String Size) throws Throwable {
		Log.startTestCase("End To End");	
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
		OrderPage=AddToCartPage.Checkout_click();
		LoginPage=OrderPage.Checkout_click();
		AddressPage=LoginPage.LoginInformationAddress_enter(prop.getProperty("username"), prop.getProperty("password"));		
		ShippingPage=AddressPage.Checkout_click();
		ShippingPage.Agree_click();
		PaymentPage=ShippingPage.Checkout_click();
		OrderSummaryPage=PaymentPage.BankWire_click();
		OrderConfirmationPage=OrderSummaryPage.OrderConfirmation_click();
		String Actual_Msg = OrderConfirmationPage.Message_verify();
		String Expected_Msg="Your order on My Store is complete.";
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		Log.endTestCase("End To End");
	}
}
