package com.appium.pages;

import com.appium.core.BasePage;

public class AbasPage extends BasePage {

	public void clicarAba1() {
		clicaPorTexto("ABA 1");
	}

	public void clicarAba2() {
		clicaPorTexto("ABA 2");
	}
	
	public boolean verificaTextoAba1() {
		return verificaTextoExibido("Este é o conteúdo da Aba 1");
	}
	
	public boolean verificaTextoAba2() {
		return verificaTextoExibido("Este é o conteúdo da Aba 2");
	}
}
