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
		return getTextByXpathText("Confirma a operação?");
	}

	public String verificaInfoConfirmado() {
		return getTextByXpathText("Confirmado");
	}

	public String verificaInfoNegado() {
		return getTextByXpathText("Negado");
	}

	public void clicaForaDoAlertaSimples() {
		tap(13, 2000);// parentPanel
		// returnElementXYLocation("content");
	}

	public boolean verificaAlertaFechado() {
		return validateElementExistenceByText("Pode clicar no OK ou fora da caixa para sair");

	}
}
