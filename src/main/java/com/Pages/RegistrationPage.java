package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.InitDriver;

public class RegistrationPage extends InitDriver {
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']") private WebElement myAccount;
	
	@FindBy(linkText="Register") private WebElement registration;
	
	@FindBy(id="input-firstname") private WebElement fname;

	@FindBy(id="input-lastname") private WebElement lname;
	
	@FindBy(id="input-email") private WebElement email;
	
	@FindBy(id="input-telephone") private WebElement phone;
	
	@FindBy(id="input-password") private WebElement pass;
	
	@FindBy(id="input-confirm") private WebElement cnfmpass;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]") private WebElement newsletter;
	
	@FindBy(xpath="//input[@name='agree']") private WebElement policy;
	
	@FindBy(xpath="//input[@type='submit']") private WebElement continueBtn;
	
	@FindBy(tagName="h1") private WebElement content;

	public WebElement getContent() {
		return content;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getRegistration() {
		return registration;
	}
	
	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getCnfmpass() {
		return cnfmpass;
	}

	public WebElement getNewsletter() {
		return newsletter;
	}

	public WebElement getPolicy() {
		return policy;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}


}
