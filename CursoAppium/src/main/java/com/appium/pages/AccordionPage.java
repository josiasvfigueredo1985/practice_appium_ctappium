package com.appium.pages;

import com.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionaOpcao1() {
		clicaPorTexto("Op��o 1");
	}

	public void selecionaOpcao2() {
		clicaPorTexto("Op��o 2");
	}

	public void selecionaOpcao3() {
		clicaPorTexto("Op��o 3");
	}

	public void selecionaOpcao4() {
		clicaPorTexto("Op��o 4");
	}

	public void selecionaOpcao5() {
		clicaPorTexto("Op��o 5");
	}

	public void selecionaOpcao6() {
		clicaPorTexto("Op��o 6");
	}

	public boolean verificaTextoOpcao1() {
		return verificaTextoExibido("Esta � a descri��o da op��o 1");
	}

	public boolean verificaTextoOpcao2() {
		return verificaTextoExibido("Esta � a descri��o da op��o 2");
	}

	public boolean verificaTextoOpcao3() {
		return verificaTextoExibido("Esta � a descri��o da op��o 3. Que pode, inclusive ter mais que uma linha");
	}

	public boolean verificaTextoOpcao4() {
		return verificaTextoExibido("Esta � a descri��o da op��o 4");
	}

	public boolean verificaTextoOpcao5() {
		return verificaTextoExibido("Esta � a descri��o da op��o 5");
	}

	public boolean verificaTextoOpcao6() {
		return verificaTextoExibido("Esta � a descri��o da op��o 6");
	}
}
