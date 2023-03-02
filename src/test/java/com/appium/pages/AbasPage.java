package com.appium.pages;

import com.appium.core.BasePage;

public class AbasPage extends BasePage {

	public void clicarAba1() {
		clickByText("Aba 1");
		implicitWaitInMilisec(500);
	}

	public void clicarAba2() {
		clickByText("Aba 2");
		implicitWaitInMilisec(500);
	}

	public boolean verificaTextoAba1() {
		return checkIfElementIsDisplayedByText("Este é o conteúdo da Aba 1");
	}

	public boolean verificaTextoAba2() {
		return checkIfElementIsDisplayedByText("Este é o conteúdo da Aba 2");
	}
}
