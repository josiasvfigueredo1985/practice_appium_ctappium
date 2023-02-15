package com.appium.pages;

import com.appium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicaAlertaSimples() {
		clickElementByXpathText("ALERTA SIMPLES");
	}

	public void clicaAlertaRestritivo() {
		clickElementByXpathText("ALERTA RESTRITIVO");
	}

	public void clicaAlertaConfirm() {
		clickElementByXpathText("ALERTA CONFIRM");
	}

	public void confirmarInfo() {
		clickElementByXpathText("CONFIRMAR");
	}

	public void negarInfo() {
		clickElementByXpathText("NEGAR");
	}

	public void sair() {
		clickElementByXpathText("SAIR");
	}

	public String verificaInfoConfirma() {
		return getTextValue("Confirma a operação?");
	}

	public String verificaInfoConfirmado() {
		return getTextValue("Confirmado");
	}

	public String verificaInfoNegado() {
		return getTextValue("Negado");
	}

	public void clicaForaDoAlertaSimples() {
		tap(500, 1500);// parentPanel
		// returnElementXYLocation("content");
	}

	public boolean verificaAlertaFechado() {
		return verificaElementoPorTexto("Pode clicar no OK ou fora da caixa para sair");

	}
}
