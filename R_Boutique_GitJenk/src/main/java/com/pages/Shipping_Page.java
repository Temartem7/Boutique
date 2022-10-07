package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Shipping_Page extends Base{

	public Shipping_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="cgv")
	WebElement check_AgreeWithTerms;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement Checkout_Btn;
	
	public Payment_Page Checkout_click() {
		Checkout_Btn.click();
		return new Payment_Page();
	}
	
	public void Agree_click() {
		check_AgreeWithTerms.click();
	}
}
