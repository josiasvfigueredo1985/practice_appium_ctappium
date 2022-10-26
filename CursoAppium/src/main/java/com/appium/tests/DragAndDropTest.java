package com.appium.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.appium.core.BaseTest;
import com.appium.pages.DragAndDropPage;
import com.appium.pages.MenuPage;

public class DragAndDropTest extends BaseTest {

	MenuPage menu = new MenuPage();
	DragAndDropPage drag = new DragAndDropPage();

	String[] estadoInicial = { "Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para",
			"qualquer local desejado." };
	String[] estadoIntermediario = { "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para",
			"qualquer local desejado.", "Esta" };
	String[] estadoFinal = { "Fa�a um clique longo,","� uma lista", "Drag em Drop!",  "e arraste para",
			"qualquer local desejado.", "Esta" };

	@Test
	public void deveVerificarElementosArrastados() {
		menu.scrollDownTelaMenu();
		menu.selecionaDragAndDrop();
		menu.esperaNormal(500);

		assertArrayEquals(estadoInicial, drag.listaDeElementos());
		drag.arrastaSolta("Esta", "qualquer local desejado.");
		assertArrayEquals(estadoIntermediario, drag.listaDeElementos());
		
		drag.arrastaSolta("Fa�a um clique longo,", "� uma lista");
		assertArrayEquals(estadoFinal, drag.listaDeElementos());
	}

}
