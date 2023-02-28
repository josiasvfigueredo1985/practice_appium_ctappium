package com.appium.pages;

import com.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionaOpcao1() {
		clickElementByXpathText("Opção 1");
	}

	public void selecionaOpcao2() {
		clickElementByXpathText("Opção 2");
	}

	public void selecionaOpcao3() {
		clickElementByXpathText("Opção 3");
	}

	public void selecionaOpcao4() {
		clickElementByXpathText("Opção 4");
	}

	public void selecionaOpcao5() {
		clickElementByXpathText("Opção 5");
	}

	public void selecionaOpcao6() {
		clickElementByXpathText("Opção 6");
	}

	public boolean verificaTextoOpcao1() {
		return validateElementExistenceByText_2("Esta é a descrição da opção 1");
	}

	public boolean verificaTextoOpcao2() {
		return validateElementExistenceByText_2("Esta é a descrição da opção 2");
	}

	public boolean verificaTextoOpcao3() {
		return validateElementExistenceByText_2(
				"Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha");
	}

	public boolean verificaTextoOpcao4() {
		return validateElementExistenceByText_2("Esta é a descrição da opção 4");
	}

	public boolean verificaTextoOpcao5() {
		return validateElementExistenceByText_2("Esta é a descrição da opção 5");
	}

	public boolean verificaTextoOpcao6() {
		return validateElementExistenceByText_2("Esta é a descrição da opção 6");
	}
}
