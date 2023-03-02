package com.appium.pages;

import com.appium.core.BasePage;

public class OpcaoPage extends BasePage {

	public void scrollDownTelaMenu() {
		waitForPresenceOfElement("//*[@text='Formulário']");
		scroll(0.9, 0.1);
		implicitWaitInMilisec(500);

	}
}
