package com.appium.pages;

import com.appium.core.BasePage;

public class SwipeListPage extends BasePage {

	public void swipeOpcao1() {
		swipeList("Opção 1", 0.9, 0.1);
	}

	public void swipeOpcao2() {
		swipeList("Opção 2", 0.9, 0.1);
	}

	public void swipeOpcao3() {
		swipeList("Opção 3", 0.9, 0.1);
	}

	public void swipeOpcao4() {
		swipeList("Opção 4", 0.9, 0.1);
	}

	public void swipeOpcao5() {
		swipeList("Opção 5", 0.9, 0.1);
	}

	public void swipeOpcao6() {
		swipeList("Opção 6", 0.9, 0.1);
	}

	public void swipeOpcao7() {
		swipeList("Opção 7", 0.9, 0.1);
	}

	public void swipeOpcao8() {
		swipeList("Opção 8", 0.9, 0.1);
	}

	// Resetar
	public void swipeResetOpcao1() {
		swipeList("Opção 1", 0.1, 0.9);
	}

	public void swipeResetOpcao2() {
		swipeList("Opção 2", 0.1, 0.9);
	}

	public void swipeResetOpcao3() {
		swipeList("Opção 3", 0.1, 0.9);
	}

	public void swipeResetOpcao4() {
		swipeList("Opção 4", 0.1, 0.9);
	}

	public void swipeResetOpcao5() {
		swipeList("Opção 5", 0.1, 0.9);
	}

	public void swipeResetOpcao6() {
		swipeList("Opção 6", 0.1, 0.9);
	}

	public void swipeResetOpcao7() {
		swipeList("Opção 7", 0.1, 0.9);
	}

	public void swipeResetOpcao8() {
		swipeList("Opção 8", 0.1, 0.9);
	}

	public void clicarMais() {
		clickByElementCoordinatesXpathText("(+)");
	}

	public void clicarMenos() {
		clickByElementCoordinatesXpathText("(-)");
	}

}
