package com.appium.pages;

import com.appium.core.BasePage;

public class SwipePage extends BasePage {

	public void clicaBotaoDireita() {
		clickByText("›");
	}

	public void clicaBotaoEsquerda() {
		clickByText("‹");
	}
}
