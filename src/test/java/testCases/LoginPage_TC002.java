package testCases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.CommonMethods;
import com.Base.InitDriver;
import com.Enum.Locators;
import com.Enum.browser;
import com.Utils.ExtendReport;
import com.Utils.ReadExcel;

public class LoginPage_TC002 extends CommonMethods{

	
	@BeforeSuite
	public void openBrowser() {
		InitDriver.launchBrowser(browser.CHROME);
		ExtendReport.reportName("Opencart_Login");
	}
	
	@Test(dataProvider = "loginData")
	public void loginTest(String data, String email, String password) {
		
			ExtendReport.testName("Opencart e-commerce application Login Test with - " +data);
			ExtendReport.assignAuthorName("Tamilselvan");
			
			submit(loginpage.getMyAccount());
			submit(loginpage.getLogin());
			sendText(loginpage.getEmailId(), email);
			sendText(loginpage.getPassword(), password);
			submit(loginpage.getLoginBtn());
			
			try {
				
				String expectedText = "Warning: No match for E-Mail Address and/or Password.";
				
				String actualText = element(Locators.xpath, 
						"//div[text()=' Warning: No match for E-Mail Address and/or Password.']").getText();
				
				if(expectedText.equals(actualText)) {
					ExtendReport.testResult("pass", "Test has been completed successfully");
				} else {
					ExtendReport.testResult("fail", "Test has been failed");
				}
			} catch (NoSuchElementException e) {
				
				String expectedTitle = "My Account";
				
				String actualTitle = getPageTitle();
				
				if(expectedTitle.equals(actualTitle)) {
					ExtendReport.testResult("pass", "Test has been completed successfully");
					submit(loginpage.getMyAccount());
					submit(loginpage.getLogout());
				} else {
					ExtendReport.testResult("fail", "Test has been failed");
				} 
				
			} 
			
	}

	
	@AfterSuite
	public void close() {
		ExtendReport.reportFlush();
		InitDriver.tearDown();
	}
	
	@DataProvider(name = "loginData")
	public String[][] getData() {
		
		String[][] Data = ReadExcel.getExcelData("Test data");
		return Data;

	}
}
