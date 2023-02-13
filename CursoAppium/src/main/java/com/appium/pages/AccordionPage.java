package com.appium.pages;

import com.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionaOpcao1() {
		clicaPorTexto("Opção 1");
	}

	public void selecionaOpcao2() {
		clicaPorTexto("Opção 2");
	}

	public void selecionaOpcao3() {
		clicaPorTexto("Opção 3");
	}

	public void selecionaOpcao4() {
		clicaPorTexto("Opção 4");
	}

	public void selecionaOpcao5() {
		clicaPorTexto("Opção 5");
	}

	public void selecionaOpcao6() {
		clicaPorTexto("Opção 6");
	}

	public boolean verificaTextoOpcao1() {
		return verificaTextoExibido("Esta é a descrição da Opção 1");
	}

	public boolean verificaTextoOpcao2() {
		return verificaTextoExibido("Esta é a descrição da Opção 2");
	}

	public boolean verificaTextoOpcao3() {
		return verificaTextoExibido("Esta é a descrição da Opção 3. Que pode, inclusive ter mais que uma linha");
	}

	public boolean verificaTextoOpcao4() {
		return verificaTextoExibido("Esta é a descrição da Opção 4");
	}

	public boolean verificaTextoOpcao5() {
		return verificaTextoExibido("Esta é a descrição da Opção 5");
	}

	public boolean verificaTextoOpcao6() {
		return verificaTextoExibido("Esta é a descrição da Opção 6");
	}
}
