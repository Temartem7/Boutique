package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Home_Page extends Base{

	public Home_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//a[@title='My wishlists']")
	WebElement MyWishList;
	
	@FindBy(xpath="//a[@title='Orders']")
	WebElement OrderHistory;

	public boolean MyWishList_verify() {
		return MyWishList.isDisplayed();
	}

	public boolean OrderHistory_verify() {
		return OrderHistory.isDisplayed();
	}

	public String HomePageURL_verify() {
		String HomePage_URL=getDriver().getCurrentUrl();
		return HomePage_URL;
	}

}
