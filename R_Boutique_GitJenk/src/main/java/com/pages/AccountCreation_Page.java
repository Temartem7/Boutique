package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class AccountCreation_Page extends Base{
	public AccountCreation_Page() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//h1[.='Create an account']")
	WebElement CreateAccount_Text;
	
	@FindBy(id="id_gender1")
	WebElement Mr;
	
	@FindBy(id="id_gender2")
	WebElement Mrs;
	
	@FindBy(id="customer_firstname")
	WebElement First_Name;
	
	@FindBy(id="customer_lastname")
	WebElement Last_Name;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(id="days")
	WebElement Days_Dropdown;
	
	@FindBy(id="months")
	WebElement Months_Dropdown;
	
	@FindBy(id="years")
	WebElement Years_Dropdown;
	
	@FindBy(id="firstname")
	WebElement FirstName_Address_Info;
	
	@FindBy(id="lastname")
	WebElement LastName_Address_Info;
	
	@FindBy(id="company")
	WebElement Company_Info;
	
	@FindBy(id="address1")
	WebElement Address_Info;
	
	@FindBy(id="city")
	WebElement City_Info;
	
	@FindBy(id="id_state")
	WebElement State_Dropdown;
	
	@FindBy(id="postcode")
	WebElement Zip_Code;
	
	@FindBy(id="id_country")
	WebElement Country_Dropdown;
	
	@FindBy(id="phone_mobile")
	WebElement Mobile_Phone;
	
	@FindBy(id="submitAccount")
	WebElement Register_Btn;
	
	public boolean AccountCreation_verify() {
		return CreateAccount_Text.isDisplayed();
	}

	public Home_Page Registration_click() {
		Register_Btn.click();
		return new Home_Page();
	}

	public void NewAccount_create(
			String Gender, 
			String FirstName,
			String LastName, 
			String Pass,
			String Day,
			String Month,
			String Year,
			String Company,
			String Address,
			String City,
			String State,
			String Zip,
			String Country,
			String Phone_Number) {
		
		if(Gender.equalsIgnoreCase("Mr")) {
			Mr.click();
		}else {
			Mrs.click();
		}
		First_Name.sendKeys(FirstName);
		Last_Name.sendKeys(LastName);
		Password.sendKeys(Pass);
		selectByValue(Days_Dropdown, Day);
		selectByValue(Months_Dropdown, Month);
		selectByValue(Years_Dropdown, Year);
		Company_Info.sendKeys(Company);
		Address_Info.sendKeys(Address);
		City_Info.sendKeys(City);
		selectByVisibleText(State, State_Dropdown);
		Zip_Code.sendKeys(Zip);
		selectByVisibleText(Country, Country_Dropdown);
		Mobile_Phone.sendKeys(Phone_Number);		
	}
}
