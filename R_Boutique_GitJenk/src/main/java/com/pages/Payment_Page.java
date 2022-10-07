package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Payment_Page  extends Base{

	public Payment_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement Pay_BankWire;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement Pay_Check;
	
	public OrderSummary_Page BankWire_click() {
		Pay_BankWire.click();
		return new OrderSummary_Page();
	}
	
	public OrderSummary_Page Check_click() {
		Pay_Check.click();
		return new OrderSummary_Page();
	}

}
