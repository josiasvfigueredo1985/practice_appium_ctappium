package com.appium.pages;

import com.appium.core.BasePage;

public class CliquesPage extends BasePage {

	public void executaCliqueLongo() {
		longClickXpathText("Clique Longo");
	}

	public void executaCliqueDuplo() {
		doubleClickXpathText("Clique duplo");
	}

	public void executaCliqueDuploLento() {
		slowDoubleClick("Clique duplo lento");
	}

	public void executaCliqueLimparLento() {
		clickElementByXpathText("Limpar");
	}

	public boolean verificaCampoCliqueVazio() {
		return retornaTextoIndex(2).isEmpty();
	}
}
