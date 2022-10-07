package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class OrderConfirmation_Page extends Base{

	public OrderConfirmation_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//strong[.='Your order on My Store is complete.']")
	WebElement OrderComplete_Msg;
	
	public String Message_verify() {
		String Confirmation_Msg = OrderComplete_Msg.getText();
		return Confirmation_Msg;
	}
}
