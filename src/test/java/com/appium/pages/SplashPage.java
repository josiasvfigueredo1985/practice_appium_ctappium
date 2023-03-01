package com.appium.pages;

import org.openqa.selenium.By;

import com.appium.core.BasePage;

public class SplashPage extends BasePage {

	public void mensagemSplash() {
		getDriver().findElement(By.xpath("//*[@text='Splash']"));
	}

	public boolean isSplashVisivel() {
		return validateElementExistenceByText("Splash!");
	}

	public void aguardarSplashSumir() {
		waitForElementBeNotVisible("Splash!");
	}

}
