package com.appium.pages;

import com.appium.core.BasePage;

public class CliquesPage extends BasePage {

	public void executaCliqueLongo() {
		String txt = "Clique Longo";
		longClickXpathText(txt);
	}

	public void executaCliqueDuplo() {
		String txt = "Clique duplo";
		doubleClickXpathText(txt);
	}

	public void executaCliqueDuploLento() {
		String txt = "Clique duplo lento";
		slowDoubleClick(txt);
	}

	public void executaCliqueLimparLento() {
		clickByText("Limpar");
	}

	public boolean verificaCampoCliqueVazio() {
		return getTextByXpathIndex(2).isEmpty();
	}
}
