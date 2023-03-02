package com.appium.pages;

import com.appium.core.BasePage;

public class CliquesPage extends BasePage {

	public void executaCliqueLongo() {
		String txt = "Clique Longo";
		longClickXpathText(txt);
		implicitWaitInMilisec(500);
	}

	public void executaCliqueDuplo() {
		String txt = "Clique duplo";
		doubleClickXpathText(txt);
		implicitWaitInMilisec(500);
	}

	public void executaCliqueDuploLento() {
		String txt = "Clique duplo lento";
		slowDoubleClick(txt);
		implicitWaitInMilisec(500);
	}

	public void executaCliqueLimparLento() {
		clickByText("Limpar");
		implicitWaitInMilisec(500);
	}

	public boolean verificaCampoCliqueVazio() {
		return getTextByXpathIndex(2).isEmpty();
	}
}
