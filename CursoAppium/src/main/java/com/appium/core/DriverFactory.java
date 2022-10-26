package com.appium.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	protected static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private static void createDriver() {
				
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		//desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.ctappium");//com.ctappium
		desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");//com.ctappium.MainActivity
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/*
	 * private static void createTestObjectDriver() {
	 * 
	 * MutableCapabilities caps = new MutableCapabilities();
	 * caps.setCapability("platformName", "Android");
	 * caps.setCapability("appium:app", "com.ctappium");
	 * caps.setCapability("appium:deviceName",
	 * "Samsung Galaxy S9 HD GoogleAPI Emulator");
	 * caps.setCapability("appium:platformVersion", "8.0"); MutableCapabilities
	 * sauceOptions = new MutableCapabilities();
	 * sauceOptions.setCapability("appiumVersion", "1.20.2");
	 * caps.setCapability("sauce:options", sauceOptions); try { driver = new
	 * AndroidDriver<MobileElement>(new URL(
	 * "https://oauth-josiasvfigueredo-f1f1e:6cb481be-96df-49bb-acd7-db7836a1e97e@ondemand.us-west-1.saucelabs.com:443/wd/hub"
	 * ), caps); } catch (MalformedURLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 */
	
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}