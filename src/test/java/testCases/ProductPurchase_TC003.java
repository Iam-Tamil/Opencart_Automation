package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.CommonMethods;
import com.Base.InitDriver;
import com.Enum.Locators;
import com.Enum.browser;
import com.Utils.ConfigProperty;
import com.Utils.ExtendReport;

public class ProductPurchase_TC003 extends CommonMethods{
	
	@BeforeSuite
	public void openBrowser() {
		InitDriver.launchBrowser(browser.CHROME);
		ExtendReport.reportName("Opencart Application Flow");
	}
	
	@Test
	public void login() {

		ExtendReport.testName("Login");
		ExtendReport.assignAuthorName("Tamilselvan");
		
		submit(loginpage.getMyAccount());
		submit(loginpage.getLogin());
		sendText(loginpage.getEmailId(), ConfigProperty.getPropertyFile("E-Mail"));
		sendText(loginpage.getPassword(), ConfigProperty.getPropertyFile("Password"));
		submit(loginpage.getLoginBtn());
		
		String expectedTitle = "My Account";
		
		String actualTitle = getPageTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			ExtendReport.testResult("pass", "Login successfully");
		} else {
			ExtendReport.testResult("fail", "Login failed");
		} 
	}
	
	@Test(dependsOnMethods = "login")
	public void searchProduct() {
		
		ExtendReport.testName("Product Search");
		ExtendReport.assignAuthorName("Tamilselvan");
		

		sendText(product.getSearchBar(), ConfigProperty.getPropertyFile("ProductName"));
		submit(product.getSearchBarBtn());
		
		submit(product.getProduct());
		
		String expectedTitle = "iPhone";
		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		submit(product.getAddToCart());
		submit(product.getCart());
		submit(product.getViewCart());
		submit(product.getCheckout());
		
		String expectedCheckoutTitle = "Checkout";
		
		String actualCheckoutTitle = getPageTitle();
		
		if(expectedCheckoutTitle.equals(actualCheckoutTitle)) {
			ExtendReport.testResult("pass", "Login successfully");
		} else {
			ExtendReport.testResult("fail", "Login failed");
		} 
	}
	
	@Test(dependsOnMethods = "searchProduct")
	public void deliveryAddress() {
		
		ExtendReport.testName("Delivery Address");
		ExtendReport.assignAuthorName("Tamilselvan");
		
		sendText(product.getFirstname(), ConfigProperty.getPropertyFile("FirstName"));
		sendText(product.getLastname(), ConfigProperty.getPropertyFile("LastName"));
		sendText(product.getAddress(), ConfigProperty.getPropertyFile("Address"));
		sendText(product.getCity(), ConfigProperty.getPropertyFile("City"));
		sendText(product.getPostcode(), ConfigProperty.getPropertyFile("PostCode"));
		selectText(product.getCountry(), ConfigProperty.getPropertyFile("Country"));
		selectText(product.getState(), ConfigProperty.getPropertyFile("State"));
		
		submit(product.getBillingContinueBtn());
		
		WebElement address = element(Locators.xpath, "//input[@checked='checked']");
		
		
		if(checkEnabled(address)) {
			ExtendReport.testResult("pass", "Address updated successfully");
		}else {
			ExtendReport.testResult("fail", "Updation failed");
		} 
		
	}
	
	@Test(dependsOnMethods = "deliveryAddress")
	public void confirmOrder() {
		
		ExtendReport.testName("Confirm Order");
		ExtendReport.assignAuthorName("Tamilselvan");
		
		submit(product.getDeliveryDetailContinueBtn());
		submit(product.getDeliveryMethodContinueBtn());
		submit(product.getAgree());
		submit(product.getDeliveryDetailContinueBtn());
		submit(product.getConfirmOrder());
		
		String expectedText = "Your order has been placed!";
		
		WebElement element = element(Locators.tagName, "h1");
		String actualText = getElementText(element);

		if(actualText.equals(expectedText)) {
			ExtendReport.testResult("pass", "Order Placed successfully");
		} else {
			ExtendReport.testResult("fail", "Order Placement failed");
		} 
	}
	@AfterSuite
	public void close() {
		ExtendReport.reportFlush();
		InitDriver.tearDown();
	}

}
