package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.InitDriver;

public class NewCustomer extends InitDriver {
	
	public NewCustomer() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement addNewCustomer() {
		return addNewCustomer;
	}

	public WebElement customerName() {
		return customerName;
	}
	
	public WebElement getGender(String gender) {
		
		if(gender.toLowerCase()=="male") {
			this.male();
		}else if(gender.toLowerCase()=="female") {
			this.female();
		}return male();
	}

	public WebElement male() {
		return male;
	}

	public WebElement female() {
		return female;
	}

	public WebElement dateOfBirth() {
		return dateOfBirth;
	}
	
	public WebElement address() {
		return address;
	}

	public WebElement city() {
		return city;
	}

	public WebElement state() {
		return state;
	}

	public WebElement pinNo() {
		return pin;
	}

	public WebElement mobileNo() {
		return mobileNo;
	}

	public WebElement emailID() {
		return emailID;
	}

	public WebElement password() {
		return password;
	}

	public WebElement submit() {
		return submit;
	}

	public WebElement reset() {
		return reset;
	}
	
	public WebElement contBtn() {
		return continueBtn;
	}
	
	@FindBy(linkText="New Customer")
	private WebElement addNewCustomer;

	@FindBy(name = "name")
	private WebElement customerName;
	
	@FindBy(xpath = "(//input[@name='rad1'])[1]")
	private WebElement male;
	
	@FindBy(xpath = "(//input[@name='rad1'])[2]")
	private WebElement female;
	
	@FindBy(xpath = "//input[@type='date']")
	private WebElement dateOfBirth;
	
	@FindBy(name = "addr")
	private WebElement address;
	
	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "state")
	private WebElement state;
	
	@FindBy(name = "pinno")
	private WebElement pin;
	
	@FindBy(name = "telephoneno")
	private WebElement mobileNo;
	
	@FindBy(name = "emailid")
	private WebElement emailID;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "sub")
	private WebElement submit;
	
	@FindBy(name = "res")
	private WebElement reset;
	
	@FindBy(linkText = "Continue")
	private WebElement continueBtn;
	
}
