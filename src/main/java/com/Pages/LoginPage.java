package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.InitDriver;

public class LoginPage extends InitDriver{
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']") private WebElement myAccount;

	@FindBy(linkText="Login") private WebElement login;
	
	@FindBy(id="input-email") private WebElement emailId;

	@FindBy(id="input-password") private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']") private WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::a[1]t") private WebElement forgotPassword;

	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//li)[5]") private WebElement logout;
	
	public WebElement getLogout() {return logout;}

	public WebElement getMyAccount() {return myAccount;}

	public WebElement getLogin() {return login;}
	
	public WebElement getEmailId() {return emailId;}

	public WebElement getPassword() {return password;}

	public WebElement getLoginBtn() {return LoginBtn;}

	public WebElement getForgotPassword() {return forgotPassword;}

}
