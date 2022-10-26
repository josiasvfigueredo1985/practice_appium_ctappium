package com.appium.pages;

import com.appium.core.BasePage;

public class CliquesPage extends BasePage {

	public void executaCliqueLongo(){
		cliqueLongo("Clique Longo");
	}
	
	public void executaCliqueDuplo(){
		cliqueDuplo("Clique duplo");
	}
	
	public void executaCliqueDuploLento(){
		cliqueDuploLento("Clique duplo lento");
	}
	
	public void executaCliqueLimparLento(){
		clicaPorTexto("Limpar");
	}
	
	public boolean verificaCampoCliqueVazio() {
		return retornaTextoIndex(2).isEmpty();
	}
}
