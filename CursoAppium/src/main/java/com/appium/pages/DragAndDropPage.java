package com.appium.pages;

import com.appium.core.BasePage;

public class DragAndDropPage extends BasePage {

	//
	public String[] listaDeElementos() {
		String[] lista = retornaListaElementosPorClasse("android.widget.TextView");
		return lista;
	}
}
