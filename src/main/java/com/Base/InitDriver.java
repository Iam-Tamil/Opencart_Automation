package com.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Enum.browser;
import com.Utils.ConfigProperty;
import com.Utils.Constants;

public class InitDriver {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static int minWaitTime = 10;
	public static int maxWaitTime = 20;
	

	public static WebDriver launchBrowser(browser BrowserName) {
		
		ConfigProperty.loadPropertyFile(Constants.CONFIGURATION_FILEPATH);

		switch (BrowserName) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser not supported!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.get(ConfigProperty.getPropertyFile("url"));
		wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
		PageInitialize.initialize();
		
		return driver;
	}

	public static void tearDown() {
		if(driver != null) {
		driver.quit();
		}
		else {
			throw new WebDriverException("Driver not found");
		}
	}

}
