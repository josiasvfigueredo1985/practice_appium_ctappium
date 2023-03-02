package com.appium.pages;

import com.appium.core.BasePage;

public class MenuPage extends BasePage {

	public void selecionaFormulario() {
		clickByText("Formulário");
		implicitWaitInMilisec(500);
	}

	public void selecionaSeuBarrigaHibrido() {
		clickByText("SeuBarriga Híbrido");
		implicitWaitInMilisec(500);
	}

	public void selecionaSeuBarrigaNativo() {
		clickByText("SeuBarriga Nativo");
		implicitWaitInMilisec(500);
	}

	public void selecionaSplash() {
		clickByText("Splash");
		implicitWaitInMilisec(500);
	}

	public void selecionaAlerta() {
		clickByText("Alertas");
		implicitWaitInMilisec(500);
	}

	public void selecionaAbas() {
		clickByText("Abas");
		implicitWaitInMilisec(500);
	}

	public void selecionaAccordion() {
		clickByText("Accordion");
		implicitWaitInMilisec(500);
	}

	public void selecionaCliques() {
		clickByText("Cliques");
		implicitWaitInMilisec(500);
	}

	public void selecionaSwipe() {
		clickByText("Swipe");
		implicitWaitInMilisec(500);
	}

	public void selecionaSwipeList() {
		clickByText("Swipe List");
		implicitWaitInMilisec(500);
	}

	public void selecionaDragAndDrop() {
		clickByText("Drag and drop");
		implicitWaitInMilisec(500);
	}

	public void selecionaOpcaoEscondida() {
		clickByText("Opção bem escondida");
		implicitWaitInMilisec(500);
	}

	public void scrollDownTelaMenu() {
		waitForPresenceOfElement("//*[@text='Formulário']");
		scroll(0.9, 0.1);
		implicitWaitInMilisec(500);
	}
}
