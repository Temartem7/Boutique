package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Address_Page extends Base{

	public Address_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement Checkout_Btn;

	public Shipping_Page Checkout_click() {
		Checkout_Btn.click();
		return new Shipping_Page();
	}
}
