package com.appium.pages;

import com.appium.core.BasePage;

public class SBHibridoPage extends BasePage {

	public void email(String email) {
		explicitWaitXpath("//*[@resource-id='email']");
		inputTextXpathResourceId("email", email);
	}

	public void senha(String senha) {
		explicitWaitXpath("//*[@resource-id='senha']");
		inputTextXpathResourceId("senha", senha);
	}

	public void entrar() {
		explicitWaitXpath("//*[@text='Entrar']");
		clickElementByXpathText("Entrar");
	}

	public String verificaTextoBoasVindas() {
		explicitWaitByXpathText("Bem vindo, Josias Valentim!");
		return getTextByAttribute("Bem vindo, Josias Valentim!");
	}

}
