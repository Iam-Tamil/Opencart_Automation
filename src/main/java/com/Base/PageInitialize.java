package com.Base;

import com.Pages.LoginPage;
import com.Pages.ProductPurchase;
import com.Pages.RegistrationPage;

public class PageInitialize extends InitDriver {
	
	public static RegistrationPage registrationPage;
	public static LoginPage loginpage;
	public static ProductPurchase product;

	public static void initialize() {
		registrationPage = new RegistrationPage();
		loginpage = new LoginPage();
		product = new ProductPurchase();
	}
}
