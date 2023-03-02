package com.appium.pages;

import com.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionaOpcao1() {
		clickByText("Opção 1");
		implicitWaitInMilisec(500);
	}

	public void selecionaOpcao2() {
		clickByText("Opção 2");
		implicitWaitInMilisec(500);
	}

	public void selecionaOpcao3() {
		clickByText("Opção 3");
		implicitWaitInMilisec(500);
	}

	public void selecionaOpcao4() {
		clickByText("Opção 4");
		implicitWaitInMilisec(500);
	}

	public void selecionaOpcao5() {
		clickByText("Opção 5");
		implicitWaitInMilisec(500);
	}

	public void selecionaOpcao6() {
		clickByText("Opção 6");
		implicitWaitInMilisec(500);
	}

	public boolean verificaTextoOpcao1() {
		return checkIfElementIsDisplayedByText("Esta é a descrição da opção 1");
	}

	public boolean verificaTextoOpcao2() {
		return checkIfElementIsDisplayedByText("Esta é a descrição da opção 2");
	}

	public boolean verificaTextoOpcao3() {
		return checkIfElementIsDisplayedByText(
				"Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha");
	}

	public boolean verificaTextoOpcao4() {
		return checkIfElementIsDisplayedByText("Esta é a descrição da opção 4");
	}

	public boolean verificaTextoOpcao5() {
		return checkIfElementIsDisplayedByText("Esta é a descrição da opção 5");
	}

	public boolean verificaTextoOpcao6() {
		return checkIfElementIsDisplayedByText("Esta é a descrição da opção 6");
	}
}
