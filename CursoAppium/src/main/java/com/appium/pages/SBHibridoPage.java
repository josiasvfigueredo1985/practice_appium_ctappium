package com.appium.pages;

import com.appium.core.BasePage;

public class SBHibridoPage extends BasePage {

	public void email(String email) {
		digitaTexto("email", email);
	}
	public void senha(String senha) {
		digitaTexto("senha", senha);
	}
	
	public void entrar() {
		clicaPorAccessibilityId("Entrar");
	}
	
	public String verificaTextoBoasVindas() {
		return retornaTextoAtributoElemento("Bem vindo, Josias Valentim!");
	}
	
	
}
