package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Login_Page extends Base{

	public Login_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "email")
	WebElement Login_EmailAddress_Field;

	@FindBy(id = "passwd")
	WebElement Login_Password_Field;

	@FindBy(id = "SubmitLogin")
	WebElement SignIn_Btn;

	@FindBy(id = "email_create")
	WebElement NewEmailAccount_Field;

	@FindBy(id = "SubmitCreate")
	WebElement NewAccount_Btn;

	public Home_Page LoginInformationHome_enter(String email, String password) {
		Login_EmailAddress_Field.sendKeys(email);
		Login_Password_Field.sendKeys(password);
		SignIn_Btn.click();
		return new Home_Page();
	}

	public Address_Page LoginInformationAddress_enter(String email, String password) {
		Login_EmailAddress_Field.sendKeys(email);
		Login_Password_Field.sendKeys(password);
		SignIn_Btn.click();
		return new Address_Page();
	}

	public AccountCreation_Page NewAccount_create(String newAccountEmail) {
		NewEmailAccount_Field.sendKeys(newAccountEmail);
		NewAccount_Btn.click();
		return new AccountCreation_Page();
	}
}
