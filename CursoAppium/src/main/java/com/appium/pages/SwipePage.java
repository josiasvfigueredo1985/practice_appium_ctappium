package com.appium.pages;

import com.appium.core.BasePage;

public class SwipePage extends BasePage {
	
	public void clicaBotaoDireita() {
		// TODO Auto-generated method stub
		clicaPorTexto(">"); 
	}
	
	public void clicaBotaoEsquerda() {
		// TODO Auto-generated method stub
		clicaPorTexto("<");  
	}
}
