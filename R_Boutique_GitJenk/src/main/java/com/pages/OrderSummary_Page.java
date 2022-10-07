package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class OrderSummary_Page extends Base{

	public OrderSummary_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[.='I confirm my order']")
	WebElement ConfirmOrder_Btn;
	
	public OrderConfirmation_Page OrderConfirmation_click() {
		ConfirmOrder_Btn.click();
		return new OrderConfirmation_Page();
	}
}
