package com.appium.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.appium.core.BaseTest;
import com.appium.pages.DragAndDropPage;
import com.appium.pages.MenuPage;

public class DragAndDropTest extends BaseTest {

	MenuPage menu = new MenuPage();
	DragAndDropPage drag = new DragAndDropPage();

	String[] estadoInicial = { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para",
			"qualquer local desejado." };
	String[] estadoIntermediario = { "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para",
			"qualquer local desejado.", "Esta" };
	String[] estadoFinal = { "Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para",
			"qualquer local desejado.", "Esta" };

	@Test
	public void deveVerificarElementosArrastados() {
		menu.scrollDownTelaMenu();
		menu.selecionaDragAndDrop();

		assertArrayEquals(estadoInicial, drag.listaDeElementos());
		drag.dragAndDrop("Esta", "qualquer local desejado.");
		assertArrayEquals(estadoIntermediario, drag.listaDeElementos());

		drag.dragAndDrop("Faça um clique longo,", "é uma lista");
		assertArrayEquals(estadoFinal, drag.listaDeElementos());
	}

}
