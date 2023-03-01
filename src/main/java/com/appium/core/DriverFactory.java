package com.appium.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	protected static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private static void createDriver() {

		String APP = Utils.returnCurrentDir() + "/src/main/resources/CTAppium_2_0.apk";

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability("automationName", "UiAutomator1");// uiautomator2
		desiredCapabilities.setCapability("app", APP);
		// desiredCapabilities.setCapability("appPackage", "com.ctappium");//
		// desiredCapabilities.setCapability("appActivity",
		// "com.ctappium.MainActivity");
		// desiredCapabilities.setCapability("platformVersion", "8.0");
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

		// desiredCapabilities.setCapability("app", APP);
		// desiredCapabilities.setCapability("appPackage",
		// "com.google.android.permissioncontroller");//
		// desiredCapabilities.setCapability("appActivity","com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
		// In case of set permissions when an app open the first time, just add the
		// appWaitPackage and appWaitActivity capability to wait the correct app page,
		// and then after the try block add the click for the permissions page
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
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