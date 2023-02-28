package com.appium.pages;

import com.appium.core.BasePage;

public class MenuPage extends BasePage {

	public void selecionaFormulario() {
		implicitWaitInSecs(5);
		clickElementByXpathText("Formulário");
	}

	public void selecionaSeuBarrigaHibrido() {
		implicitWaitInSecs(2);
		clickElementByXpathText("SeuBarriga Híbrido");
	}

	public void selecionaSeuBarrigaNativo() {
		implicitWaitInSecs(2);
		clickElementByXpathText("SeuBarriga Nativo");
	}

	public void selecionaSplash() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Splash");
	}

	public void selecionaAlerta() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Alertas");
	}

	public void selecionaAbas() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Abas");
	}

	public void selecionaAccordion() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Accordion");
	}

	public void selecionaCliques() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Cliques");
	}

	public void selecionaSwipe() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Swipe");
	}

	public void selecionaSwipeList() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Swipe List");
	}

	public void selecionaDragAndDrop() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Drag and drop");
	}

	public void selecionaOpcaoEscondida() {
		implicitWaitInSecs(2);
		clickElementByXpathText("Opção bem escondida");
	}

	public void scrollDownTelaMenu() {
		explicitWaitXpath("//*[@text='Formulário']");
		scroll(0.9, 0.1);
	}
}
