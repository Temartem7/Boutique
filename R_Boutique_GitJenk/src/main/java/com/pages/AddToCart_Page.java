package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Base;

public class AddToCart_Page extends Base {
	
	public AddToCart_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "bigpic")
	WebElement Product_Img;

	@FindBy(xpath = "//span[.='Add to cart']")
	WebElement AddToCart_Btn;

	@FindBy(id = "color_15")
	WebElement Color_Green;

	@FindBy(id = "color_16")
	WebElement Color_Yellow;

	@FindBy(id = "group_1")
	WebElement Select_Size;

	@FindBy(id = "quantity_wanted")
	WebElement Select_Quantity;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement Checkout_Btn;

	@FindBy(xpath = "//span[@title='Continue shopping']")
	WebElement ContinueShopping_Btn;

	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement SuccessfullyAddedToShoppingCart_Msg;

		
	public boolean ItemAddToCart_verify() throws InterruptedException {
		Thread.sleep(6000);
		return SuccessfullyAddedToShoppingCart_Msg.isDisplayed();
	}

	public boolean Image_verify() {
		return Product_Img.isDisplayed();
	}

	public void AddToCart_click() {
		AddToCart_Btn.click();
	}

	public Order_Page Checkout_click() {
		Checkout_Btn.click();
		return new Order_Page();
	}

	public void Quantity_enter(String Quantity) {
		Select_Quantity.clear();
		Select_Quantity.sendKeys(Quantity);
	}

	public void Size_enter(String Size) {
		Select selectSize = new Select(Select_Size);
		selectSize.selectByVisibleText(Size);
	}

	public void ColorGreen_click() {
		Color_Green.click();
	}

	public void ColorYellow_click() {
		Color_Yellow.click();
	}
}
