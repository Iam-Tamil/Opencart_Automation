package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.InitDriver;

public class ProductPurchase extends InitDriver {
	
	public ProductPurchase() {
		PageFactory.initElements(driver, this);
	}
	
	// Product purchase

	public WebElement getSearchBar() {
		return searchBar;
	}


	public WebElement getSearchBarBtn() {
		return searchBarBtn;
	}
	
	public WebElement getProduct() {
		return product;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getViewCart() {
		return viewCart;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	// Billing Address
	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPostcode() {
		return postcode;
	}
	
	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}
	
	public WebElement getBillingContinueBtn() {
		return billingContinueBtn;
	}

	public WebElement getDeliveryDetailContinueBtn() {
		return deliveryDetailContinueBtn;
	}

	public WebElement getDeliveryMethodContinueBtn() {
		return deliveryMethodContinueBtn;
	}

	public WebElement getAgree() {
		return agree;
	}

	public WebElement getPaymentMethodContinueBtn() {
		return paymentMethodContinueBtn;
	}

	public WebElement getConfirmOrder() {
		return confirmOrder;
	}

	// Product purchase
	
	@FindBy(name="search") private WebElement searchBar;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-default')]") private WebElement searchBarBtn;

	@FindBy(linkText = "iPhone") private WebElement product;
	
	@FindBy(id = "button-cart") private WebElement addToCart;
	
	@FindBy(id = "cart-total") private WebElement cart;
	
	@FindBy(xpath = "//a[contains(.,'View Cart')]") private WebElement viewCart;
	
	@FindBy(linkText = "Checkout") private WebElement checkout;
	
	
	// Billing Address
	
	@FindBy(name = "firstname") private WebElement firstname;

	@FindBy(name = "lastname") private WebElement lastname;
	
	@FindBy(name = "address_1") private WebElement address;
	
	@FindBy(name = "city") private WebElement city;
	
	@FindBy(name = "postcode") private WebElement postcode;
	
	@FindBy(name = "country_id") private WebElement country;

	@FindBy(name = "zone_id") private WebElement state;
	
	@FindBy(xpath = "(//input[@type='button'])[1]") private WebElement billingContinueBtn;
	
	@FindBy(xpath = "(//input[@type='button'])[1]") private WebElement deliveryDetailContinueBtn;
	
	@FindBy(xpath = "(//input[@type='button'])[3]") private WebElement deliveryMethodContinueBtn;
	
	@FindBy(name = "agree") private WebElement agree;
	
	@FindBy(id = "button-payment-method") private WebElement paymentMethodContinueBtn;
	
	@FindBy(id = "button-confirm") private WebElement confirmOrder;
	
	
}
