package testCases;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.CommonMethods;
import com.Base.InitDriver;
import com.Enum.browser;
import com.Utils.ConfigProperty;
import com.Utils.ExtendReport;

public class Registration_TC001 extends CommonMethods{
	
	@BeforeSuite
	public void openBrowser() {
		InitDriver.launchBrowser(browser.CHROME);
		ExtendReport.reportName("Opencart_Registration");
	}
	
	@Test
	public void registerNewUser() {		
			
		ExtendReport.testName("Opencart e-commerce application Reistration form");
		ExtendReport.assignAuthorName("Tamilselvan");
		
		submit(registrationPage.getMyAccount());
		submit(registrationPage.getRegistration());
		sendText(registrationPage.getFname(), ConfigProperty.getPropertyFile("FirstName"));
		sendText(registrationPage.getLname(), ConfigProperty.getPropertyFile("LastName"));
		sendText(registrationPage.getEmail(), ConfigProperty.getPropertyFile("E-Mail"));
		sendText(registrationPage.getPhone(), ConfigProperty.getPropertyFile("Telephone"));
		sendText(registrationPage.getPass(), ConfigProperty.getPropertyFile("Password"));
		sendText(registrationPage.getCnfmpass(), ConfigProperty.getPropertyFile("PasswordConfirm"));
		submit(registrationPage.getNewsletter());
		submit(registrationPage.getPolicy());
		submit(registrationPage.getContinueBtn());
		
		String actualText = getElementText(registrationPage.getContent());
		
		String expectedResult = "Your Account Has Been Created!";
		
		try {
			Assert.assertEquals(actualText, expectedResult);
			ExtendReport.testResult("pass", "Test has been completed successfully");
		} catch (Exception e) {
			ExtendReport.testResult("fail", "Test has been failed");
		}

	}
	
	@AfterSuite
	public void close() {
		ExtendReport.reportFlush();
		InitDriver.tearDown();
	}
}
