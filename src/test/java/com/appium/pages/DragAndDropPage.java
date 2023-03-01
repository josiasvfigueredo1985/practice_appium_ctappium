package com.appium.pages;

import com.appium.core.BasePage;

public class DragAndDropPage extends BasePage {

	//
	public String[] listaDeElementos() {
		String[] lista = getElementsListByClassName("android.widget.TextView");
		return lista;
	}
}
