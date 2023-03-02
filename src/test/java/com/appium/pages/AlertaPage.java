package com.appium.pages;

import com.appium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicaAlertaSimples() {
		clickByText("ALERTA SIMPLES");
		implicitWaitInMilisec(500);
	}

	public void clicaAlertaRestritivo() {
		clickByText("ALERTA RESTRITIVO");
		implicitWaitInMilisec(500);
	}

	public void clicaAlertaConfirm() {
		clickByText("ALERTA CONFIRM");
		implicitWaitInMilisec(500);
	}

	public void confirmarInfo() {
		clickByText("CONFIRMAR");
		implicitWaitInMilisec(500);
	}

	public void negarInfo() {
		clickByText("NEGAR");
		implicitWaitInMilisec(500);
	}

	public void sair() {
		clickByText("SAIR");
		implicitWaitInMilisec(500);
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
		return checkIfElementExistsByText("Pode clicar no OK ou fora da caixa para sair");

	}
}
