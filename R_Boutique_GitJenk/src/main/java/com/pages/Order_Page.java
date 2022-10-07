package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Order_Page extends Base{
	
	public Order_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[@class='price special-price']")
	WebElement Unit_Price;
	
	@FindBy(id="total_price")
	WebElement Total_Price;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement Checkout_Btn;
	
	public double UnitPrice_verify() {
		String UnitPrice = Unit_Price.getText();
		String BoldUnit_Price = UnitPrice.replaceAll("[^a-zA-Z0-9]", "");// remove $ sign with blank
		double FinalUnit_Price = Double.parseDouble(BoldUnit_Price);
		return FinalUnit_Price/100;// returns 1651/100 = 16.51
		
	}
	
	public double TotalPrice_verify() {
		String TotalPrice = Total_Price.getText();
		String BoldTotal_Price = TotalPrice.replaceAll("[^a-zA-Z0-9]", "");
		double FinalTotal_Price =Double.parseDouble(BoldTotal_Price);// convert String to double
		return FinalTotal_Price/100;// returns 1651/100 = 16.51
	}
	
	public Login_Page Checkout_click() throws InterruptedException {
		Checkout_Btn.click();
		return new Login_Page();
	}
}
