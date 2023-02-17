package com.appium.pages;

import com.appium.core.BasePage;

public class SBHibridoPage extends BasePage {

	public void email(String email) {
		inputTextXpathResourceId("email", email);
	}

	public void senha(String senha) {
		inputTextXpathResourceId("senha", senha);
	}

	public void entrar() {
		clickByXpathContentDescId("Entrar");
	}

	public String verificaTextoBoasVindas() {
		return getTextByAttribute("Bem vindo, Josias Valentim!");
	}

}
