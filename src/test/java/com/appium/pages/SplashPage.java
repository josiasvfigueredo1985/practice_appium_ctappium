package com.appium.pages;

import com.appium.core.BasePage;

public class SplashPage extends BasePage {

	public boolean isSplashVisivel() {
		return checkIfElementExistsByText("Splash!");
	}

	public void aguardarSplashSumir() {
		waitForElementBeNotVisible("//*[@text='Splash!']");
	}

}
