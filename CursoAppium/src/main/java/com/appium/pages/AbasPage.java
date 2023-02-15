package com.appium.pages;

import com.appium.core.BasePage;

public class AbasPage extends BasePage {

	public void clicarAba1() {
		clickElementByXpathText("Aba 1");
	}

	public void clicarAba2() {
		clickElementByXpathText("Aba 2");
	}

	public boolean verificaTextoAba1() {
		return validateDisplayedText("Este é o conteúdo da Aba 1");
	}

	public boolean verificaTextoAba2() {
		return validateDisplayedText("Este é o conteúdo da Aba 2");
	}
}
