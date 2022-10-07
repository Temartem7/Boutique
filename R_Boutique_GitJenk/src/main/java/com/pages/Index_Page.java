package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Index_Page extends Base{
	
	public Index_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy (xpath = "//img[@alt='My Store']")
	WebElement Logo;
	
	@FindBy (id="search_query_top")
	WebElement Search_Field;
	
	@FindBy (name="submit_search")
	WebElement Search_Btn;
	
	@FindBy (xpath="//a[@class='login']")
	WebElement SignIn_Btn;
	
	public boolean Logo_verify() {
		 return Logo.isDisplayed();
	}
	
	public String StoreTitle_verify() {
		return getDriver().getTitle();
	}
	
	public SearchResult_Page SearchForProduct(String ProductName) {
		Search_Field.sendKeys(ProductName);
		Search_Btn.click();
		return new SearchResult_Page();
	}
	
	public Login_Page SignIn_click() {
		SignIn_Btn.click();
		return new Login_Page();
	}
}
