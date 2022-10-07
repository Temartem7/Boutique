package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class SearchResult_Page  extends Base{

	public SearchResult_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy (id="grid")
	WebElement Grid_View;
	
	@FindBy (id="list")
	WebElement List_View;
	
	@FindBy (id="selectProductSort")
	WebElement SortBy_Menu;
	
	@FindBy (xpath="//img[@title='Printed Chiffon Dress']")
	WebElement Desired_Item;
	
	@FindBy (id="add_to_cart")
	WebElement AddToCart_Btn;
	
	@FindBy(xpath="//li[@class='ajax_block_product first-in-line last-item-of-tablet-line first-item-of-mobile-line col-xs-12']//span[contains(text(),'More')]")
	WebElement More_Btn;
	
	public void GridView_click() {
		Grid_View.click();
	}
	
	public void ListView_click() {
		List_View.click();
	}
		
	public AddToCart_Page Product_click() {	
		Desired_Item.click();
		return new AddToCart_Page();
	}
	
	public void AddToCart_click() {
		AddToCart_Btn.click();
	}
	
	public boolean ProductAvalability_verify() {
		return Desired_Item.isDisplayed();
	}
	
	public AddToCart_Page More_click() {
		More_Btn.click();
		return new AddToCart_Page();
	}
}
