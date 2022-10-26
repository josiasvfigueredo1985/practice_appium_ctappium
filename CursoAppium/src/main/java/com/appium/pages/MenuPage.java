package com.appium.pages;

import com.appium.core.BasePage;

public class MenuPage extends BasePage {

	public void selecionaFormulario() {
		esperaImplicita(5);
		clicaPorTexto("Formul�rio");
	}

	public void selecionaSeuBarrigaH�brido() {
		esperaImplicita(2);
		clicaPorTexto("SeuBarriga H�brido");
	}
	
	public void selecionaSeuBarrigaNativo() {
		esperaImplicita(2);
		clicaPorTexto("SeuBarriga Nativo");
	}
	
	public void selecionaSplash() {
		esperaImplicita(2);
		clicaPorTexto("Splash");
	}

	public void selecionaAlerta() {
		esperaImplicita(2);
		clicaPorTexto("Alertas");
	}

	public void selecionaAbas() {
		esperaImplicita(2);
		clicaPorTexto("Abas");
	}

	public void selecionaAccordion() {
		esperaImplicita(2);
		clicaPorTexto("Accordion");
	}
	
	public void selecionaCliques() {
		esperaImplicita(2);
		clicaPorTexto("Cliques");
	}
	
	public void selecionaSwipe() {
		esperaImplicita(2);
		clicaPorTexto("Swipe");
	}
	
	public void selecionaSwipeList() {
		esperaImplicita(2);
		clicaPorTexto("Swipe List");
	}
	
	public void selecionaDragAndDrop() {
		esperaImplicita(2);
		clicaPorTexto("Drag and drop");
	}
	public void selecionaOpcaoEscondida() {
		esperaImplicita(2);
		clicaPorTexto("Op��o bem escondida");
	}
	
	public void scrollDownTelaMenu() {
		esperaExplicita("Formul�rio");
		scroll(0.9, 0.1);
	}
}
